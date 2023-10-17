package ru.kovynev.vahta.controllers.admin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kovynev.vahta.entity.Company;
import ru.kovynev.vahta.entity.Vacancy;
import ru.kovynev.vahta.rep.CompanyRepository;
import ru.kovynev.vahta.rep.VacanciesRepository;

import java.util.Date;

@Controller
public class AdminVacanciesController {
    Logger logger = LogManager.getLogger();
    @Autowired
    VacanciesRepository vacanciesRepository;
    @Autowired
    CompanyRepository companyRepository;



    @GetMapping("admin/vacancies")
    public String showvacancies(Model model) {
        Iterable<Vacancy> vacancies = vacanciesRepository.findAll();
        model.addAttribute("vacancies", vacancies);
        return "admin/vacancies/all_vacancies";
    }


    @GetMapping("admin/vacancies/new/{id}")
    public String newVacancy(Model model,
                               @PathVariable("id") long id) {
        Vacancy vacancy = new Vacancy();
        vacancy.setIdOfCompany(id);
        vacancy.setCompany(companyRepository.findById(id).orElseThrow());
        model.addAttribute("vacancy", vacancy);
        return "admin/vacancies/new_vacancy";
    }

    @PostMapping("admin/vacancies")
    public String createVacancy(@ModelAttribute("vacancy") Vacancy vacancy){
        vacancy.setDate(new Date());
        vacanciesRepository.save(vacancy);
        return "redirect:/admin/vacancies";
    }

    @DeleteMapping("admin/vacancies/{id}")
    public String delete(@PathVariable(value = "id") long id){
        Vacancy vacancy = vacanciesRepository.findById(id).orElseThrow();
        vacanciesRepository.delete(vacancy);
        return "redirect:/admin/vacancies";
    }
    @PatchMapping("admin/vacancies/{id}")
    public String update(@PathVariable(value = "id") long id, @ModelAttribute("vacancy") Vacancy vacancy){
        vacancy.setId(id);
        vacanciesRepository.save(vacancy);
        return  "redirect:/admin/vacancies";
    }

    @GetMapping("admin/vacancies/{id}/edit")
    public String editVacancy(@PathVariable(value = "id") long id, Model model) {
             Vacancy vacancy = vacanciesRepository.findById(id).orElseThrow();
        model.addAttribute("vacancy", vacancy);
        return "admin/vacancies/edit_vacancy";
    }
}

