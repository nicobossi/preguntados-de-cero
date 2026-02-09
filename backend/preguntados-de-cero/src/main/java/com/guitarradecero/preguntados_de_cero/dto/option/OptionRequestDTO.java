package com.guitarradecero.preguntados_de_cero.dto.option;

import com.guitarradecero.preguntados_de_cero.model.option.Option;

public record OptionRequestDTO(
        String text,
        Boolean isCorrect
) {

    public static Option toModel(OptionRequestDTO optionDto) {
        return new Option(optionDto.text, optionDto.isCorrect);
    }
}
