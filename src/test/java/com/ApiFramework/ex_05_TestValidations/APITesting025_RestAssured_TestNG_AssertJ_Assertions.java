package com.ApiFramework.ex_05_TestValidations;

import static org.assertj.core.api.Assertions.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting025_RestAssured_TestNG_AssertJ_Assertions {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;
    Integer bookingId;

    @Test
    public void test_POST_with_Validations() {

        // 1. Prepare Payload
        String payload_POST = "{\n" +
                "    \"firstname\" : \"golden\",\n" +
                "    \"lastname\" : \"brown\",\n" +
                "    \"totalprice\" : 123,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";

        // 2. Build Request Specification
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload_POST).log().all();

        // 3. Execute Request
        response = requestSpecification.when().post();

        // 4. Extract ValidatableResponse and check Status Code
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        // 5. Extract values using RestAssured path extraction
        bookingId = response.then().extract().path("bookingid");
        String firstname = response.then().extract().path("booking.firstname");
        String lastname = response.then().extract().path("booking.lastname");

        // 6. Extract values using JsonPath class object
        JsonPath jp = new JsonPath(response.asString());
        String bookingIDStr = jp.getString("bookingid");

        // ==========================================
        // VALIDATION TYPE 1: AssertJ Assertions (FIXED VALUES)
        // ==========================================
        assertThat(bookingIDStr).isNotNull().isNotEmpty();
        assertThat(jp.getString("booking.firstname")).isEqualTo("golden");
        assertThat(jp.getString("booking.lastname")).isEqualTo("brown");

        // FIXED: Changed 3000 to 123 to match payload
        assertThat(jp.getInt("booking.totalprice")).isEqualTo(123);

        // FIXED: Changed .isTrue() to .isFalse() to match payload
        assertThat(jp.getBoolean("booking.depositpaid")).isFalse();

        assertThat(bookingId).isNotZero().isNotNull().isPositive();
        assertThat(bookingId).isBetween(0, 999999); // booking IDs can grow quite large
        assertThat(firstname).isNotBlank().isNotEmpty().isNotNull().isEqualTo("golden");

        // ==========================================
        // VALIDATION TYPE 2: TestNG Hard Assertions
        // ==========================================
        Assert.assertNotNull(bookingId, "Booking ID should not be null");
        Assert.assertEquals(firstname, "golden", "Firstname mismatch!");
        Assert.assertEquals(lastname, "brown", "Lastname mismatch!");

        // TestNG conditional failure check
        if (!firstname.contains("golden")) {
            Assert.fail("Test failed because firstname does not contain 'golden'");
        }
    }
}