package com.guitarradecero.preguntados_de_cero.service.impl;

import com.guitarradecero.preguntados_de_cero.model.nivel.Difficulty;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DifficultyServiceImplTest {

    @Autowired
    private DifficultyServiceImpl service;

    private Difficulty difficulty;

    @BeforeEach
    void setUp() {
        difficulty = new Difficulty(1);
    }

    @Test
    void testSePersisteUnaDificultad() {
        Difficulty persistDifficulty = service.saveDifficulty(difficulty);

        assertNotNull(persistDifficulty.getId());

        assertEquals(difficulty, persistDifficulty);
    }


    @AfterEach
    void tearDown() {
        service.clearAll();
    }
}