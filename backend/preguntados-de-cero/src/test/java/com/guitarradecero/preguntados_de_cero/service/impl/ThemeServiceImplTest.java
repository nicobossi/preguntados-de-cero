package com.guitarradecero.preguntados_de_cero.service.impl;

import com.guitarradecero.preguntados_de_cero.model.difficulty.Difficulty;
import com.guitarradecero.preguntados_de_cero.model.theme.Theme;
import com.guitarradecero.preguntados_de_cero.service.DifficultyService;
import com.guitarradecero.preguntados_de_cero.service.ThemeService;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ThemeServiceImplTest {
    @Autowired
    private ThemeService themeService;

    private Difficulty difficulty1;
    private Difficulty difficulty2;
    private Difficulty difficulty3;

    private Theme theme1;
    private Theme theme2;
    private Theme theme3;
    private Theme theme4;

    @BeforeEach
    void setUp() {
        difficulty1 = new Difficulty(1);
        difficulty2 = new Difficulty(2);
        difficulty3 = new Difficulty(3);

    }
}