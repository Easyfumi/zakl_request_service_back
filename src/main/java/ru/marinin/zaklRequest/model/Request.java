package ru.marinin.zaklRequest.model;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Request {
    private String nameFactory;
    private String email;
    private String linkPDF;
    private String linkZIP;
    private String comment;
    private LocalDateTime localDateTime;

    public Request(String nameFactory, String email, String linkPDF, String linkZIP, String comment) {
        this.nameFactory = nameFactory;
        this.email = email;
        this.linkPDF = linkPDF;
        this.linkZIP = linkZIP;
        this.comment = comment;
        this.localDateTime = LocalDateTime.now();
    }
}
