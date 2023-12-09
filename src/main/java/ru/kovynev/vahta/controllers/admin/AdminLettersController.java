package ru.kovynev.vahta.controllers.admin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kovynev.vahta.entity.Letter;
import ru.kovynev.vahta.entity.News;
import ru.kovynev.vahta.rep.LetterRepository;
import ru.kovynev.vahta.rep.NewsRepository;

@Controller
public class AdminLettersController {
    Logger logger = LogManager.getLogger();
    @Autowired
    LetterRepository letterRepository;


    @GetMapping("admin/letters")
    public String showLetters(Model model) {
        Iterable<Letter> letters = letterRepository.findAll();
        model.addAttribute("letters", letters);
        return "admin/letters/all_letters";
    }


    @GetMapping("admin/letter/{id}")
    public String readLetter(@PathVariable(value = "id") long id, Model model) {
        Letter letter= letterRepository.findById(id).orElseThrow();
        model.addAttribute("letter", letter);
        return "admin/letters/letter";
    }


    @DeleteMapping("admin/letter/{id}")
    public String delete(@PathVariable(value = "id") long id) {
        Letter letter = letterRepository.findById(id).orElseThrow();
        letterRepository.delete(letter);
        return "redirect:/admin/letters";
    }
/*





    @GetMapping("admin/news/new")
    public String createNewNews(Model model) {
        model.addAttribute("news", new News());
        return "admin/news/new_news";
    }

    @PostMapping("admin/news")
    public String createNews(@ModelAttribute("news") News news) {
        //news.setDate(new Date());
        newsRepository.save(news);
        return "redirect:/admin/news";
    }*/

}
