package com.ApiFramework.ex01_RestAssured_HelloWorld;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class HelloWorld_01 {

    @Test
    public void test_HelloWorld() {
        RestAssured
                .given()
                .relaxedHTTPSValidation() // <-- ADD THIS LINE to bypass SSL certificate issues
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/ping")
                .log().all() // <-- ADD THIS to see what you are sending
                .when()
                .get()
                .then()
                .log().all() // <-- ADD THIS to see the error message in the console
                .statusCode(201); // Note: Heroku's /ping endpoint actually returns 201 (Created), not 200!
    }
}
