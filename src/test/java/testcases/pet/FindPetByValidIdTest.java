package testcases.pet;

import core.assertions.DefaultAssert;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import logic.pet.PetOperations;
import logic.pet.requests.GetRequests;
import models.pet.PetData;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testcases.BaseTest;

import java.math.BigInteger;


public class FindPetByValidIdTest extends BaseTest {
    private PetData requestModel;

    @BeforeClass
    public void createPet() {
        requestModel = PetOperations.generatePetData();
        PetOperations petOperations = new PetOperations(requestModel);
        petOperations.create();
    }

    @Test
    public void findUserById() {
        Response response = sendGetRequestAndCheckCode(requestModel.getId(), HttpStatus.SC_OK);
        PetData responseModel = response.as(PetData.class);
        checkOutIdFromResponse(responseModel.getId(), requestModel.getId());
        checkOutName(responseModel.getName(), requestModel.getName());
    }

    @Step("Step 1: Send get request with id: {petId} and check status code is {statusCode}")
    private Response sendGetRequestAndCheckCode(BigInteger petId, int statusCode) {
        Response response = new GetRequests().getPetById(petId.toString());
        DefaultAssert.assertStatusCode(response, statusCode);
        return response;
    }

    @Step("Step 2: Check out ID from response is {expectedResult}")
    private void checkOutIdFromResponse(BigInteger actualResult, BigInteger expectedResult) {
        Assert.assertEquals(actualResult, expectedResult, "IDs are different");
    }

    @Step("Step 3: Check out Name from response is {expectedResult}")
    private void checkOutName(String actualResult, String expectedResult) {
        Assert.assertEquals(actualResult, expectedResult, "Names aren't equal");
    }
}
