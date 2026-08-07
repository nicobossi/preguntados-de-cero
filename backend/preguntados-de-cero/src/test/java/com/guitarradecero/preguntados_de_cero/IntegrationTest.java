package com.guitarradecero.preguntados_de_cero;

import com.guitarradecero.preguntados_de_cero.testContainers.PostgresContainer;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.postgresql.PostgreSQLContainer;

@ActiveProfiles("test")
public abstract class IntegrationTest {

    protected static PostgreSQLContainer container = PostgresContainer.getInstance();

    static {
        container.start();
    }

    @DynamicPropertySource
    static void config(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", container::getJdbcUrl);
        registry.add("spring.datasource.username", container::getUsername);
        registry.add("spring.datasource.password", container::getPassword);
        registry.add("spring.datasource.driver-class-name", () -> "org.postgresql.Driver");
        registry.add("jwt.secret", () -> "secret-key-secret-key-secret-key-secret-key=");
    }
}
