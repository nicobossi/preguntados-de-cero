package com.guitarradecero.preguntados_de_cero.dto.auth;

import com.guitarradecero.preguntados_de_cero.model.user.Role;

public record UserAuthRequestDTO(
        String email,
        String password
){}
