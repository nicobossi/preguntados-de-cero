package com.guitarradecero.preguntados_de_cero.controller.auth;

import com.guitarradecero.preguntados_de_cero.adapter.AuthMapper;
import com.guitarradecero.preguntados_de_cero.dto.auth.AuthRequestDto;
import com.guitarradecero.preguntados_de_cero.dto.auth.AuthResponseDto;
import com.guitarradecero.preguntados_de_cero.model.auth.Auth;
import com.guitarradecero.preguntados_de_cero.orchestrator.AuthOrchestrator;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private AuthOrchestrator orchestrator;

    public AuthController(AuthOrchestrator orchestrator) {
        this.orchestrator = orchestrator;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody @Valid AuthRequestDto credentials) {
        Auth auth = orchestrator.auth(credentials.email(), credentials.password());
        AuthResponseDto authResponseDto = AuthMapper.INSTANCE.modelToDto(auth);
        return ResponseEntity.ok()
                .header("Authorization", "Bearer ", auth.token())
                .body(authResponseDto);
    }
}
