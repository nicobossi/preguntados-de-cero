package com.guitarradecero.preguntados_de_cero.persistence.sql.question;

import com.guitarradecero.preguntados_de_cero.dto.question.QuestionWithOptions;
import com.guitarradecero.preguntados_de_cero.model.question.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDAO extends JpaRepository<Question, Long> {

    List<QuestionWithOptions> findByThemeId(Long themeId);
}
