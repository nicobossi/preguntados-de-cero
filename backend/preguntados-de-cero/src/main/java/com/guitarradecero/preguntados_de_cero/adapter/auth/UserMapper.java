package com.guitarradecero.preguntados_de_cero.adapter.auth;

import com.guitarradecero.preguntados_de_cero.dto.auth.UserAuthRequestDTO;
import com.guitarradecero.preguntados_de_cero.model.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", ignore = true)
    User dtoToModel(UserAuthRequestDTO requestDTO);
}
