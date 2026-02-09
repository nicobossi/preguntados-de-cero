package com.guitarradecero.preguntados_de_cero.controller;

import com.guitarradecero.preguntados_de_cero.dto.difficulty.DifficultyRequestDTO;
import com.guitarradecero.preguntados_de_cero.dto.difficulty.DifficultyResponseDTO;
import com.guitarradecero.preguntados_de_cero.model.difficulty.Difficulty;
import com.guitarradecero.preguntados_de_cero.service.DifficultyService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    public ResponseEntity<List<DifficultyResponseDTO>> getAllNiveles() {

        List<Difficulty> niveles = getDifficultyService().getAll();
        List<DifficultyResponseDTO> nivelesDto = niveles.stream()
                                                           .map(DifficultyResponseDTO::fromModel)
                                                           .collect(Collectors.toList());

        return ResponseEntity.ok(nivelesDto);
    }

    @PostMapping("/add")
    public ResponseEntity<DifficultyResponseDTO> addDifficulty(@RequestBody DifficultyRequestDTO difficultyDto) {

        Difficulty difficulty = getDifficultyService().save(DifficultyRequestDTO.aModelo(difficultyDto));

        return ResponseEntity.ok(DifficultyResponseDTO.fromModel(difficulty));
    }
}
