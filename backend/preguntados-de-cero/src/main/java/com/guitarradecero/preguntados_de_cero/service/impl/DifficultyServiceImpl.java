package com.guitarradecero.preguntados_de_cero.service.impl;

import com.guitarradecero.preguntados_de_cero.model.difficulty.Difficulty;
import com.guitarradecero.preguntados_de_cero.persistence.DifficultyDAO;
import com.guitarradecero.preguntados_de_cero.persistence.LevelRepeatException;
import com.guitarradecero.preguntados_de_cero.service.DifficultyService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Difficulty save(Difficulty difficulty) {
        try {
            return getDifficultyDAO().saveAndFlush(difficulty);
        }
        catch(DataIntegrityViolationException e){
            throw new LevelRepeatException("El nivel " + difficulty.getLevel() + " ya se encuentra registrado");
        }
    }

    void clearAll() {
        getDifficultyDAO().deleteAll();
    }
}
