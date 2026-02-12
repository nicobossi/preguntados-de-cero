package com.guitarradecero.preguntados_de_cero.service.impl;

import com.guitarradecero.preguntados_de_cero.dto.difficulty.DifficultyDescription;
import com.guitarradecero.preguntados_de_cero.model.difficulty.Difficulty;
import com.guitarradecero.preguntados_de_cero.model.theme.Theme;
import com.guitarradecero.preguntados_de_cero.persistence.LevelRepeatException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
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

        List<DifficultyDescription> difficulties = service.allLevelsWithDescription();

        DifficultyDescription foundDifficulty = difficulties.stream().filter(d -> d.getId().equals(persistDifficulty.getId())).toList().getFirst();
        DifficultyDescription foundDifficulty1 = difficulties.stream().filter(d -> d.getId().equals(persistDifficulty1.getId())).toList().getFirst();

        assertEquals(foundDifficulty.getId(), foundDifficulty.getId());
        assertEquals(foundDifficulty1.getId(), foundDifficulty1.getId());
    }


    @Test
    void testSeRecuperanTodasLasDificultadesConLaDescripcionDeSusTematicas() {

        Difficulty difficulty1 = new Difficulty(1);
        Difficulty difficulty2 = new Difficulty(2);

        difficulty1.addTheme(new Theme("Acorde", "Conjunto de notas"));
        difficulty2.addTheme(new Theme("Rasgueo", "Técnica de acompañamiento"));

        service.save(difficulty1);
        service.save(difficulty2);

        List<DifficultyDescription> difficulties = service.allLevelsWithDescription();

        DifficultyDescription description1 = difficulties.getFirst();
        DifficultyDescription description2 = difficulties.getLast();

        assertFalse(description1.getThemeNames().stream().toList().isEmpty());
        assertFalse(description2.getThemeNames().stream().toList().isEmpty());
    }


    @AfterEach
    void tearDown() {
        service.clearAll();
    }
}