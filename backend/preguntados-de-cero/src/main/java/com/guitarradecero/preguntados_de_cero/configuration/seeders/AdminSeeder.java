package com.guitarradecero.preguntados_de_cero.configuration.seeders;

import com.guitarradecero.preguntados_de_cero.model.user.Role;
import com.guitarradecero.preguntados_de_cero.model.user.User;
import com.guitarradecero.preguntados_de_cero.persistence.sql.user.UserDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

//@Component
@RequiredArgsConstructor
public class AdminSeeder implements CommandLineRunner {

    private final UserDAO userDAO;
    private final PasswordEncoder passwordEncoder;

    @Value("${admin.email}")
    private String adminEmail;

    @Value("${admin.password}")
    private String adminPassword;

    @Override
    public void run(String... args) {
        if (userDAO.findByEmail(adminEmail).isPresent()) {
            return;
        }

        User admin = new User(adminEmail, passwordEncoder.encode(adminPassword), Role.ADMIN);
        userDAO.save(admin);
    }
}
