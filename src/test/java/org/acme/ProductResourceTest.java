package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.RepeatedTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class ProductResourceTest {

    @RepeatedTest(21)
    void testTimeout() {
        given()

                .accept(ContentType.JSON)
                .when().get("/products")
                .then()
                .statusCode(200)
                .body("content.size()", is(10));
    }
}
