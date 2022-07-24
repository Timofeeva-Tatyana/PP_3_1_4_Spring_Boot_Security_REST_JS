package ru.kata.PP_3_1_4_Spring_Boot_Security_REST_JS.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kata.PP_3_1_4_Spring_Boot_Security_REST_JS.model.User;

@Controller
public class UserController {

    @GetMapping("/user")
    public String userHomePage(Model model) {
        User user = (User) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        return "user_panel";
    }
}
