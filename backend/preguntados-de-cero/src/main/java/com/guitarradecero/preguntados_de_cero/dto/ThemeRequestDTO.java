package com.guitarradecero.preguntados_de_cero.dto;

import com.guitarradecero.preguntados_de_cero.model.theme.Theme;

public record ThemeRequestDTO(
        String name,
        String description
) {
    public static Theme toModel(ThemeRequestDTO themeDTO){
        return new Theme(themeDTO.name(), themeDTO.description());
    }
}
