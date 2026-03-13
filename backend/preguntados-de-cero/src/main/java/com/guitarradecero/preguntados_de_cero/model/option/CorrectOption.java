package com.guitarradecero.preguntados_de_cero.model.option;

import com.guitarradecero.preguntados_de_cero.model.question.Question;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("correct")
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class CorrectOption extends Option {

    public CorrectOption(String text) {
        setText(text);
        setIsCorrect(true);
    }

    @Override
    public void addedQuestion(Question question) {
        question.addCorrectOption(this);
    }
}
