package com.guitarradecero.preguntados_de_cero.adapter;

import com.guitarradecero.preguntados_de_cero.dto.auth.AuthResponseDto;
import com.guitarradecero.preguntados_de_cero.model.auth.Auth;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthMapper {
    AuthMapper INSTANCE = Mappers.getMapper(AuthMapper.class);

    AuthResponseDto modelToDto(Auth auth);
}
