package ru.marinin.zaklRequest.service.impl;

import org.springframework.stereotype.Service;
import ru.marinin.zaklRequest.model.Request;
import ru.marinin.zaklRequest.service.RequestService;

import java.time.LocalDateTime;
@Service
public class RequestServiceImpl implements RequestService {

    @Override
    public Request createRequest(Request request) {
        request.setLocalDateTime(LocalDateTime.now());
        return request;
    }
}
