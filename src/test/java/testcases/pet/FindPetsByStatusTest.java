package testcases.pet;

import core.assertions.DefaultAssert;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import core.ListOperations;
import logic.pet.PetOperations;
import logic.pet.StatusType;
import logic.pet.requests.GetRequests;
import models.pet.PetData;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.*;
import testcases.BaseTest;

import java.math.BigInteger;
import java.util.List;

public class FindPetsByStatusTest extends BaseTest {
    private PetOperations petOperations;

    @DataProvider(name = "statusesType")
    public Object[] validStatuses() {
        return new Object[]{
                StatusType.AVAILABLE,
                StatusType.PENDING,
                StatusType.SOLD
        };
    }

    @Test(dataProvider = "statusesType")
    public void findPetsByStatus(StatusType type) {
        PetData requestModel = createPetWithStatus(type);
        Response response = findPetsByStatusAndCheckStatusCode(requestModel.getStatus(), HttpStatus.SC_OK);
        PetData responsePetFromList = findCreatedPetInList(response);
        checkOutId(responsePetFromList.getId(), requestModel.getId());
        checkOutStatus(responsePetFromList.getStatus(), requestModel.getStatus());
    }

    @Step("Step 1: Create pet with status type : {statusType}")
    private PetData createPetWithStatus(StatusType statusType) {
        PetData petData = PetOperations.generatePetData()
                .setStatus(statusType.getStatusName());
        petOperations = new PetOperations(petData);
        petOperations.create();
        return petData;
    }

    @Step("Step 2: Find list of pets by status: {statusType} and check out status Code is {statusCode}")
    private Response findPetsByStatusAndCheckStatusCode(String statusType, int statusCode) {
        Response response = new GetRequests().getPetsList(statusType);
        DefaultAssert.assertStatusCode(response, statusCode);
        return response;
    }

    @Step("Step 3: Find created pet in List")
    private PetData findCreatedPetInList(Response response) {
        List<PetData> listWithPets = ListOperations.convertResponseToList(response, PetData[].class);
        return petOperations.findPetFromListById(listWithPets);
    }

    @Step("Step 4: Check out ID from response is {expectedResult}")
    private void checkOutId(BigInteger actualResult, BigInteger expectedResult) {
        Assert.assertEquals(actualResult, expectedResult, "IDs are different");
    }

    @Step("Step 5: Check out Status from response is {expectedResult}")
    private void checkOutStatus(String actualResult, String expectedResult) {
        Assert.assertEquals(actualResult, expectedResult, "Names aren't equal");
    }
}
