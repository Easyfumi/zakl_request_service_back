package ru.marinin.zaklRequest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.marinin.zaklRequest.service.MultipartFileToFile;

import java.io.IOException;
import java.nio.file.Path;

@Controller
public class RequestController {

    @GetMapping("/add")
    public String addProductForm() {
        return "addNewRequest";
    }

    @PostMapping("/add")
    public String addProduct(@RequestParam String factoryName, @RequestParam String personData, @RequestParam String email,
                             @RequestParam("pdfFile") MultipartFile pdfFile, @RequestParam("zipFile") MultipartFile zipFile,
                             @RequestParam String description, Model model) throws IOException {
        MultipartFileToFile.saveMultipartFile(pdfFile, "../Request");
        MultipartFileToFile.saveMultipartFile(zipFile, "../Request");
        return "redirect:/";
    }
}
