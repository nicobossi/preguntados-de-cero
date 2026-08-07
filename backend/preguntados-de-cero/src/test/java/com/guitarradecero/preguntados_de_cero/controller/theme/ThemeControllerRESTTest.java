package com.guitarradecero.preguntados_de_cero.controller.theme;

import com.guitarradecero.preguntados_de_cero.IntegrationTest;
import com.guitarradecero.preguntados_de_cero.model.difficulty.Difficulty;
import com.guitarradecero.preguntados_de_cero.model.theme.Theme;
import com.guitarradecero.preguntados_de_cero.persistence.sql.difficulty.DifficultyDAO;
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
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.postgresql.PostgreSQLContainer;

import static io.restassured.RestAssured.given;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
class ThemeControllerRESTTest extends IntegrationTest {

    @LocalServerPort
    private Integer port;

    @Autowired
    ThemeDAO themeDAO;

    @Autowired
    DifficultyDAO difficultyDAO;

    @Autowired
    ThemeServiceImpl themeService;

    @Autowired
    DifficultyService difficultyService;

    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "http://localhost:" + port;
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

    @AfterEach
    void tearDown(){ // horrible, capaz conviene borrar directamente este test
        themeDAO.deleteAll();
        difficultyDAO.deleteAll();
    }
}