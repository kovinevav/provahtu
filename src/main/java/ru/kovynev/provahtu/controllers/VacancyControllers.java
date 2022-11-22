package ru.kovynev.provahtu.controllers;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kovynev.provahtu.entities.Vacancy;
import ru.kovynev.provahtu.service.VacancyService;

import java.util.ArrayList;

@Controller
@RequestMapping("/vacancy")
public class VacancyControllers {
    final VacancyService vacancyService;
  

    public VacancyControllers(VacancyService vacancyService) {
        this.vacancyService = vacancyService;

    }

    @GetMapping("/new")
    public String newVacancy(Model model) {
        model.addAttribute("vacancy", new Vacancy());
        return "vacancy/newVacancy";
    }

    @PostMapping()
    public String vacancy(@ModelAttribute("vacancy") Vacancy vacancy) {
        vacancyService.addVacancy(vacancy);
        return "redirect:provahtu";
    }

    @GetMapping("/search")
    public String vacancies(Model model, @RequestParam("search") String name){
        model.addAttribute("listVacancies", vacancyService.findAllByName(name));
        return "vacancy/vacancies";
    }
    @GetMapping()
    public String showAllVacancies(Model model){
       model.addAttribute("listVacancies", vacancyService.findAll());
        return "vacancy/vacancies";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id")Long id, Model model){
        model.addAttribute("vacancy", vacancyService.findById(id));
        return "vacancy/vacancy";
    }
}
