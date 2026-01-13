package com.guitarradecero.preguntados_de_cero.controller;

import com.guitarradecero.preguntados_de_cero.dto.DifficultyRequestDTO;
import com.guitarradecero.preguntados_de_cero.dto.DifficultyResponseDTO;
import com.guitarradecero.preguntados_de_cero.model.nivel.Difficulty;
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

    private final DifficultyService nivelService;

    public DifficultyControllerREST(DifficultyService service){
        nivelService = service;
    }

    @GetMapping
    public ResponseEntity<List<DifficultyResponseDTO>> getAllNiveles(){
        List<DifficultyResponseDTO> niveles = getNivelService().getAll().stream()
                                                           .map(DifficultyResponseDTO::desdeModelo)
                                                           .collect(Collectors.toList());

        return ResponseEntity.ok(niveles);
    }

    @PostMapping("/add")
    public ResponseEntity<DifficultyResponseDTO> addDifficulty(@RequestBody DifficultyRequestDTO difficultyDto) {

        Difficulty difficulty = getNivelService().saveDifficulty(DifficultyRequestDTO.aModelo(difficultyDto));

        return ResponseEntity.ok(DifficultyResponseDTO.desdeModelo(difficulty));
    }
}
