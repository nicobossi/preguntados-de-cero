package com.guitarradecero.preguntados_de_cero.dto;

import com.guitarradecero.preguntados_de_cero.model.difficulty.Difficulty;

public record DifficultyRequestDTO(
        Integer level
) {

    public static Difficulty aModelo(DifficultyRequestDTO difficultyDto) {
        return new Difficulty(difficultyDto.level());
    }
}
