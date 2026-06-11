package com.ApiFramework.ex02_RestAssured_Basics;

    public class APITesting001_NP {

        public void step1() {
            System.out.println("Step 1");
        }
        public void step2() {
            System.out.println("Step 2");
        }

        public void step3(String param1) {
            System.out.println("Step 3");
        }

        public static void main(String[] args) {
            APITesting001_NP np = new APITesting001_NP();
            np.step1();
            np.step2();
            np.step3("sid");
        }
    }
