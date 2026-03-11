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
        correctOption = new CorrectOption("a");
        failOption = new FailOption("a");
        question = mock(Question.class);
    }

    @Test
    void testLaOpcionCorrectaSeAniadeAUnaPregunta() {
        correctOption.verifyQuestion(question);

        verify(question).addCorrectOption(correctOption);
    }

    @Test
    void testUnaOpcionFalsaSeAniadeAUnaPregunta() {
        failOption.verifyQuestion(question);

        verify(question).addFailOption(failOption);
    }

    @Test
    void testSiUnaOpcionCandidataParaUnaPreguntaTieneEnunciadoRepetido_HayExcepcion() {
        List<String> statements = new ArrayList<>();
        statements.add("a");
        when(question.optionsStatements()).thenReturn(statements);

        ModelException exception = assertThrows(RepeatedStatementOptionException.class, () -> correctOption.verifyQuestion(question));

        assertEquals(exception.getMessage(), correctOption.repeatedStatementOptionMessage(question));

        verify(question).optionsStatements();
    }
}