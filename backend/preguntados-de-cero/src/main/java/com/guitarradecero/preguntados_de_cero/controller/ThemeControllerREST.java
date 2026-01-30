package com.guitarradecero.preguntados_de_cero.controller;

import com.guitarradecero.preguntados_de_cero.dto.ThemeRequestDTO;
import com.guitarradecero.preguntados_de_cero.dto.ThemeResponseDTO;
import com.guitarradecero.preguntados_de_cero.model.theme.Theme;
import com.guitarradecero.preguntados_de_cero.service.ThemeService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Getter
@Setter
@RestController
@RequestMapping("/api/theme")
public class ThemeControllerREST {

    private final ThemeService themeService;

    public ThemeControllerREST(ThemeService themeService){
        this.themeService = themeService;
    }

    @PostMapping("/add/{difficultyId}")
    public ResponseEntity<ThemeResponseDTO> addTheme(@RequestBody ThemeRequestDTO themeDTO, @PathVariable Long difficultyId) {

        Theme theme = getThemeService().saveTheme(ThemeRequestDTO.toModel(themeDTO), difficultyId);

        return ResponseEntity.ok(ThemeResponseDTO.fromModel(theme));
    }

    @GetMapping("/{difficultyId}")
    public ResponseEntity<List<ThemeResponseDTO>> getAllThemesByDifficulty(@PathVariable Long difficultyId){

        List<ThemeResponseDTO> themes = getThemeService().getAllByDifficulty(difficultyId).stream()
                .map(ThemeResponseDTO::fromModel)
                .toList();

        return ResponseEntity.ok(themes);
    }
}
