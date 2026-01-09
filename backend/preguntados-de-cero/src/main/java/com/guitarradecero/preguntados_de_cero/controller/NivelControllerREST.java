package com.guitarradecero.preguntados_de_cero.controller;

import com.guitarradecero.preguntados_de_cero.dto.NivelDTO;
import com.guitarradecero.preguntados_de_cero.service.NivelService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@RestController
@RequestMapping("/nivel")
public class NivelControllerREST {

    private final NivelService nivelService;

    public NivelControllerREST(NivelService service){
        nivelService = service;
    }

    @GetMapping
    public ResponseEntity<List<NivelDTO>> getAllNiveles(){
        List<NivelDTO> niveles = getNivelService().getAll().stream()
                                                           .map(NivelDTO::desdeModelo)
                                                           .collect(Collectors.toList());

        return ResponseEntity.ok(niveles);
    }
}
