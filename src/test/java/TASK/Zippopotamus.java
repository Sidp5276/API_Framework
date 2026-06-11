package TASK;

import io.restassured.http.ContentType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Zippopotamus {

    private static final String BASE_URL = "https://api.zippopotam.us/";

    @Description("Test cases")
    @Test(priority = 1)
    public void verifyValidPostalCode() {

        given()
                .when()
                .get(BASE_URL + "in/560037")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .time(lessThan(5000L))
                .body("country", equalTo("India"))
                .body("country abbreviation", equalTo("IN"))
                .body("post code", equalTo("560037"))
                .body("places.size()", greaterThan(0))
                .body("places[0].state", equalTo("Karnataka"))
                .body("places[0].place name", equalTo("Ramesh Nagar"));
    }

    // =========================
    // Negative Test Cases
    // =========================

    @DataProvider(name = "negativeData")
    public Object[][] negativeData() {

        return new Object[][]{

                // TC01 - Invalid postal code
                {"in/999999"},

                // TC02 - Alphabetic postal code
                {"in/abcdef"},

                // TC03 - Special characters
                {"in/@#$%^"},

                // TC04 - Empty postal code
                {"in/"},

                // TC05 - Invalid country code
                {"xx/560037"},

                // TC06 - Numeric country code
                {"11/560037"},

                // TC07 - Postal code too long
                {"in/560037999999"},

                // TC08 - SQL Injection
                {"in/' OR 1=1 --"},

                // TC09 - XSS Injection
                {"in/<script>alert(1)</script>"},

                // TC10 - Negative number
                {"in/-560037"}
        };
    }

    @Test(dataProvider = "negativeData", priority = 2)
    public void verifyNegativeScenarios(String endpoint) {

        given()
                .when()
                .get(BASE_URL + endpoint)
                .then()
                .statusCode(404);
    }

    // =========================
    // Wrong HTTP Methods
    // =========================

    @Test(priority = 3)
    public void verifyPostMethodNotAllowed() {

        given()
                .when()
                .post(BASE_URL + "in/560037")
                .then()
                .statusCode(anyOf(is(404), is(405)));
    }

    @Test(priority = 4)
    public void verifyDeleteMethodNotAllowed() {

        given()
                .when()
                .delete(BASE_URL + "in/560037")
                .then()
                .statusCode(anyOf(is(404), is(405)));
    }
}