package ru.kovynev.vahta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kovynev.vahta.entity.Vacancy;
import ru.kovynev.vahta.rep.VacanciesRepository;

import java.util.Date;

@Controller
public class VacancyController {
    @Autowired
    VacanciesRepository vacanciesRepository;

    @GetMapping("vacancies")
    public String showAll(Model model){
        model.addAttribute("vacancies", vacanciesRepository.findAll());

        return "vacancies/all_vacancies";
    }

    @PostMapping("vacancies")
    public String createVacancy(Vacancy vacancy){
        vacancy.setDate(new Date());
        vacanciesRepository.save(vacancy);
        return "vacancies/all_vacancies";
    }


    @GetMapping("vacancies/{id}")
    public String show(@PathVariable("id") Long id, Model model){
        model.addAttribute("vacancy", vacanciesRepository.findById(id).orElseThrow());

        Vacancy vacancy = vacanciesRepository.findById(id).orElseThrow();
       /* String nameOfCompany = vacancy.getCompany().getName();
        System.out.println(nameOfCompany);*/

        return "vacancies/"+id;
    }
}
