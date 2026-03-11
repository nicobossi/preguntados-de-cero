package com.guitarradecero.preguntados_de_cero.service.impl;

import com.guitarradecero.preguntados_de_cero.IntegrationTest;
import com.guitarradecero.preguntados_de_cero.dto.question.QuestionWithOptions;
import com.guitarradecero.preguntados_de_cero.model.difficulty.Difficulty;
import com.guitarradecero.preguntados_de_cero.model.option.CorrectOption;
import com.guitarradecero.preguntados_de_cero.model.option.FailOption;
import com.guitarradecero.preguntados_de_cero.model.option.Option;
import com.guitarradecero.preguntados_de_cero.model.option.RepeatedStatementOptionException;
import com.guitarradecero.preguntados_de_cero.model.question.Question;
import com.guitarradecero.preguntados_de_cero.model.question.RepeatedCorrectOptionException;
import com.guitarradecero.preguntados_de_cero.model.theme.Theme;
import com.guitarradecero.preguntados_de_cero.service.exception.NotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Testcontainers
@ActiveProfiles("test")
class QuestionServiceImplTest extends IntegrationTest {

    @Autowired
    private QuestionServiceImpl service;

    @Autowired
    private ThemeServiceImpl themeService;

    @Autowired
    private DifficultyServiceImpl difficultyService;

    private Difficulty difficulty;

    private Theme theme;

    @BeforeEach
    void setUp() {
        difficulty = new Difficulty(17);
        theme = new Theme("Plaqué", "Forma de tocar acordes donde las notas se separan entre bajo y notas agudas");
    }

    @Test
    void testSeGuardaUnaPregunta() {

        Difficulty persistDifficulty = difficultyService.save(difficulty);

        Theme persistTheme = themeService.saveTheme(theme, persistDifficulty.getId());

        Question question = new Question("Pregunta");

        Question persistQuestion = service.add(question, persistTheme.getId(), new ArrayList<>());

        assertNotNull(persistQuestion.getId());
    }

    @Test
    void testSiSeGuardaUnaPreguntaConUnaTematicaNoRegistrada_SeLanzaExcepcion() {

        Theme theme = new Theme("Arpegio", "Forma de tocar acordes donde las notas son tocadas una por una");

        Question question = new Question("Pregunta");

        assertThrows(NotFoundException.class, () -> service.add(question, 8L, new ArrayList<>()));
    }

    @Test
    void testSeRecuperanTodasLasPreguntasDeUnaTematica() {

        Difficulty persistDifficulty = difficultyService.save(difficulty);

        Theme persistTheme = themeService.saveTheme(theme, persistDifficulty.getId());

        Question question = new Question("Pregunta");

        service.add(question, persistTheme.getId(), new ArrayList<>());

        List<QuestionWithOptions> questions = service.findQuestionsByTheme(persistTheme.getId());

        assertFalse(questions.isEmpty());
    }

    @Test
    void testSiLasOpcionesCandidatasTienenMasDeUnAcierto_NoSePersisteLaPregunta() {

        Difficulty persistDifficulty = difficultyService.save(difficulty);

        Theme persistTheme = themeService.saveTheme(theme, persistDifficulty.getId());

        Question question = new Question("Pregunta");

        List<Option> options = new ArrayList<>();
        options.add(new CorrectOption("a"));
        options.add(new CorrectOption("b"));

        assertThrows(RepeatedCorrectOptionException.class, () -> service.add(question, persistTheme.getId(), options));
    }

    @Test
    void testSiLasOpcionesCandidatasTienenEnunciadosRepetidos_NoSePersisteLaPregunta() {

        Difficulty persistDifficulty = difficultyService.save(difficulty);

        Theme persistTheme = themeService.saveTheme(theme, persistDifficulty.getId());

        Question question = new Question("Pregunta");

        List<Option> options = new ArrayList<>();
        options.add(new FailOption("a"));
        options.add(new CorrectOption("a"));

        assertThrows(RepeatedStatementOptionException.class, () -> service.add(question, persistTheme.getId(), options));
    }

    @AfterEach
    void tearDown() {
        service.crearAll();
        themeService.clearAll();
        difficultyService.clearAll();
    }
}