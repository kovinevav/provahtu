package ru.kovynev.provahtu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kovynev.provahtu.entities.Resume;
import ru.kovynev.provahtu.entities.User;
import ru.kovynev.provahtu.service.RegistrationService;
import ru.kovynev.provahtu.util.PersonValidator;

import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class AuthControllers {
    final
    PersonValidator personValidator;
    final
    RegistrationService registrationService;

    public AuthControllers(PersonValidator personValidator, RegistrationService registrationService) {
        this.personValidator = personValidator;
        this.registrationService = registrationService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }

    public String registrationVacancy(@ModelAttribute("user") Resume resume) {
        return "vacancy/newVacancy";
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("user") User user) {
        return "auth/registration";
    }

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        personValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) return "auth/registration";
        registrationService.register(user);
        return "redirect:/auth/login";
    }
}


