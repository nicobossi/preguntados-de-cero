package com.guitarradecero.preguntados_de_cero.service;

import com.guitarradecero.preguntados_de_cero.model.nivel.Difficulty;

import java.util.List;

public interface DifficultyService {
    List<Difficulty> getAll();
    Difficulty saveDifficulty(Difficulty difficulty);
}
