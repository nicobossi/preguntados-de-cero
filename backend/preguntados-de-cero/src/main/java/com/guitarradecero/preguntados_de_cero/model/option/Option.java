package com.guitarradecero.preguntados_de_cero.model.option;

import com.guitarradecero.preguntados_de_cero.model.question.Question;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter(AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String text;

    private Boolean isCorrect;

    public Option(String text, Boolean isCorrect) {
        setText(text);
        setIsCorrect(isCorrect);
    }

    public void verifyQuestion(Question question) {
        if(isRepeatStatementIn(question)) {
            throw new RepeatedStatementOptionException(repeatedStatementOptionMessage(question));
        }
        addedQuestion(question);
    }

    public abstract void addedQuestion(Question question);

    private boolean isRepeatStatementIn(Question question) {
        return question.optionsStatements().stream().anyMatch(statement -> Objects.equals(statement, getText()));
    }

    String repeatedStatementOptionMessage(Question question) {
        return "La pregunta " + question.getId() + " ya tiene una opción con el enunciado " + getText();
    }
}
