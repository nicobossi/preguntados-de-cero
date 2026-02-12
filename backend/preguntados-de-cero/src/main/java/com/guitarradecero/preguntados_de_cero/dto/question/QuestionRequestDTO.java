package com.guitarradecero.preguntados_de_cero.dto.question;

import com.guitarradecero.preguntados_de_cero.dto.option.OptionRequestDTO;
import com.guitarradecero.preguntados_de_cero.model.option.Option;
import com.guitarradecero.preguntados_de_cero.model.question.Question;

import java.util.List;

public record QuestionRequestDTO(
        String text,
        List<OptionRequestDTO> options
) {
}
