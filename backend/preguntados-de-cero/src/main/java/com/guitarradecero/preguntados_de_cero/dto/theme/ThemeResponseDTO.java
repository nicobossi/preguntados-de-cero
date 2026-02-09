package com.guitarradecero.preguntados_de_cero.dto.theme;

import com.guitarradecero.preguntados_de_cero.model.theme.Theme;

public record ThemeResponseDTO(
        Long id,
        String name,
        String description,
        Long difficultyId
) {
    public static ThemeResponseDTO fromModel(Theme theme){
        return new ThemeResponseDTO(theme.getId(), theme.getName(), theme.getDescription(), theme.getDifficulty().getId()); // revisar el cuarto parametro...
    }
}
