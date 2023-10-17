package ru.kovynev.vahta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonalPageController {


    @GetMapping("/personalpage")
    public String showPage(Model model, SecurityContextHolder holder){
        model.addAttribute("holder", holder);
        System.out.println(holder.getContext().getAuthentication().getName());

        return "personalpage/personalpage";
    }
}

