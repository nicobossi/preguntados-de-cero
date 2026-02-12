package com.guitarradecero.preguntados_de_cero.adapter.option;


import com.guitarradecero.preguntados_de_cero.dto.option.OptionRequestDTO;
import com.guitarradecero.preguntados_de_cero.dto.option.OptionResponseDTO;
import com.guitarradecero.preguntados_de_cero.model.option.Option;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface OptionMapper {

    @Mapping(target = "id", ignore = true)
    Option dtoToModal(OptionRequestDTO dto);

    OptionResponseDTO modelToDto(Option option);
}
