package com.guitarradecero.preguntados_de_cero.model.difficulty;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DifficultyTest {

    private Difficulty difficulty;

    @BeforeEach
    void setUp() {
        difficulty = new Difficulty(1);
    }

    @Test
    void testUnaDificultadTieneUnNivel() {
        assertEquals(1, difficulty.getLevel());
    }
}