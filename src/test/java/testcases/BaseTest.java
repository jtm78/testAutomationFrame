package testcases;


import core.RestAssuredSpecification;

import io.restassured.RestAssured;

import org.testng.annotations.BeforeTest;

public class BaseTest {

    @BeforeTest(alwaysRun = true)
    public void setRestAssuredConfiguration(){
        RestAssured.requestSpecification = RestAssuredSpecification.getInstance()
                .getBaseSpecification().build();
        RestAssured
                .enableLoggingOfRequestAndResponseIfValidationFails();
    }

}
