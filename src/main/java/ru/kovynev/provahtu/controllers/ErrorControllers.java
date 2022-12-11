package ru.kovynev.provahtu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorControllers {
    @RequestMapping("/404.html")
    public String render404(Model model) {
        // Add model attributes
        return "error/404";
    }
    @RequestMapping("/405.html")
    public String render405(Model model) {
        // Add model attributes
        return "error/405";
    }
}
