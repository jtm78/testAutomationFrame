package logic.pet;

import core.helpers.JsonDecomposer;
import core.helpers.RandomGenerator;
import io.restassured.response.Response;
import logic.pet.requests.PostRequests;
import models.pet.PetData;
import java.util.List;

public class PetOperations {
    private PetData data;

    public PetOperations(PetData data) {
        this.data = data;
    }

    public PetData create() {
        Response createdUserResponse = new PostRequests().createPet(data);
        return createdUserResponse.as(PetData.class);
    }

    public PetData findPetFromListById(List<PetData> list) {
        return list.stream()
                .filter(pet -> pet.getId().toString().equals(data.getId().toString()))
                .findFirst()
                .get();
    }

    public static PetData generatePetData() {
        PetData petData = new JsonDecomposer().decomposeFileIntoObject(PetData.class);
        petData.setId(RandomGenerator.generateNumeric());
        petData.setName(RandomGenerator.generateAlphabetic());
        return petData;
    }
}
