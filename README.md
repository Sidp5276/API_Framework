# API Automation Framework (REST ASSURED)

A Java-based API Automation Framework built using Rest Assured, TestNG, Maven, and Allure Reporting. This project covers API testing fundamentals, TestNG concepts, request validations, payload management, and reporting, making it suitable for learning and demonstrating API automation skills.

---

## Tech Stack

- Java
- Rest Assured
- TestNG
- Maven
- Allure Reports
- JSON

---

## Project Overview

This framework contains examples and implementations of:

- Rest Assured Basics
- HTTP Methods (GET, POST, PUT, PATCH, DELETE)
- TestNG Annotations
- TestNG Groups
- TestNG Parameters
- Test Dependencies
- Test Priorities
- Assertions and Validations
- Payload Management
- Allure Reporting
- API Test Automation Best Practices

---

## Project Structure

```text
API_Framework
│
├── src
│   └── test
│       ├── java
│       │   ├── TASK
│       │   │   └── Zippopotamus.java
│       │   │
│       │   └── com.ApiFramework
│       │       ├── ex01_RestAssured_HelloWorld
│       │       ├── ex02_RestAssured_Basics
│       │       ├── ex03_RestAssured_TestNG
│       │       │   ├── GET
│       │       │   ├── POST
│       │       │   ├── PUT
│       │       │   ├── PATCH
│       │       │   └── DELETE
│       │       │
│       │       ├── ex04_TestNGAdvanceExample
│       │       ├── ex05_TestValidations
│       │       └── ex06_Payload_Management
│       │
│       ├── TestNG_Groups_15.xml
│       ├── TestNG_Groups_15_Sanity.xml
│       ├── TestNG_Groups_15_Smoke.xml
│       ├── TestNG_param_17_chrome.xml
│       └── zippo.xml
│
├── allure-results
│
└── pom.xml
```

---

## HTTP Methods Covered

### GET
- Retrieve API data
- Validate status codes
- Verify response body

### POST
- Create resources
- Validate request payloads
- Verify response data

### PUT
- Update complete resources
- Validate updated data

### PATCH
- Partial resource updates
- Response verification

### DELETE
- Resource deletion validation
- Status code verification

---

## TestNG Features Implemented

- @Test Annotation
- @BeforeTest
- @AfterTest
- Priority
- DependsOnMethods
- Groups
- Smoke Tests
- Sanity Tests
- Parameters
- Invocation Count
- Enabled Attribute
- AlwaysRun Attribute

---

## Validation Techniques

- Status Code Validation
- Response Body Validation
- Header Validation
- Content Type Validation
- Response Time Validation
- TestNG Assertions
- Rest Assured Assertions

---

## Sample API Tested

### Zippopotam.us API

Endpoint:

https://api.zippopotam.us/in/560037

Validations:
- Status Code Check
- Country Validation
- State Validation
- Place Name Validation
- Header Verification
- Content Type Verification
- Response Time Verification

---

## Running the Tests

Run all tests:

```bash
mvn clean test
```

Run specific TestNG suite:

```bash
mvn test -DsuiteXmlFile=src/test/zippo.xml
```

Run Smoke Suite:

```bash
mvn test -DsuiteXmlFile=src/test/TestNG_Groups_15_Smoke.xml
```

Run Sanity Suite:

```bash
mvn test -DsuiteXmlFile=src/test/TestNG_Groups_15_Sanity.xml
```

---

## Allure Reporting

Generate Allure Results:

```bash
mvn clean test
```

Generate Allure Report:

```bash
allure generate allure-results --clean -o allure-report
```

Open Report:

```bash
allure open allure-report
```

Serve Report:

```bash
allure serve allure-results
```

---

## Learning Outcomes

This project demonstrates practical knowledge of:

- API Automation Testing
- Rest Assured Framework Development
- TestNG Execution Strategies
- API Response Validation
- JSON Payload Handling
- Test Reporting with Allure
- Maven Project Management
- Automation Framework Structure

---

## Author

Developed as a hands-on API Automation Framework for learning and implementing industry-standard API testing practices using Rest Assured and TestNG.
