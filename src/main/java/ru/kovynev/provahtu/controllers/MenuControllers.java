package ru.kovynev.provahtu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/provahtu")
public class MenuControllers {

    @GetMapping("/vacancies")
    public String vacancies(){
        return "vacancies";
    }
    @GetMapping("/resumes")
    public String resumes(){
        return "resumes";
    }

    @GetMapping("/search")
    public String search(@RequestParam("search") String search){
        return "search";
    }
}
