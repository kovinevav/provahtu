package ru.kovynev.vahta.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kovynev.vahta.entity.Post;


@Controller
public class VkController {
    @Autowired
    /*VkClient vkClient;*/

 /*   @GetMapping("/admin/vk/post")
    public String newPost(Model model) {
        model.addAttribute("post", new Post());
        return "admin/vk/new_post";
    }*/

    @PostMapping("/admin/vk")
    public String createPost(@ModelAttribute("post") Post post) {
       /* vkClient.send(post);*/

        return "redirect:/administrator";
    }
}
