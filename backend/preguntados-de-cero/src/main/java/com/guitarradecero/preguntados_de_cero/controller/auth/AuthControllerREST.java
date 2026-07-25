package com.guitarradecero.preguntados_de_cero.controller.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthControllerREST {

    @PostMapping("/login")
    public String login(){
        return "login from public endpoint";
    }

    @PostMapping("/register")
    public String register(){
        return "register from public endpoint";
    }
}
