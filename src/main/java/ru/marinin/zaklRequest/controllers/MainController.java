package ru.marinin.zaklRequest.controllers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.marinin.zaklRequest.service.UserService;


@Controller
@RequiredArgsConstructor
public class MainController {
    private final UserService userService;

    @GetMapping("/account")
    public String accountController(Model model) {

    model.addAttribute("title", userService.getCurrentUser());
        return "account";
    }
    @GetMapping("/")
    private String mainController() {
        return "main";
    }
}
