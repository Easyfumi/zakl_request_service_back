package ru.marinin.zaklRequest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@Controller
public class RequestController {

    @GetMapping("/add")
    public String addProductForm() {
        return "addNewRequest";
    }

    @PostMapping("/add")
    public String addProduct(@RequestParam String title, @RequestParam String description, @RequestParam String price, @RequestParam String city,
                             @RequestParam String author, @RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2,
                             @RequestParam("file3") MultipartFile file3, Model model) throws IOException {

        return "redirect:/";
    }
}
