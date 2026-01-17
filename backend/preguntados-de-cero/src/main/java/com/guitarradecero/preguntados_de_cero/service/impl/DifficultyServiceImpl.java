package com.guitarradecero.preguntados_de_cero.service.impl;

import com.guitarradecero.preguntados_de_cero.model.difficulty.Difficulty;
import com.guitarradecero.preguntados_de_cero.persistence.DifficultyDAO;
import com.guitarradecero.preguntados_de_cero.service.DifficultyService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Setter(AccessLevel.PRIVATE)
@Getter(AccessLevel.PRIVATE)
@Service
@Transactional
public class DifficultyServiceImpl implements DifficultyService {

    private DifficultyDAO difficultyDAO;

    public DifficultyServiceImpl(DifficultyDAO dao){
        setDifficultyDAO(dao);
    }

    @Override
    public List<Difficulty> getAll() {
        return getDifficultyDAO().findAll();
    }

    @Override
    public Optional<Difficulty> getByDifficultyLevel(Integer level) {
        return getDifficultyDAO().findByLevel(level);
    }

    @Override
    public Difficulty saveDifficulty(Difficulty difficulty) {
        return getDifficultyDAO().save(difficulty);
    }

    void clearAll() {
        getDifficultyDAO().deleteAll();
    }
}
