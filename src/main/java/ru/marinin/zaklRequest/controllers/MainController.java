package ru.marinin.zaklRequest.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.marinin.zaklRequest.model.Message;
import ru.marinin.zaklRequest.service.MyKafkaSender;


@Controller
public class MainController {

    @GetMapping("/")
    public String mainController() {
        return "main";
    }
}
