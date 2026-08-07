package com.guitarradecero.preguntados_de_cero.service.impl;


import com.guitarradecero.preguntados_de_cero.IntegrationTest;
import com.guitarradecero.preguntados_de_cero.model.difficulty.Difficulty;
import com.guitarradecero.preguntados_de_cero.model.theme.Theme;
import com.guitarradecero.preguntados_de_cero.model.difficulty.LevelRepeatException;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Testcontainers
class DifficultyServiceImplTest extends IntegrationTest {

    @Autowired
    private DifficultyServiceImpl service;

    private Difficulty difficulty;

    @BeforeEach
    void setUp() {
        difficulty = new Difficulty(1);
    }

    @Test
    void testSePersisteUnaDificultad() {
        Difficulty persistDifficulty = service.save(difficulty);

        assertNotNull(persistDifficulty.getId());

        assertEquals(difficulty, persistDifficulty);
    }

    @Test
    void testElNiveDeUnaDificultadEsUnico() {
        Difficulty persistDifficulty = service.save(new Difficulty(1));

        assertThrows(LevelRepeatException.class, () -> service.save(new Difficulty(1)));
    }

    @Test
    void testSeRecuperanTodasLasDificultades() {

        Difficulty difficulty1 = new Difficulty(2);

        Difficulty persistDifficulty = service.save(difficulty);
        Difficulty persistDifficulty1 = service.save(difficulty1);

        List<Difficulty> difficulties = service.allLevelsWithThemes();

        Difficulty foundDifficulty = difficulties.stream()
                .filter(d -> d.getId().equals(persistDifficulty.getId())).toList().getFirst();

        Difficulty foundDifficulty1 = difficulties.stream()
                .filter(d -> d.getId().equals(persistDifficulty1.getId())).toList().getFirst();

        assertEquals(persistDifficulty.getId(), foundDifficulty.getId());
        assertEquals(persistDifficulty1.getId(), foundDifficulty1.getId());
    }

    @Test
    void testSeRecuperanTodasLasDificultadesConLaDescripcionDeSusTematicas() {

        Difficulty difficulty1 = new Difficulty(1);
        Difficulty difficulty2 = new Difficulty(2);

        difficulty1.addTheme(new Theme("Acorde", "Conjunto de notas"));
        difficulty2.addTheme(new Theme("Rasgueo", "Técnica de acompañamiento"));

        service.save(difficulty1);
        service.save(difficulty2);

        List<Difficulty> difficulties = service.allLevelsWithThemes();

        Difficulty difficultyWithThemes1 = difficulties.getFirst();
        Difficulty difficultyWithThemes2 = difficulties.getLast();

        assertFalse(difficultyWithThemes1.getThemes().isEmpty());
        assertFalse(difficultyWithThemes2.getThemes().isEmpty());
    }

    @AfterEach
    void tearDown() {
        service.clearAll();
    }
}