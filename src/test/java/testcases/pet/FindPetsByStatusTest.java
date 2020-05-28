package testcases.pet;

import core.assertions.DefaultAssert;
import core.helpers.RandomGenerator;
import io.restassured.response.Response;
import core.ListOperations;
import logic.pet.PetOperations;
import logic.pet.requests.GetRequests;
import models.pet.PetData;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testcases.BaseTest;

import java.util.List;

public class FindPetsByStatusTest extends BaseTest {
    private PetData createdPet;

    @BeforeClass
    public void createPet(){
        PetOperations pet = new PetOperations.Builder()
                .setId(RandomGenerator.generateNumeric())
                .setName(RandomGenerator.generateAlphabetic())
                .build();
        createdPet = pet.create();
    }

    @Test
    public void findPetsByStatus() {
        Response response = new GetRequests().getPetsList(createdPet.getStatus());
        DefaultAssert.assertStatusCode(response, HttpStatus.SC_OK);
        List<PetData> listWithPets = ListOperations.convertResponseToList(response, PetData[].class);
        PetData petFromList = PetOperations.findPetFromListById(listWithPets, createdPet.getId());
        Assert.assertEquals(petFromList.getId(), createdPet.getId(), "IDs are different");
        Assert.assertEquals(petFromList.getStatus(), createdPet.getStatus(), "Statuses are different");
    }
}
