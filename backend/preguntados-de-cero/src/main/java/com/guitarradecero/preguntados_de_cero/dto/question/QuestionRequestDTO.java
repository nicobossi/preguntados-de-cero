package com.guitarradecero.preguntados_de_cero.dto.question;

import com.guitarradecero.preguntados_de_cero.dto.option.OptionRequestDTO;
import com.guitarradecero.preguntados_de_cero.model.option.Option;
import com.guitarradecero.preguntados_de_cero.model.question.Question;

import java.util.List;

public record QuestionRequestDTO(
        String text,
        List<OptionRequestDTO> options
) {

    public static Question toModel(QuestionRequestDTO dto ) {
        List<Option> options = dto.options.stream().map(OptionRequestDTO::toModel).toList();
        return new Question(dto.text, options);
    }
}
