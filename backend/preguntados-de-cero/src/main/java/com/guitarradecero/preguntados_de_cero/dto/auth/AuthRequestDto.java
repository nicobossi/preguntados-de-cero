package com.guitarradecero.preguntados_de_cero.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AuthRequestDto(
        @NotNull @NotBlank @Email String email,
        @NotNull @NotBlank String password
) {
}
