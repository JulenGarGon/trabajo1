package es.upsa.dasi.domain.desarrollador.adapters.input.rest;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class DesarrolladorResourceTest {
    @Test
    void testHelloEndpoint() {
        given()
          .when().get("/desarrollador")
          .then()
             .statusCode(200)
             .body(is("Hello RESTEasy"));
    }

}