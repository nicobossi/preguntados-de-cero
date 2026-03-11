package com.guitarradecero.preguntados_de_cero.model.question;

import com.guitarradecero.preguntados_de_cero.model.ModelException;
import com.guitarradecero.preguntados_de_cero.model.option.Option;
import com.guitarradecero.preguntados_de_cero.model.option.RepeatedStatementOptionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {

    private Question question;
    private Option option1;
    private Option option2;
    private Option option3;
    private Option option4;

    @BeforeEach
    void setUp() {
        option1 = mock(Option.class);
        option2 = mock(Option.class);
        option3 = mock(Option.class);
        option4 = mock(Option.class);
        List<Option> options = new ArrayList<>();
        options.add(option1);
        options.add(option2);
        options.add(option3);
        options.add(option4);
        question = new Question("¿Cuantos dedos se necesitan para hacer Do?", options);
    }

    @Test
    void testUnaPreguntaTieneUnEnunciado() {
        assertEquals("¿Cuantos dedos se necesitan para hacer Do?", question.getText());
    }

    @Test
    void testSeAgregaLaPrimeraOpcion() {
        assertDoesNotThrow(() -> question.addOption(option1));
    }

    @Test
    void testSeAgregaLaPrimeraOpcionCorrecta() {
        when(option1.getIsCorrect()).thenReturn(true);
        assertDoesNotThrow(() -> question.addOption(option1));
    }

    @Test
    void testSeAgregaLaPrimeraOpcionIncorrecta() {
        when(option1.getIsCorrect()).thenReturn(false);
        assertDoesNotThrow(() -> question.addOption(option1));
    }

    @Test
    void testSiSeAgregaMasDeUnaOpcionCorrecta_HayExcepcion() {
        Option option1 = spy(Option.class);
        Option option2 = spy(Option.class);

        when(option1.getIsCorrect()).thenReturn(true);
        when(option2.getIsCorrect()).thenReturn(true);
        question.addOption(option1);

        ModelException exception = assertThrows(RepeatedCorrectOptionException.class, () -> question.addOption(option2));
        assertEquals(exception.getMessage(), question.repeatedCorrectOptionMessage(option2));
    }

    @Test
    void testUnaPreguntaDevuelveLosEnunciadosDeSusOpciones() {
        Option option1 = spy(Option.class);
        when(option1.getText()).thenReturn("a");
        when(option1.getIsCorrect()).thenReturn(true);
        question.addOption(option1);

        List<String> optionsStatements = question.optionsStatements();

        assertTrue(optionsStatements.contains(option1.getText()));
    }

    @Test
    void testSiExisteUnaOpcionCandidataConEnunciadoRepetido_HayExcepcion() {
        Option option1 = spy(Option.class);
        when(option1.getIsCorrect()).thenReturn(true);
        when(option1.getText()).thenReturn("a");

        Option option2 = spy(Option.class);
        when(option2.getIsCorrect()).thenReturn(false);
        when(option2.getText()).thenReturn("a");

        question.addOption(option1);

        assertThrows(RepeatedStatementOptionException.class, () -> question.addOption(option2));
    }
}