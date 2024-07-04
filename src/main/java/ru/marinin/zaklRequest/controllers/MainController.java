package ru.marinin.zaklRequest.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.marinin.zaklRequest.model.Request;
import ru.marinin.zaklRequest.service.impl.RequestServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("v1/request")
@RequiredArgsConstructor
public class MainController {

    private final RequestServiceImpl zaklRequestModelService;

    public ResponseEntity<Request> createReuest(@RequestBody Request zaklRequestModel) {

        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }
}
