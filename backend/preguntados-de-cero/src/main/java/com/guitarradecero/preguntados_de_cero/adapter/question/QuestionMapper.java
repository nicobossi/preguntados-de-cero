package com.guitarradecero.preguntados_de_cero.adapter.question;

import com.guitarradecero.preguntados_de_cero.adapter.option.OptionMapper;
import com.guitarradecero.preguntados_de_cero.dto.question.QuestionRequestDTO;
import com.guitarradecero.preguntados_de_cero.dto.question.QuestionResponseDTO;
import com.guitarradecero.preguntados_de_cero.model.question.Question;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper(uses = OptionMapper.class)
public interface QuestionMapper {

    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "options", ignore = true)
    Question dtoToModel(QuestionRequestDTO dto);

    QuestionResponseDTO modelToDto(Question question);
}
