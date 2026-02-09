package com.guitarradecero.preguntados_de_cero.controller;


import com.guitarradecero.preguntados_de_cero.dto.question.QuestionRequestDTO;
import com.guitarradecero.preguntados_de_cero.dto.question.QuestionResponseDTO;
import com.guitarradecero.preguntados_de_cero.model.question.Question;
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
    public ResponseEntity<List<QuestionResponseDTO>> getAllQuestionByTheme(@PathVariable Long themeId) {
        List<Question> question = getService().findQuestionsByTheme(themeId);
        List<QuestionResponseDTO> dtos = question.stream().map(QuestionResponseDTO::fromModel).toList();
        return ResponseEntity.ok(dtos);
    }

    @PostMapping("/add/{themeId}")
    public ResponseEntity<QuestionResponseDTO> postQuestion(@RequestBody QuestionRequestDTO questionDto, @PathVariable Long themeId) {
        Question question = QuestionRequestDTO.toModel(questionDto);
        Question persistQuestion = getService().add(question, themeId);
        return ResponseEntity.ok(QuestionResponseDTO.fromModel(persistQuestion));
    }
}

