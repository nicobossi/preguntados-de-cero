package com.guitarradecero.preguntados_de_cero.model.nivel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DificultadTest {

    private Difficulty dificultad;

    @BeforeEach
    void setUp() {
        dificultad = new Difficulty(1);
    }

    @Test
    void testUnaDificultadTieneUnNivel() {
        assertEquals(1, dificultad.getLevel());
    }
}