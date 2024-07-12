package ru.marinin.zaklRequest.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.File;


@Controller
public class MainController {
    @GetMapping("/")
    public String mainController() {

        return "main";
    }
}
