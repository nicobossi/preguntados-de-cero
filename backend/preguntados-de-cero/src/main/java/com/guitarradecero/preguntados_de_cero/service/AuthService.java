package com.guitarradecero.preguntados_de_cero.service;

import com.guitarradecero.preguntados_de_cero.dto.auth.UserAuthRequestDTO;
import com.guitarradecero.preguntados_de_cero.dto.auth.UserAuthResponseDTO;

public interface AuthService {
    UserAuthResponseDTO login(UserAuthRequestDTO request);
    UserAuthResponseDTO register(UserAuthRequestDTO request);
}
