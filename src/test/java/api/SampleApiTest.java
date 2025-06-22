package api;

import io.restassured.http.ContentType;
//import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class SampleApiTest {

    @Test
    public void testGetUser() {
        given()
            .baseUri("https://reqres.in")
        .when()
            .get("/api/users/2")
        .then()
            .statusCode(200)
            .body("data.id", equalTo(2))
            .body("data.email", containsString("@reqres.in"));
    }

    @Test
    public void testPostUser() {
        String requestBody = "{ \"name\": \"Shubham\", \"job\": \"QA\" }";

        given()
            .baseUri("https://reqres.in")
            .contentType(ContentType.JSON)
            .body(requestBody)
        .when()
            .post("/api/users")
        .then()
            .statusCode(201)
            .body("name", equalTo("Shubham"))
            .body("job", equalTo("QA"));
    }

    @Test
    public void testPutUser() {
        String requestBody = "{ \"name\": \"Shubham\", \"job\": \"Lead QA\" }";

        given()
            .baseUri("https://reqres.in")
            .contentType(ContentType.JSON)
            .body(requestBody)
        .when()
            .put("/api/users/2")
        .then()
            .statusCode(200)
            .body("name", equalTo("Shubham"))
            .body("job", equalTo("Lead QA"));
    }

    @Test(enabled=false)
    public void testDeleteUser() {
        given()
            .baseUri("https://reqres.in")
        .when()
            .delete("/api/users/2")
        .then()
            .statusCode(204);
    }
}
