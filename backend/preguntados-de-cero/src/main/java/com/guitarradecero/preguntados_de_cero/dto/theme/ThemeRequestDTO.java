package com.guitarradecero.preguntados_de_cero.dto.theme;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ThemeRequestDTO(
        @NotNull @NotEmpty @NotBlank @Size(min = 4) String name,
        @NotNull @NotEmpty @NotBlank String description
) {
}
