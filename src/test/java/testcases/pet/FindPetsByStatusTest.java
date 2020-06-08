package testcases.pet;

import core.assertions.DefaultAssert;
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

import java.util.List;

public class FindPetsByStatusTest extends BaseTest {

    @DataProvider(name = "statusesType")
    public Object[] validStatuses(){
        return new Object[]{
                StatusType.AVAILABLE,
                StatusType.PENDING,
                StatusType.SOLD
        };
    }

    @Test(dataProvider = "statusesType")
    public void findPetsByStatus(StatusType type) {
        PetData petData = PetOperations.generatePetData()
                .setStatus(type.getStatusName());
        PetOperations petOperations = new PetOperations(petData);
        petOperations.create();

        Response response = new GetRequests().getPetsList(petData.getStatus());
        DefaultAssert.assertStatusCode(response, HttpStatus.SC_OK);
        List<PetData> listWithPets = ListOperations.convertResponseToList(response, PetData[].class);
        PetData petFromList = petOperations.findPetFromListById(listWithPets);
        Assert.assertEquals(petFromList.getId(), petData.getId(), "IDs are different");
        Assert.assertEquals(petFromList.getStatus(), petData.getStatus(), "Statuses are different");
    }
}
