package ru.kovynev.vahta.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kovynev.vahta.entity.Company;
import ru.kovynev.vahta.entity.Review;
import ru.kovynev.vahta.rep.CompanyRepository;
import ru.kovynev.vahta.rep.ReviewRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class ReviewController {
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    ReviewRepository reviewRepository;
    Review review;
    Logger logger = LogManager.getLogger();

    @PostMapping("review")
    public String SendReview(@ModelAttribute("name") String name,
                             @ModelAttribute("review") String text,
                             @ModelAttribute("id") Long id) {
        logger.info("start review controller");
        review = new Review();
        review.setText(text);
        review.setName(name);
        //review.setDate(new Date());
        Company company = companyRepository.findById(id).orElseThrow();
        review.setCompany(company);
        reviewRepository.save(review);
        return "redirect:companies/" + id;

    }
}
