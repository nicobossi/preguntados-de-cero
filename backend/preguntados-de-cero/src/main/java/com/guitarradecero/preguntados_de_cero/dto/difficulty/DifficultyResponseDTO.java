package com.guitarradecero.preguntados_de_cero.dto.difficulty;

import com.guitarradecero.preguntados_de_cero.model.difficulty.Difficulty;
import com.guitarradecero.preguntados_de_cero.model.theme.Theme;

import java.util.List;

public record DifficultyResponseDTO(
    Long id,
    Integer level,
    List<String> themeNames
) {
    public static DifficultyResponseDTO fromModel(Difficulty difficulty) {
        List<String> themeNames = difficulty.getThemes().stream().map(Theme::getName).toList();
        return new DifficultyResponseDTO(difficulty.getId(), difficulty.getLevel(), themeNames);
    }

    public static Difficulty toModel(DifficultyResponseDTO difficultyDto) {
        return new Difficulty(difficultyDto.level());
    }
}
