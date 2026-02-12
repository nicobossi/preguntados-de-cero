package com.guitarradecero.preguntados_de_cero.controller.difficulty;

import com.guitarradecero.preguntados_de_cero.adapter.difficulty.DifficultyMapper;
import com.guitarradecero.preguntados_de_cero.dto.difficulty.DifficultyDescription;
import com.guitarradecero.preguntados_de_cero.dto.difficulty.DifficultyRequestDTO;
import com.guitarradecero.preguntados_de_cero.dto.difficulty.DifficultyResponseDTO;
import com.guitarradecero.preguntados_de_cero.model.difficulty.Difficulty;
import com.guitarradecero.preguntados_de_cero.service.DifficultyService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Getter
@Setter
@RestController
@RequestMapping("/api/difficulty")
public class DifficultyControllerREST {

    private final DifficultyService difficultyService;

    public DifficultyControllerREST(DifficultyService service) {
        difficultyService = service;
    }

    @GetMapping
    public ResponseEntity<List<DifficultyDescription>> getAllNiveles() {

        List<DifficultyDescription> niveles = getDifficultyService().allLevelsWithDescription();

        return ResponseEntity.ok(niveles);
    }

    @PostMapping("/add")
    public ResponseEntity<DifficultyResponseDTO> addDifficulty(@RequestBody DifficultyRequestDTO difficultyDto) {

        Difficulty difficulty = getDifficultyService().save(DifficultyMapper.INSTANCE.dtoToModel(difficultyDto));

        return ResponseEntity.ok(DifficultyMapper.INSTANCE.modelToDto(difficulty));
    }
}
