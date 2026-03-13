package com.guitarradecero.preguntados_de_cero.model.option;

import com.guitarradecero.preguntados_de_cero.model.question.Question;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("fail")
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class FailOption extends Option {

    public FailOption(String text) {
        setText(text);
        setIsCorrect(false);
    }

    @Override
    public void addedQuestion(Question question) {
        question.addFailOption(this);
    }
}
