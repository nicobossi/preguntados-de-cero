package com.guitarradecero.preguntados_de_cero.adapter.user;

import com.guitarradecero.preguntados_de_cero.dto.user.UserResponseDto;
import com.guitarradecero.preguntados_de_cero.model.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserResponseDto modelToDto(User user);
}
