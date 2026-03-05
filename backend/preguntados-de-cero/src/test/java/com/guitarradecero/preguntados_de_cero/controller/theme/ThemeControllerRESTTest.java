package com.guitarradecero.preguntados_de_cero.controller.theme;

import com.guitarradecero.preguntados_de_cero.model.difficulty.Difficulty;
import com.guitarradecero.preguntados_de_cero.model.theme.Theme;
import com.guitarradecero.preguntados_de_cero.persistence.sql.theme.ThemeDAO;
import com.guitarradecero.preguntados_de_cero.service.DifficultyService;
import com.guitarradecero.preguntados_de_cero.service.impl.ThemeServiceImpl;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;


import static io.restassured.RestAssured.given;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class ThemeControllerRESTTest {
    @LocalServerPort
    private Integer port;

    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(
            "postgres:17-alpine"
    );

    @BeforeAll
    static void beforeAll() {
        postgres.start();
    }

    @AfterAll
    static void afterAll() {
        postgres.stop();
    }

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
        registry.add("spring.datasource.driver-class-name", () -> "org.postgresql.Driver");
    }

    @Autowired
    ThemeDAO themeDAO;
    @Autowired
    ThemeServiceImpl themeService;
    @Autowired
    DifficultyService difficultyService;

    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "http://localhost:" + port;
//        themeDAO.deleteAll();
    }

    @Test
    void shouldGetAllThemes() {
        Difficulty persistedDifficulty = difficultyService.save(new Difficulty(1));
        themeService.saveTheme(new Theme("Ritmo","Esta es la descripcion de ritmo"), persistedDifficulty.getId());
        themeService.saveTheme(new Theme("Arpegio","Esta es la descripcion de arpegio"), persistedDifficulty.getId());

        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/theme/1")
                .then()
                .statusCode(200)
                .body(".", hasSize(2));
    }
}