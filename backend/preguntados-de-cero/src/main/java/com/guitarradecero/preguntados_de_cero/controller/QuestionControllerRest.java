package com.guitarradecero.preguntados_de_cero.controller;


import com.guitarradecero.preguntados_de_cero.persistence.sql.question.QuestionEntity;
import com.guitarradecero.preguntados_de_cero.service.QuestionService;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Getter(AccessLevel.PRIVATE)
@Setter(AccessLevel.PRIVATE)
@RestController
@RequestMapping("/api/question")
public class QuestionControllerRest {

    private QuestionService service;

    QuestionControllerRest(QuestionService service) {
        setService(service);
    }

    @GetMapping("/{themeId}")
    public ResponseEntity<List<QuestionEntity>> getAllQuestionByTheme(@PathVariable Long themeId) {
        return ResponseEntity.ok(getService().findQuestionsBy(themeId));
    }
}

