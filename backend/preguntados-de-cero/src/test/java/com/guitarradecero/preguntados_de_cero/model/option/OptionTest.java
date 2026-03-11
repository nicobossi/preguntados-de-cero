package com.guitarradecero.preguntados_de_cero.model.option;

import com.guitarradecero.preguntados_de_cero.model.question.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class OptionTest {

    private Option correctOption;
    private Option failOption;
    private Question question;

    @BeforeEach
    void setUp() {
        correctOption = new Option("a", true);
        failOption = new Option("a", false);
        question = mock(Question.class);
    }

    @Test
    void testLaOpcionCorrectaSeAniadeAUnaPregunta() {
        correctOption.adddedQuestion(question);

        verify(question).addCorrectOption(correctOption);
    }

    @Test
    void testUnaOpcionFalsaSeAniadeAUnaPregunta() {
        failOption.adddedQuestion(question);

        verify(question).addFailOption(failOption);
    }
}