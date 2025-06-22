package api;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class ApiBase {
    protected RequestSpecification getRequest() {
        return RestAssured.given()
                .baseUri("https://reqres.in")
                .header("Content-Type", "application/json");
    }
}
