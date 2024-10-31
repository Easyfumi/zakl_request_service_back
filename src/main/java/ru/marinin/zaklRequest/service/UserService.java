package ru.marinin.zaklRequest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.marinin.zaklRequest.model.User;
import ru.marinin.zaklRequest.model.enums.Role;
import ru.marinin.zaklRequest.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public boolean createUser(User user) {
        String login = user.getUsername();
        if (userRepository.findByUsername(login)!=null) {
            System.out.println("ALREADY EXIST");
            return false;
        } else {
            user.setActive(true);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.getRoles().add(Role.USER);
            System.out.println("Saving new user with login: " + login + ".");
            System.out.println(user);
            userRepository.save(user);
            return true;
        }
    }

    public String getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getName());
        return authentication.getName();
    }
}
