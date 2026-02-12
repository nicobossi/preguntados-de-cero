package com.guitarradecero.preguntados_de_cero.model.difficulty;

import com.guitarradecero.preguntados_de_cero.model.theme.Theme;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void testUnaDificultadAgregaUnaTematica() {
        Theme theme = new Theme("Acorde", "Conjunto de notas");

        difficulty.addTheme(theme);

        assertFalse(difficulty.getThemes().isEmpty());
    }

    @Test
    void testCuandoUnaDificultadAgregaUnaTematica_LaTematicaAsociaLaDificultad() {
        Theme theme = new Theme("Acorde", "Conjunto de notas");

        difficulty.addTheme(theme);

        assertNotNull(theme.getDifficulty());
    }

}