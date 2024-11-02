package ru.marinin.zaklRequest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.marinin.zaklRequest.model.Request;
import ru.marinin.zaklRequest.model.RequestForConsumer;
import ru.marinin.zaklRequest.repository.RequestRepository;

@Service
@RequiredArgsConstructor
public class RequestService {

    private final RequestRepository requestRepository;

    public void saveNewRequest(Request request) {
        requestRepository.save(request);
    }

    public boolean saveRequest(Request request) {
        Request savedRequest = requestRepository.save(request);
        if (savedRequest.getId()!=0) {
            System.out.println("new request saved with id: " + savedRequest.getId());
            return true;
        } else {
            return false;
        }
    }
}
