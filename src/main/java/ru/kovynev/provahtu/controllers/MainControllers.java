package ru.kovynev.provahtu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kovynev.provahtu.rep.VacancyRepository;
import ru.kovynev.provahtu.service.VacancyService;

@Controller
public class MainControllers {
    final
    VacancyService vacancyService;
    @Autowired
    VacancyRepository vacancyRepository;


    public MainControllers(VacancyService vacancyService) {
        this.vacancyService = vacancyService;
    }

    @GetMapping("/")
    public String toIndex(){
        return "redirect:index";
    }


    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("vacancies", vacancyRepository.findAll());
        model.addAttribute("enter", "Войти");
        return "index";
    }

    @GetMapping("/authentication")
    public String authenticate() {
        return "authenticate";
    }


}
