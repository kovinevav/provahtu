package ru.kovynev.provahtu.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.kovynev.provahtu.entities.User;
import ru.kovynev.provahtu.service.PersonDetailService;

@Component
public class PersonValidator implements Validator {
    private final PersonDetailService personDetailService;


    public PersonValidator(PersonDetailService personDetailService) {
        this.personDetailService = personDetailService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        try{
            personDetailService.loadUserByUsername(user.getUserEmail());
        } catch (UsernameNotFoundException ignore){
            return;
        }
        errors.rejectValue("username","", "Учётная запись с таким e-mail уже существует");
    }
}
