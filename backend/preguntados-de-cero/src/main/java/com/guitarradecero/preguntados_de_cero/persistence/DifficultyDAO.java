package com.guitarradecero.preguntados_de_cero.persistence;

import com.guitarradecero.preguntados_de_cero.model.difficulty.Difficulty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DifficultyDAO extends JpaRepository<Difficulty, Long> {

}
