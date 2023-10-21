package ru.kovynev.vahta.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kovynev.vahta.entity.Company;
import ru.kovynev.vahta.rep.CompanyRepository;
import ru.kovynev.vahta.rep.VacanciesRepository;

@Controller
public class Admin {
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    VacanciesRepository vacanciesRepository;


    @GetMapping("/listofcompanies")
    public String showListOfCompanies(Model model){
        Iterable<Company> companies = companyRepository.findAll();
        model.addAttribute("companies", companies);
        return "/adminpanels/listofcompanies";
    }

    @GetMapping("/admin")
    public String openAdminsPage(Model model){
        System.out.println("Came as Admin");
        Iterable<Company> companies = companyRepository.findAll();
        model.addAttribute("companies",companies);
        return "admin/admin_panel";
    }
    @GetMapping("/administrator")
    public String goToAdmin(){
        return "redirect:admin";
    }
}
