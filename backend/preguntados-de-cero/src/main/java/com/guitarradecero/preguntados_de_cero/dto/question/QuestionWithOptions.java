package com.guitarradecero.preguntados_de_cero.dto.question;

import com.guitarradecero.preguntados_de_cero.dto.option.OptionSelector;

import java.util.List;

public interface QuestionWithOptions {
    Long getId();
    String getText();
    List<OptionSelector> getOptions();
}


