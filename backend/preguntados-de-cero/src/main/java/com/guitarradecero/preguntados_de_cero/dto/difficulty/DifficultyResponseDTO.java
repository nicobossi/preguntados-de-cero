package com.guitarradecero.preguntados_de_cero.dto.difficulty;

import com.guitarradecero.preguntados_de_cero.model.difficulty.Difficulty;
import com.guitarradecero.preguntados_de_cero.model.theme.Theme;

import java.util.List;

public record DifficultyResponseDTO(
    Long id,
    Integer level,
    List<String> themeNames
) {

}
