package com.guitarradecero.preguntados_de_cero.testContainers;

import org.testcontainers.postgresql.PostgreSQLContainer;

public class PostgresContainer {

    private static final String image = "postgres:17-alpine";

    private static PostgreSQLContainer container = null;

    static public PostgreSQLContainer getInstance() {
        if(container == null) {
            container = new PostgreSQLContainer(image)
                    .withDatabaseName("postgres-test")
                    .withUsername("postgres-username")
                    .withPassword("postgres-password");
        }
        return container;
    }
}
