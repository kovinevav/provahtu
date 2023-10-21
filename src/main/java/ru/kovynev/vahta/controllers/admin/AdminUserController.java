package ru.kovynev.vahta.controllers.admin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kovynev.vahta.entity.UserEntity;
import ru.kovynev.vahta.rep.UserRepository;

@Controller
@RequestMapping("/admin")
public class AdminUserController {
    final
    UserRepository userRepository;
    Logger logger = LogManager.getLogger();

    public AdminUserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
@GetMapping("/all_users")
    public String showUsers(Model model){
        Iterable<UserEntity> users = userRepository.findAll();
        model.addAttribute("users", users);
        logger.info("Started AdminUserController/ShowUsers");
        return "admin/users/all_users";
    }
}
