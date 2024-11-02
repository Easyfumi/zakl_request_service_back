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

    @GetMapping("/lk")
    public String accountController(Model model) {
    model.addAttribute("user", userService.getCurrentUser());
        return "account";
    }
    @GetMapping("/")
    private String mainController() {
        return "main";
    }
}
