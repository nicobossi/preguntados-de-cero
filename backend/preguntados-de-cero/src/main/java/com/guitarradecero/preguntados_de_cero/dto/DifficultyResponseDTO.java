package com.guitarradecero.preguntados_de_cero.dto;

import com.guitarradecero.preguntados_de_cero.model.nivel.Difficulty;

public record DifficultyResponseDTO(
    Long id,
    Integer nivel
) {
    public static DifficultyResponseDTO desdeModelo(Difficulty dificultad) {
        return new DifficultyResponseDTO(dificultad.getId(), dificultad.getLevel());
    }

    public static Difficulty aModelo(DifficultyResponseDTO difficultyDto) {
        return new Difficulty(difficultyDto.nivel());
    }
}
