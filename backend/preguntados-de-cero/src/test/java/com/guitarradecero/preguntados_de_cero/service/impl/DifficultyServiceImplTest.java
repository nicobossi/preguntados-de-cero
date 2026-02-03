package com.guitarradecero.preguntados_de_cero.service.impl;

import com.guitarradecero.preguntados_de_cero.model.difficulty.Difficulty;
import com.guitarradecero.preguntados_de_cero.persistence.LevelRepeatException;
import com.guitarradecero.preguntados_de_cero.service.ThemeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

        Difficulty persistDifficulty = service.save(difficulty);
        Difficulty persistDifficulty1 = service.save(new Difficulty(2));

        List<Difficulty> difficulties = service.getAll();

        Difficulty foundDifficulty = difficulties.stream().filter(d -> d.getId().equals(persistDifficulty.getId())).toList().getFirst();
        Difficulty foundDifficulty1 = difficulties.stream().filter(d -> d.getId().equals(persistDifficulty1.getId())).toList().getFirst();

        assertEquals(foundDifficulty.getId(), foundDifficulty.getId());
        assertEquals(foundDifficulty1.getId(), foundDifficulty1.getId());
    }


    @AfterEach
    void tearDown() {
        service.clearAll();
    }
}