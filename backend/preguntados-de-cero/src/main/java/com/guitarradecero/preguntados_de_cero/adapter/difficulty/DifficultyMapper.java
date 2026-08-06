package com.guitarradecero.preguntados_de_cero.adapter.difficulty;

import com.guitarradecero.preguntados_de_cero.adapter.theme.ThemeMapper;
import com.guitarradecero.preguntados_de_cero.dto.difficulty.DifficultyRequestDTO;
import com.guitarradecero.preguntados_de_cero.dto.difficulty.DifficultyResponseDTO;
import com.guitarradecero.preguntados_de_cero.dto.difficulty.DifficultyWithThemesResponseDTO;
import com.guitarradecero.preguntados_de_cero.model.difficulty.Difficulty;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = ThemeMapper.class)
public interface DifficultyMapper {

    DifficultyMapper INSTANCE = Mappers.getMapper(DifficultyMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "themes", ignore = true)
    Difficulty dtoToModel(DifficultyRequestDTO difficultyDto);

    DifficultyResponseDTO modelToDto(Difficulty difficulty);
    DifficultyWithThemesResponseDTO modelToDtoWithThemes(Difficulty difficulty);

}
