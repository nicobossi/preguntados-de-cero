package com.guitarradecero.preguntados_de_cero.dto.difficulty;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.format.annotation.NumberFormat;

public record DifficultyRequestDTO(
        @NotNull @NumberFormat @Positive Integer level
) {
}
