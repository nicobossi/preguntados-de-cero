package com.guitarradecero.preguntados_de_cero.model.option;

import com.guitarradecero.preguntados_de_cero.model.question.Question;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String text;

    private Boolean isCorrect;

    public Option(String text, Boolean isCorrect) {
        setText(text);
        setIsCorrect(isCorrect);
    }

    public void adddedQuestion(Question question) {
        if(getIsCorrect()) {
            question.addCorrectOption(this);
        }
        else {
            question.addFailOption(this);
        }
    }
}
