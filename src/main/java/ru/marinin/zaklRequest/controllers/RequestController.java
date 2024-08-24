package ru.marinin.zaklRequest.controllers;

import org.apache.kafka.common.protocol.types.Field;
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
    public String addProduct(@RequestParam String factoryName, @RequestParam String personData, @RequestParam String email, @RequestParam String type,
                             @RequestParam("pdfFileRequest") MultipartFile pdfFileRequest, @RequestParam("pdfFileOTO") MultipartFile pdfFileOTO,
                             @RequestParam String description, Model model) throws IOException {
        MultipartFileToFile.saveMultipartFile(pdfFileRequest, "../Request");
        MultipartFileToFile.saveMultipartFile(pdfFileOTO, "../Request");
        if (factoryName.isBlank() || personData.isBlank() || email.isBlank() || type.isBlank() || pdfFileRequest.isEmpty() || pdfFileOTO.isEmpty()) {
            return "redirect:/fields_error";
        }
        return "redirect:/request_answer";
    }

    @GetMapping("/request_answer")
    public String answer() {
        return "answer";
    }

    @GetMapping("/fields_error")
    public String fieldsError() {
        return "fieldsError";
    }
}
