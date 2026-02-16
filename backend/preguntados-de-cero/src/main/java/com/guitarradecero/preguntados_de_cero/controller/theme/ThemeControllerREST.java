package com.guitarradecero.preguntados_de_cero.controller.theme;

import com.guitarradecero.preguntados_de_cero.adapter.theme.ThemeMapper;
import com.guitarradecero.preguntados_de_cero.dto.theme.ThemeRequestDTO;
import com.guitarradecero.preguntados_de_cero.dto.theme.ThemeResponseDTO;
import com.guitarradecero.preguntados_de_cero.model.theme.Theme;
import com.guitarradecero.preguntados_de_cero.service.ThemeService;
import jakarta.validation.Valid;
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
    public ResponseEntity<ThemeResponseDTO> addTheme(@Valid @RequestBody ThemeRequestDTO themeDTO, @PathVariable Long difficultyId) {

        Theme theme = getThemeService().saveTheme(ThemeMapper.INSTANCE.dtoToModel(themeDTO), difficultyId);

        return ResponseEntity.ok(ThemeMapper.INSTANCE.modelToDto(theme));
    }

    @GetMapping("/{difficultyId}")
    public ResponseEntity<List<ThemeResponseDTO>> getAllThemesByDifficulty(@PathVariable Long difficultyId){

        List<ThemeResponseDTO> themes = getThemeService().getAllByDifficulty(difficultyId).stream()
                .map(ThemeMapper.INSTANCE::modelToDto)
                .toList();

        return ResponseEntity.ok(themes);
    }
}
