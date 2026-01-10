package com.guitarradecero.preguntados_de_cero.service.impl;

import com.guitarradecero.preguntados_de_cero.model.nivel.Difficulty;
import com.guitarradecero.preguntados_de_cero.persistence.NivelDAO;
import com.guitarradecero.preguntados_de_cero.service.DifficultyService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Setter(AccessLevel.PRIVATE)
@Getter(AccessLevel.PRIVATE)
@Service
@Transactional
public class DifficultyServiceImpl implements DifficultyService {

    private NivelDAO nivelDAO;

    public DifficultyServiceImpl(NivelDAO dao){
        setNivelDAO(dao);
    }

    @Override
    public List<Difficulty> getAll() {
        return getNivelDAO().findAll();
    }

    @Override
    public Difficulty saveDifficulty(Difficulty difficulty) {
        return getNivelDAO().save(difficulty);
    }

    void clearAll() {
        getNivelDAO().deleteAll();
    }
}
