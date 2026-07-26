package com.guitarradecero.preguntados_de_cero.configuration.security.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AdminSeeder implements CommandLineRunner {

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void run(String... args) {
        String password = "adminguitarradecero1234";
        PasswordEncoder encoder = this.passwordEncoder();
        encoder.encode(password);
        System.out.println("Contraseña del admin encriptada: " + encoder.encode(password));
    }
}
