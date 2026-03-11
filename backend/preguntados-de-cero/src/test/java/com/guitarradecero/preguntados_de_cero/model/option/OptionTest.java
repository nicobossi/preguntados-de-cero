package com.guitarradecero.preguntados_de_cero.model.option;

import com.guitarradecero.preguntados_de_cero.model.ModelException;
import com.guitarradecero.preguntados_de_cero.model.question.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void testSiUnaOpcionCandidataParaUnaPreguntaTieneEnunciadoRepetido_HayExcepcion() {
        List<String> statements = new ArrayList<>();
        statements.add("a");
        when(question.optionsStatements()).thenReturn(statements);

        ModelException exception = assertThrows(RepeatedStatementOptionException.class, () -> correctOption.adddedQuestion(question));

        assertEquals(exception.getMessage(), correctOption.repeatedStatementOptionMessage(question));

        verify(question).optionsStatements();
    }
}