package com.guitarradecero.preguntados_de_cero.model.theme;

import com.guitarradecero.preguntados_de_cero.model.difficulty.Difficulty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThemeTest {

    private Theme theme;
    private Difficulty difficulty;

    @BeforeEach
    void setUp(){
        difficulty = new Difficulty(1);
        theme = new Theme("armonizacion", "esto es una descripcion");
    }

    @Test
    void testThemeTieneNameYDescription(){
        assertEquals("armonizacion", theme.getName());
        assertEquals("esto es una descripcion", theme.getDescription());
    }

    @Test
    void testSeAsociaUnaDifficultyAUnTheme(){
        theme.addDifficulty(difficulty);

        assertEquals(1, theme.getDifficultyLevel());
    }

}