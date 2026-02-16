package com.guitarradecero.preguntados_de_cero.adapter.theme;

import com.guitarradecero.preguntados_de_cero.dto.theme.ThemeRequestDTO;
import com.guitarradecero.preguntados_de_cero.dto.theme.ThemeResponseDTO;
import com.guitarradecero.preguntados_de_cero.model.theme.Theme;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ThemeMapper {

    ThemeMapper INSTANCE = Mappers.getMapper(ThemeMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "difficulty", ignore = true)
    Theme dtoToModel(ThemeRequestDTO requestDto);

    ThemeResponseDTO modelToDto(Theme theme);


}
