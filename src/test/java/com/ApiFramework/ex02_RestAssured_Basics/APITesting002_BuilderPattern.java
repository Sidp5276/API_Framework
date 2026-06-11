package com.ApiFramework.ex02_RestAssured_Basics;

public class APITesting002_BuilderPattern {


    public APITesting002_BuilderPattern step1() {
        System.out.println("Step 1");
        return this;
    }

    public APITesting002_BuilderPattern step2() {
        System.out.println("Step 2");
        return this;
    }


    public APITesting002_BuilderPattern step3(String param1) {
        System.out.println("Step 3");
        return this;
    }

    public static void main(String[] args) {
        APITesting002_BuilderPattern bp = new APITesting002_BuilderPattern();
        bp.step1().step2().step3("sid");
    }
}
