package com.ApiFramework.ex_05_TestValidations;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class APITesting024_TestNG_Assertions {


//    @Test
//    public void test_hardAssertExample() {
//        System.out.println("Start of the program");
//        Assert.assertEquals("pramod", "Pramod");
//        System.out.println("End of the program");
//    }


    @Test
    public void test_softAssertExample() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("golden","golden");
        System.out.println("End of program");
        softAssert.assertAll();
    }
}
