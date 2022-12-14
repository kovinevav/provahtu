package ru.kovynev.provahtu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.kovynev.provahtu.entities.Resume;
import ru.kovynev.provahtu.service.ResumeService;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;


@Controller
@RequestMapping("/resume")
public class ResumeControllers {
    final
    ResumeService resumeService;

    public ResumeControllers(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @GetMapping("/new")
    public String newResume(Model model) {
        model.addAttribute("resume", new Resume());
        return "new_resume";
    }

    @PostMapping
    public String addResume(@RequestParam("file") MultipartFile file,
                            @ModelAttribute("resume") Resume resume) {
        resumeService.addResume(resume);

        if (!file.isEmpty()) {
            byte[] bytes = new byte[0];
            try {
                bytes = file.getBytes();
                Path path = Path.of("src/main/resources/static/photo/" + resume.getId_resume());
                Files.createDirectories(path);
                path = path.resolve("handsome.jpg");
                Files.write(path, bytes);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return "index";
    }
@GetMapping()
    public String showAllVacancies(Model model){
        model.addAttribute("listResume", resumeService.findAll());
        System.out.println("resumecontroller");
        return "resume/resumes";
    }

}