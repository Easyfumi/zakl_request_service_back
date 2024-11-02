package ru.marinin.zaklRequest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.marinin.zaklRequest.model.Request;

public interface RequestRepository extends JpaRepository<Request, Long> {
}
