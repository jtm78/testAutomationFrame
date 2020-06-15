package testcases.pet;

import core.assertions.DefaultAssert;
import core.testNgListeners.testRetry.UnstableTest;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import logic.pet.PetOperations;
import logic.pet.requests.PostRequests;
import models.pet.PetData;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import testcases.BaseTest;

import java.math.BigInteger;


public class CreatePetTest extends BaseTest {

    @Test
    @UnstableTest
    public void createPetAndCheckOutStatusCode() {
        PetData requestModel = generatePetModel();
        Response response = sendRequestAndCheckOutCode(requestModel, HttpStatus.SC_OK);
        PetData responseModel = response.as(PetData.class);
        checkOutId(responseModel.getId(), requestModel.getId());
        checkOutName(responseModel.getName(), requestModel.getName());
    }

    @Step("Step 1: Generate request Pet Model")
    private PetData generatePetModel() {
        return PetOperations.generatePetData();
    }

    @Step("Step 2: Send POST request for pet creation and check out status code is {statusCode}")
    private Response sendRequestAndCheckOutCode(PetData requestModel, int statusCode) {
        Response response = new PostRequests().createPet(requestModel);
        DefaultAssert.assertStatusCode(response, statusCode);
        return response;
    }

    @Step("Step 3: Check out ID from response is {expectedResult}")
    private void checkOutId(BigInteger actualResult, BigInteger expectedResult) {
        Assert.assertEquals(actualResult, expectedResult, "IDs are different");
    }

    @Step("Step 4: Check out Name from response is {expectedResult}")
    private void checkOutName(String actualResult, String expectedResult) {
        Assert.assertEquals(actualResult, expectedResult, "Names aren't equal");
    }

}
