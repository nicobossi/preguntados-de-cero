package com.guitarradecero.preguntados_de_cero.service;

import com.guitarradecero.preguntados_de_cero.model.difficulty.Difficulty;
import java.util.List;

public interface DifficultyService {
    List<Difficulty> allLevelsWithThemes();
    Difficulty save(Difficulty difficulty);
}
