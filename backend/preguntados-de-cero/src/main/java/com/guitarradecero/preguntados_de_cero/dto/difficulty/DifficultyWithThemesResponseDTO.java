package com.guitarradecero.preguntados_de_cero.dto.difficulty;

import com.guitarradecero.preguntados_de_cero.dto.theme.ThemeResponseDTO;

import java.util.List;

public record DifficultyWithThemesResponseDTO(
        Long id,
        Integer level,
        List<ThemeResponseDTO> themes
) {
}
