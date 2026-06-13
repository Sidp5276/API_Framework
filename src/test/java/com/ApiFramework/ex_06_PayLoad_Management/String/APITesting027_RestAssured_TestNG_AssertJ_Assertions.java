package com.ApiFramework.ex_06_PayLoad_Management.String;

import org.testng.annotations.Test;

public class APITesting027_RestAssured_TestNG_AssertJ_Assertions {
    String token;
    Integer bookingId;


    @Test
    public void test_POST() {

        String name = "golden";

        String payload_POST = "{\n" +
                "    \"firstname\" : \""+name+"\",\n" +
                "    \"lastname\" : \"brown\",\n" +
                "    \"totalprice\" : 123,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";
        // .....
    }
}
