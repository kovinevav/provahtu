package ru.kovynev.provahtu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
public class ProvahtuApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProvahtuApplication.class, args);
    }
    @Bean
    MultipartConfigElement multipartConfigElement() {
        DataSize size = DataSize.parse("3MB");
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(size);
        factory.setMaxRequestSize(size);
        return factory.createMultipartConfig();
    }
}
