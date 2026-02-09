package com.guitarradecero.preguntados_de_cero.dto.question;

import com.guitarradecero.preguntados_de_cero.dto.option.OptionResponseDTO;
import com.guitarradecero.preguntados_de_cero.model.question.Question;

import java.util.List;

public record QuestionResponseDTO(
        Long id,
        String text,
        List<OptionResponseDTO> options
) {

    public static QuestionResponseDTO fromModel(Question question) {
        List<OptionResponseDTO> optionsDto = question.getOptions().stream().map(OptionResponseDTO::fromModel).toList();
        return new QuestionResponseDTO(question.getId(), question.getText(), optionsDto);
    }
}
