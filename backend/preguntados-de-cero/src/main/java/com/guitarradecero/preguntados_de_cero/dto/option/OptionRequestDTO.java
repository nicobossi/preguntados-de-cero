package com.guitarradecero.preguntados_de_cero.dto.option;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record OptionRequestDTO(
        @NotNull @NotBlank @NotEmpty String text,
        @NotNull Boolean isCorrect
) {
}
