package com.guitarradecero.preguntados_de_cero.service;

import com.guitarradecero.preguntados_de_cero.model.difficulty.Difficulty;

import java.util.List;
import java.util.Optional;

public interface DifficultyService {
    List<Difficulty> getAll();
    Difficulty saveDifficulty(Difficulty difficulty);
}
