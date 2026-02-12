package com.guitarradecero.preguntados_de_cero.controller.question;


import com.guitarradecero.preguntados_de_cero.adapter.question.QuestionMapper;
import com.guitarradecero.preguntados_de_cero.dto.question.QuestionRequestDTO;
import com.guitarradecero.preguntados_de_cero.dto.question.QuestionResponseDTO;
import com.guitarradecero.preguntados_de_cero.dto.question.QuestionWithOptions;
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
    public ResponseEntity<List<QuestionWithOptions>> getAllQuestionByTheme(@PathVariable Long themeId) {
        List<QuestionWithOptions> questions = getService().findQuestionsByTheme(themeId);
        return ResponseEntity.ok(questions);
    }

    @PostMapping("/add/{themeId}")
    public ResponseEntity<QuestionResponseDTO> postQuestion(@RequestBody QuestionRequestDTO questionDto, @PathVariable Long themeId) {
        Question question = QuestionMapper.INSTANCE.dtoToModel(questionDto);
        Question persistQuestion = getService().add(question, themeId);
        return ResponseEntity.ok(QuestionMapper.INSTANCE.modelToDto(persistQuestion));
    }
}

