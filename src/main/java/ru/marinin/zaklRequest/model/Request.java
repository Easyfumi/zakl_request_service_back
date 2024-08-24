package ru.marinin.zaklRequest.model;


import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Data
public class Request {
    private String factoryName;
    private String personData;
    private String email;
    private String type;
    private MultipartFile pdfFileRequest;
    private MultipartFile pdfFileOTO;
    private String description;
    private LocalDateTime localDateTime;

    public Request(String factoryName, String personData, String email, String type, MultipartFile pdfFileRequest, MultipartFile pdfFileOTO, String description) {
        this.factoryName = factoryName;
        this.personData = personData;
        this.email = email;
        this.type = type;
        this.pdfFileRequest = pdfFileRequest;
        this.pdfFileOTO = pdfFileOTO;
        this.description = description;
        this.localDateTime = LocalDateTime.now();
    }
}
