package com.guitarradecero.preguntados_de_cero.service;

import com.guitarradecero.preguntados_de_cero.model.theme.Theme;

import java.util.List;

public interface ThemeService {
    List<Theme> getAllByDifficulty(Long difficultyId);
    Theme saveTheme(Theme theme, Long difficultyId);
}
