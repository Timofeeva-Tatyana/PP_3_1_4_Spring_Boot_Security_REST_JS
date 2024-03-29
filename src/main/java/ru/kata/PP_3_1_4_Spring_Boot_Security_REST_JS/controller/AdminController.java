package ru.kata.PP_3_1_4_Spring_Boot_Security_REST_JS.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kata.PP_3_1_4_Spring_Boot_Security_REST_JS.model.User;

@Controller
public class AdminController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/admin")
    public String index(Model model) {
        User thisUser = (User) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        model.addAttribute("thisUser", thisUser);
        return "admin_panel";
    }


}
