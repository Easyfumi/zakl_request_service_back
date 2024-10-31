package ru.marinin.zaklRequest.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.marinin.zaklRequest.model.User;
import ru.marinin.zaklRequest.service.UserService;


@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String createUser(User user) {
        System.out.println(user);
        userService.createUser(user);
        return "redirect:/account";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
