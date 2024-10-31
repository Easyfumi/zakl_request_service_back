package ru.marinin.zaklRequest.security;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;

import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.marinin.zaklRequest.repository.UserRepository;


import java.util.List;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    final UserRepository userRepository;



    @Bean
    UserDetailsService userDetailsService() {
        return username -> {
          //  System.out.println(username+" AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
            ru.marinin.zaklRequest.model.User user = userRepository.findByUsername(username);
            //System.out.println(todoUser.getPassword());
            if (user != null) {

                //System.out.println(role.getClass());
                var x = user.getRoles().stream().toList().getFirst();

                User user1 = new User(user.getUsername(), user.getPassword(), List.of(x));
                System.out.println(user1);
                return user1;
            }

            return null;
        };
    }



    @Bean
    @SneakyThrows
    public SecurityFilterChain securityFilterChain(HttpSecurity http, AuthenticationConfiguration authenticationConfiguration) {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/registration", "/login", "/logout", "/", "/account").permitAll();
                    auth.requestMatchers("/add").hasAnyAuthority("USER");
                //    auth.requestMatchers().hasAnyAuthority("ADMIN");
                })
                .formLogin(formLogin ->
                        formLogin
                                .loginPage("/login")
                                .permitAll()
                )
                .logout(logout -> logout.logoutUrl("/logout").permitAll())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(c -> c.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
