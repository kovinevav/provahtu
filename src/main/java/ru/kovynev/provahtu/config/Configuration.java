package ru.kovynev.provahtu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.kovynev.provahtu.service.PersonDetailService;

@EnableWebSecurity
public class Configuration extends WebSecurityConfigurerAdapter {
    PersonDetailService personDetailService;

    public Configuration(PersonDetailService personDetailService) {
        this.personDetailService = personDetailService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //Конфигурируем Spring Security
        // Настройка авторизации
        http.authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/auth/login")
                .loginProcessingUrl("/process_login")
                .defaultSuccessUrl("/index", true)
                .failureUrl("/auth/login?error");
    }

    //Настройка аутентификацию
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(personDetailService)
                .passwordEncoder(getPasswordEncoder());
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
