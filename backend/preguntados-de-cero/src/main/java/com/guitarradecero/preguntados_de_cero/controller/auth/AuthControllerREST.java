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
    private final JwtService jwtService;

    public AuthControllerREST(AuthService authService, JwtService jwtService){
        this.authService = authService;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<UserAuthResponseDTO> login(@RequestBody UserAuthRequestDTO userAuthDto){
        UserDetails user = getAuthService().login(UserMapper.INSTANCE.dtoToModel(userAuthDto));
        return ResponseEntity.ok(UserAuthMapper.INSTANCE.modelToDto(getJwtService().getToken(user)));
    }

    @PostMapping("/register")
    public ResponseEntity<UserAuthResponseDTO> register(@RequestBody UserAuthRequestDTO userAuthDto){
        UserDetails user = getAuthService().register(UserMapper.INSTANCE.dtoToModel(userAuthDto));
        return ResponseEntity.ok(UserAuthMapper.INSTANCE.modelToDto(getJwtService().getToken(user)));
    }
}
