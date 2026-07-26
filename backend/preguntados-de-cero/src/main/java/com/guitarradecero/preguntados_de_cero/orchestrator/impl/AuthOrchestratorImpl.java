package com.guitarradecero.preguntados_de_cero.orchestrator.impl;

import com.guitarradecero.preguntados_de_cero.model.auth.Auth;
import com.guitarradecero.preguntados_de_cero.orchestrator.AuthOrchestrator;
import org.springframework.stereotype.Service;

@Service
public class AuthOrchestratorImpl implements AuthOrchestrator {
    @Override
    public Auth auth(String email, String password) {
        return null;
    }
}
