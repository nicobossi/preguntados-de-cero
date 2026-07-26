package com.guitarradecero.preguntados_de_cero.adapter.auth;

import com.guitarradecero.preguntados_de_cero.dto.auth.UserAuthResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserAuthMapper {

    UserAuthMapper INSTANCE = Mappers.getMapper(UserAuthMapper.class);

    UserAuthResponseDTO modelToDto(String token);
}
