package ru.marinin.zaklRequest.model;


import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Data
public class Request {
    private String factoryName;
    private String personData;
    private String email;
    private MultipartFile pdfFile;
    private MultipartFile zipFile;
    private String description;
    private LocalDateTime localDateTime;

    public Request(String factoryName, String personData, String email, MultipartFile pdfFile, MultipartFile zipFile, String description) {
        this.factoryName = factoryName;
        this.personData = personData;
        this.email = email;
        this.pdfFile = pdfFile;
        this.zipFile = zipFile;
        this.description = description;
        this.localDateTime = LocalDateTime.now();
    }
}
