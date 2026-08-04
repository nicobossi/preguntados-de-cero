package com.guitarradecero.preguntados_de_cero.configuration.seeders;

import com.guitarradecero.preguntados_de_cero.model.user.User;
import com.guitarradecero.preguntados_de_cero.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class AdminSeeder implements CommandLineRunner {

    private final UserService userService;

    @Value("${admin.email}")
    private String adminEmail;

    @Value("${admin.password}")
    private String adminPassword;

    @Override
    public void run(String... args) {
        if (userService.existsByEmail(adminEmail)) {
            return;
        }
        userService.add(new User(adminEmail, adminPassword));
        log.info("Admin ready!");
    }
}
