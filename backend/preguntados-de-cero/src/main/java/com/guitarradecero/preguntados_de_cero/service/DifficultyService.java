package com.guitarradecero.preguntados_de_cero.service;

import com.guitarradecero.preguntados_de_cero.dto.difficulty.DifficultyDescription;
import com.guitarradecero.preguntados_de_cero.dto.difficulty.DifficultyWithThemesResponseDTO;
import com.guitarradecero.preguntados_de_cero.model.difficulty.Difficulty;

import java.util.List;

public interface DifficultyService {
    List<DifficultyDescription> allLevelsWithDescription();

    List<Difficulty> allLevelsWithThemes();

    Difficulty save(Difficulty difficulty);
}
