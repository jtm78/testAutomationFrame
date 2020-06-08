package testcases.pet;

import core.assertions.DefaultAssert;
import core.helpers.JsonDecomposer;
import core.helpers.RandomGenerator;
import io.restassured.response.Response;
import logic.pet.PetOperations;
import logic.pet.requests.PostRequests;
import models.pet.PetData;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import testcases.BaseTest;

public class CreatePetTest extends BaseTest {

    @Test
    public void createPetAndCheckOutStatusCode() {
        PetData requestModel = PetOperations.generatePetData();
        Response response = new PostRequests().createPet(requestModel);
        DefaultAssert.assertStatusCode(response, HttpStatus.SC_OK);
        PetData responseModel = response.as(PetData.class);
        Assert.assertEquals(requestModel.getId(), responseModel.getId(), "IDs are different");
        Assert.assertEquals(requestModel.getName(), responseModel.getName(), "Names are different ");
    }
}
