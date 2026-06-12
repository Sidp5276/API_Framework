package com.ApiFramework.ex_04_TestNGAdvanceExample;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class APITesting017_TestNG_Parameter {

    @Parameters("browser")
    @Test
    public void demo1(String value) {
        System.out.println("Hi i am demo");
        System.out.println("You are running this param");

        if(value.equalsIgnoreCase("chrome")){
            System.out.println("Start the chrome");
        }
        if(value.equalsIgnoreCase("edge")){
            System.out.println("Start the edge!");
        }

    }
}
