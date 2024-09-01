package ru.marinin.zaklRequest.controllers;

import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.marinin.zaklRequest.model.Request;
import ru.marinin.zaklRequest.service.MultipartFileToFile;
import ru.marinin.zaklRequest.service.MyKafkaSender;

import java.io.IOException;
import java.nio.file.Path;

@Controller
public class RequestController {
    @Autowired
    MyKafkaSender kafkaSender;

    @GetMapping("/add")
    public String addProductForm() {
        return "addNewRequest";
    }

    @PostMapping("/add")
    public String addProduct(@RequestParam String factoryName, @RequestParam String personData, @RequestParam String email, @RequestParam String type,
                             @RequestParam("fileRequest") MultipartFile fileRequest, @RequestParam("fileOTO") MultipartFile fileOTO,
                             @RequestParam String description, Model model) throws IOException {

        System.out.println(fileRequest.getContentType());
        System.out.println(fileOTO.getContentType());

        //   application/pdf
        //   application/vnd.openxmlformats-officedocument.wordprocessingml.document
        //   application/msword

        if (fileRequest.getContentType() == null || fileOTO.getContentType() == null) {
            return "redirect:/fields_error";
        }

        if (!(fileRequest.getContentType().startsWith("application/pdf")
                || fileRequest.getContentType().startsWith("application/vnd.openxmlformats-officedocument")
                || fileRequest.getContentType().startsWith("application/msword"))) {
            return "redirect:/fields_error";
        }

        if (!(fileOTO.getContentType().startsWith("application/pdf")
                || fileOTO.getContentType().startsWith("application/vnd.openxmlformats-officedocument")
                || fileOTO.getContentType().startsWith("application/msword"))) {
            return "redirect:/fields_error";
        }

        String pathToFileRequest = MultipartFileToFile.saveMultipartFile(fileRequest, "../Request");
        String pathToFileOTO = MultipartFileToFile.saveMultipartFile(fileOTO, "../Request");

        if (factoryName.isBlank() || personData.isBlank() || email.isBlank() || type.isBlank() || fileRequest.isEmpty() || fileOTO.isEmpty()) {
            return "redirect:/fields_error";
        } else {
            Request request = new Request.Builder()
                    .factoryName(factoryName)
                    .personData(personData)
                    .email(email)
                    .type(type)
                    .pathToFileRequest(pathToFileRequest)
                    .pathToFileOTO(pathToFileOTO)
                    .description(description)
                    .build();
            System.out.println(request);
            kafkaSender.sendMessage(request, "request_topic");
            return "redirect:/request_answer";
        }
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
