package ru.marinin.zaklRequest.controllers;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequiredArgsConstructor
public class FileController {

    @GetMapping("/downloadRequestSampleNew")
    public ResponseEntity<byte[]> downloadRequestSampleNew() {

                Path path = Paths.get("src/main/resources/static/files/Заявка_Правила_получение.docx");

        byte[] content = null;
        try {
            content = Files.readAllBytes(path);
        } catch (final IOException e) {
        }
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE);
        httpHeaders.set(HttpHeaders.CONTENT_DISPOSITION, ContentDisposition.attachment().filename("Request_Sample_NAMI_new.docx").build().toString());
        return ResponseEntity.ok().headers(httpHeaders).body(content);
    }

    @GetMapping("/downloadRequestSampleExt")
    public ResponseEntity<byte[]> downloadRequestSampleExt() {

        Path path = Paths.get("src/main/resources/static/files/Заявка_Правила_распространение.docx");

        byte[] content = null;
        try {
            content = Files.readAllBytes(path);
        } catch (final IOException e) {
        }
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE);
        httpHeaders.set(HttpHeaders.CONTENT_DISPOSITION, ContentDisposition.attachment().filename("Request_Sample_NAMI_ext.docx").build().toString());
        return ResponseEntity.ok().headers(httpHeaders).body(content);
    }
}
