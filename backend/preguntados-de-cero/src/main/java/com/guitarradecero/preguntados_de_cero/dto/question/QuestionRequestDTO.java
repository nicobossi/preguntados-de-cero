package com.guitarradecero.preguntados_de_cero.dto.question;

import com.guitarradecero.preguntados_de_cero.dto.option.OptionRequestDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.List;

public record QuestionRequestDTO(
        @NotNull @NotEmpty @NotBlank @Pattern(regexp = "^[\\p{L}0-9 ¿?]+$", message = "Solo se permiten, letras, números y signos de pregunta") String text,
        @Valid @NotNull List<OptionRequestDTO> options
) {
}
