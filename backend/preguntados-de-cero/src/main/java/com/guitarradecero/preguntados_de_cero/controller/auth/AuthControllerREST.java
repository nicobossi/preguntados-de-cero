package com.guitarradecero.preguntados_de_cero.controller.auth;

import com.guitarradecero.preguntados_de_cero.dto.auth.UserAuthRequestDTO;
import com.guitarradecero.preguntados_de_cero.dto.auth.UserAuthResponseDTO;
import com.guitarradecero.preguntados_de_cero.service.AuthService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<UserAuthResponseDTO> login(@RequestBody UserAuthRequestDTO request){
        return ResponseEntity.ok(authService.login(request)); // hay que refactorizar el service tambien, deberia llegar un model
    }

    @PostMapping("/register")
    public ResponseEntity<UserAuthResponseDTO> register(@RequestBody UserAuthRequestDTO request){
        return ResponseEntity.ok(authService.register(request)); //armar mapper para User
    }
}
