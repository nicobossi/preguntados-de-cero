package com.guitarradecero.preguntados_de_cero.adapter.option;


import com.guitarradecero.preguntados_de_cero.dto.option.OptionRequestDTO;
import com.guitarradecero.preguntados_de_cero.dto.option.OptionResponseDTO;
import com.guitarradecero.preguntados_de_cero.model.option.CorrectOption;
import com.guitarradecero.preguntados_de_cero.model.option.FailOption;
import com.guitarradecero.preguntados_de_cero.model.option.Option;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ObjectFactory;

@Mapper
public interface OptionMapper {

    @ObjectFactory
    default Option createOption(OptionRequestDTO dto) {
        if(dto.isCorrect()) {
            return new CorrectOption(dto.text());
        }
        else {
            return new FailOption(dto.text());
        }
    }

    @Mapping(target = "id", ignore = true)
    Option dtoToModal(OptionRequestDTO dto);

    OptionResponseDTO modelToDto(Option option);
}
