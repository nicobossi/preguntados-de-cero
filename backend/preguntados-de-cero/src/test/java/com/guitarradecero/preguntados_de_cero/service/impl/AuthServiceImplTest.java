package com.guitarradecero.preguntados_de_cero.service.impl;

import com.guitarradecero.preguntados_de_cero.IntegrationTest;
import com.guitarradecero.preguntados_de_cero.model.user.User;
import com.guitarradecero.preguntados_de_cero.service.exception.NotFoundException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Testcontainers
/*@ActiveProfiles("test")*/
class AuthServiceImplTest extends IntegrationTest {
    @Autowired
    private UserServiceImpl service;

    private User user;

    @BeforeEach
    void setUp() {
        user = new User("a@gmail.com", "123");
    }

    @Test
    void testSeAgregaUnUsuario() {
        User addedUser = service.add(user);
        assertNotNull(addedUser.getId());
    }

    @Test
    void testSeRecuperaUnUsuarioPorSusCredenciales() {
        User addedUser = service.add(user);
        User newUser = service.getByEmail(addedUser.getEmail());
        assertEquals(newUser.getEmail(), addedUser.getEmail());
    }

    @Test
    void testSiSeBuscaConUnEmailNoRegistrado_LanzaExcepcion() {
        assertThrows(NotFoundException.class, () -> service.getByEmail("d@gmail.com"));
    }

    @AfterEach
    void tearDownEach() {
        service.clearAll();
    }
}