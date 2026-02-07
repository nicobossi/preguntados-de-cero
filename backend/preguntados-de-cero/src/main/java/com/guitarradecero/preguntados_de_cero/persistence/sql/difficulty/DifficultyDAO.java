package com.guitarradecero.preguntados_de_cero.persistence.sql.difficulty;

import com.guitarradecero.preguntados_de_cero.model.difficulty.Difficulty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DifficultyDAO extends JpaRepository<Difficulty, Long> {

}
