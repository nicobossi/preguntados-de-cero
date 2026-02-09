package com.guitarradecero.preguntados_de_cero.dto.option;

import com.guitarradecero.preguntados_de_cero.model.option.Option;

public record OptionResponseDTO(
        Long id,
        String text,
        Boolean isCorrect
) {

    public static OptionResponseDTO fromModel(Option option) {
        return new OptionResponseDTO(option.getId(), option.getText(), option.getIsCorrect());
    }
}
