package com.guitarradecero.preguntados_de_cero.orchestrator;

import com.guitarradecero.preguntados_de_cero.model.auth.Auth;

public interface AuthOrchestrator {
    Auth auth(String email, String password);
}
