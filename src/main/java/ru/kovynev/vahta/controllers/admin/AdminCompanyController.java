package ru.kovynev.vahta.controllers.admin;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kovynev.vahta.entity.Company;
import ru.kovynev.vahta.rep.CompanyRepository;
import ru.kovynev.vahta.rep.ReviewRepository;


@Controller
@RequestMapping("/admin/companies")
public class AdminCompanyController {
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    ReviewRepository reviewRepository;
    Logger logger = LogManager.getLogger();

    @GetMapping("/new")
    public String addCompany(Model model) {
        model.addAttribute("company", new Company());
        return "add_company";
    }

    @PostMapping("")
    public String addcompany(@ModelAttribute("company") Company company) {
        companyRepository.save(company);
        return "redirect:/administrator";
    }

    @GetMapping("/{id}/edit")
    public String editCompany(@PathVariable(value = "id") long id, Model model) {
        Company company = companyRepository.findById(id).orElseThrow();
        model.addAttribute("company", company);

        return "admin/companies/edit_company";
    }



    @PatchMapping("/{id}")
    public String update(@PathVariable(value = "id") long id, @ModelAttribute("company") Company company){
        company.setId(id);
        companyRepository.save(company);
        return  "redirect:/administrator";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable(value = "id") long id, @ModelAttribute("company") Company updatedcompany) {
        Company company = companyRepository.findById(id).orElseThrow();
        companyRepository.delete(company);
        return "redirect:/administrator";
    }




}
