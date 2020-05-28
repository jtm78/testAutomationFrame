package testcases.pet;

import core.assertions.DefaultAssert;
import core.helpers.RandomGenerator;
import io.restassured.response.Response;
import logic.pet.PetOperations;
import logic.pet.requests.GetRequests;
import models.pet.PetData;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testcases.BaseTest;

public class FindPetByValidIdTest extends BaseTest {
    private PetData createdPet;

    @BeforeClass
    public void createPet() {
        PetOperations pet = new PetOperations.Builder()
                .setId(RandomGenerator.generateNumeric())
                .setName(RandomGenerator.generateAlphabetic())
                .build();
        createdPet = pet.create();
    }

    @Test
    public void findUserById() {
        Response response = new GetRequests().getPetById(createdPet.getId());
        DefaultAssert.assertStatusCode(response, HttpStatus.SC_OK);
        PetData response1 = response.as(PetData.class);
        Assert.assertEquals(response1.getName(), createdPet.getName(), "Names are different");
        Assert.assertEquals(response1.getId(), createdPet.getId(), "IDs are different");
    }
}
