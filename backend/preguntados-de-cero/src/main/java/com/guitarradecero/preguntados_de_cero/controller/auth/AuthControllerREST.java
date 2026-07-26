package com.guitarradecero.preguntados_de_cero.controller.auth;

import com.guitarradecero.preguntados_de_cero.adapter.auth.UserAuthMapper;
import com.guitarradecero.preguntados_de_cero.adapter.auth.UserMapper;
import com.guitarradecero.preguntados_de_cero.dto.auth.UserAuthRequestDTO;
import com.guitarradecero.preguntados_de_cero.dto.auth.UserAuthResponseDTO;
import com.guitarradecero.preguntados_de_cero.service.AuthService;
import com.guitarradecero.preguntados_de_cero.configuration.jwt.jwtService.JwtService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Getter
@Setter
@RestController
@RequestMapping("/api/auth")
public class AuthControllerREST {

    private final AuthService authService;

    public AuthControllerREST(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<UserAuthResponseDTO> login(@RequestBody UserAuthRequestDTO userAuthDto){
        String token = authService.login(UserMapper.INSTANCE.dtoToModel(userAuthDto));
        return ResponseEntity.ok(UserAuthMapper.INSTANCE.modelToDto(token));
    }

    @PostMapping("/register")
    public ResponseEntity<UserAuthResponseDTO> register(@RequestBody UserAuthRequestDTO userAuthDto){
        String token = authService.register(UserMapper.INSTANCE.dtoToModel(userAuthDto));
        return ResponseEntity.ok(UserAuthMapper.INSTANCE.modelToDto(token));
    }
}
