package com.ApiFramework.ex01_RestAssured_HelloWorld;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import org.testng.annotations.*;

public class HelloWorld {

@Test
public void test_Hello(){
    RestAssured.given().baseUri("https://google.com").log().all().when().get().then().statusCode(200).log().all();
}
}
