package testcases.pet;

import core.assertions.DefaultAssert;
import io.restassured.response.Response;
import logic.pet.PetOperations;
import logic.pet.requests.GetRequests;
import models.pet.PetData;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import testcases.BaseTest;

public class FindPetByValidIdTest extends BaseTest {
    private PetData petData;

    @BeforeClass
    public void createPet() {
        petData = PetOperations.generatePetData();
        PetOperations petOperations = new PetOperations(petData);
        petOperations.create();
    }

    @Test
    public void findUserById() {
        Response response = new GetRequests().getPetById(petData.getId().toString());
        DefaultAssert.assertStatusCode(response, HttpStatus.SC_OK);
        PetData response1 = response.as(PetData.class);
        Assert.assertEquals(response1.getName(), petData.getName(), "Names are different");
        Assert.assertEquals(response1.getId(), petData.getId(), "IDs are different");
    }
}
