package com.guitarradecero.preguntados_de_cero.persistence.sql.difficulty;

import com.guitarradecero.preguntados_de_cero.dto.difficulty.DifficultyDescription;
import com.guitarradecero.preguntados_de_cero.model.difficulty.Difficulty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DifficultyDAO extends JpaRepository<Difficulty, Long> {

    @Query(
            value =
                    "SELECT d.id AS id, d.level AS level, array_agg(t.name) AS themeNames " +
                    "FROM difficulty d " +
                    "LEFT JOIN theme t ON d.id = t.difficulty_id " +
                    "GROUP BY d.id, d.level " +
                    "ORDER BY d.level ",
            nativeQuery = true
    )
    List<DifficultyDescription> findWithDescription();

    List<Difficulty> findAllByOrderByLevel();
}
