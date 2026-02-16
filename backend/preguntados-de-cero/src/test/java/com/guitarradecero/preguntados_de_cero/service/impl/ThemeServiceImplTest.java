package com.guitarradecero.preguntados_de_cero.service.impl;

<<<<<<< HEAD
import com.guitarradecero.preguntados_de_cero.service.ThemeService;
=======
import com.guitarradecero.preguntados_de_cero.model.difficulty.Difficulty;
import com.guitarradecero.preguntados_de_cero.model.theme.Theme;
import org.junit.jupiter.api.AfterEach;
>>>>>>> 5f205d4a1738c51507b4dedac4941ca1e13c5651
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ThemeServiceImplTest {

    @Autowired
    private ThemeServiceImpl themeService;
    @Autowired
    private DifficultyServiceImpl difficultyService;

    private Difficulty persistedDifficulty1;
    private Difficulty persistedDifficulty2;

    private Theme themeA;
    private Theme themeB;
    private Theme themeC;

    @BeforeEach
    void setUp() {
        persistedDifficulty1 = difficultyService.save(new Difficulty(1));
        persistedDifficulty2 = difficultyService.save(new Difficulty(2));

        themeA = new Theme("Theme A", "Description of theme A");
        themeB = new Theme("Theme B", "Description of theme B");
        themeC = new Theme("Theme C", "Description of theme C");
    }

    @Test
    void testSePersisteUnaTematica(){

        Theme persistedThemeA = themeService.saveTheme(themeA,persistedDifficulty1.getId());

        assertNotNull(persistedThemeA.getId());

        assertEquals(themeA, persistedThemeA);
    }

    @Test
    void testSePersistenDosTematicasConLaMismaDificultad(){

        Theme persistedThemeA = themeService.saveTheme(themeA,persistedDifficulty1.getId());
        Theme persistedThemeB = themeService.saveTheme(themeB,persistedDifficulty1.getId());

        assertEquals(persistedThemeA.getDifficulty().getId(),persistedThemeB.getDifficulty().getId());
    }

    @Test
    void testSePersistenDosTematicasConDiferenteDificultad(){

        Theme persistedThemeA = themeService.saveTheme(themeA,persistedDifficulty1.getId());
        Theme persistedThemeB = themeService.saveTheme(themeB,persistedDifficulty2.getId());

        assertNotEquals(persistedThemeA.getDifficulty().getId(),persistedThemeB.getDifficulty().getId());
    }

    @Test
    void testSeRecuperanLasTematicasSegunSuDificicultad(){

        themeService.saveTheme(themeA,persistedDifficulty1.getId());
        themeService.saveTheme(themeB,persistedDifficulty2.getId());
        themeService.saveTheme(themeC,persistedDifficulty1.getId());

        List<Theme> themes = themeService.getAllByDifficulty(persistedDifficulty2.getId());

        assertNotEquals(3, themes.size());
        assertEquals(1, themes.size());
        assertEquals("Theme B", themes.getFirst().getName());
    }

    @AfterEach
    void tearDown(){
        themeService.clearAll();
        difficultyService.clearAll();
    }
}