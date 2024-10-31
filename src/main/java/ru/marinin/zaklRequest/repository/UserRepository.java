package ru.marinin.zaklRequest.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.marinin.zaklRequest.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
