package com.guitarradecero.preguntados_de_cero.persistence.sql.difficulty;


import com.guitarradecero.preguntados_de_cero.model.difficulty.Difficulty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DifficultyDAO extends JpaRepository<Difficulty, Long> {

    List<Difficulty> findAllByOrderByLevel();
}
