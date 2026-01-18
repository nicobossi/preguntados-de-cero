package com.guitarradecero.preguntados_de_cero.dto;

import com.guitarradecero.preguntados_de_cero.model.difficulty.Difficulty;

public record DifficultyResponseDTO(
    Long id,
    Integer level
) {
    public static DifficultyResponseDTO fromModel(Difficulty difficulty) {
        return new DifficultyResponseDTO(difficulty.getId(), difficulty.getLevel());
    }

    public static Difficulty toModel(DifficultyResponseDTO difficultyDto) {
        return new Difficulty(difficultyDto.level());
    }
}
