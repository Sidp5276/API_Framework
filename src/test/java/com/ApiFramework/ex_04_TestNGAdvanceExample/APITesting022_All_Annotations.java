package com.ApiFramework.ex_04_TestNGAdvanceExample;

import org.testng.annotations.*;

public class APITesting022_All_Annotations {

    @BeforeTest
    void demo4(){
        System.out.println("BeforeMethod");
    }

    @Test
    void demo5(){
        System.out.println("Test");
    }

    @AfterTest
    void demo6(){
        System.out.println("AfterMethod");
    }
}
