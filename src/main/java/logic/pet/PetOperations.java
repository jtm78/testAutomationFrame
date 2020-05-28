package logic.pet;

import core.helpers.JsonDecomposer;
import io.restassured.response.Response;
import logic.pet.requests.PostRequests;
import models.pet.PetData;

import java.util.List;

public class PetOperations {
    private PetData data;

    private PetOperations(PetData data) {
        this.data = data;
    }

    public PetData create() {
        Response createdUserResponse = new PostRequests().createPet(data);
        return createdUserResponse.as(PetData.class);
    }

    public static PetData findPetFromListById(List<PetData> list, String id) {
        return list.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .get();
    }

    public static class Builder {
        private PetData instance;

        public Builder() {
            instance = new JsonDecomposer().decomposeFile(PetData.class);
        }

        public Builder setId(String id) {
            instance.setId(id);
            return this;
        }

        public Builder setName(String name) {
            instance.setName(name);
            return this;
        }

        public Builder setStatus(String status) {
            instance.setStatus(status);
            return this;
        }

        public PetOperations build() {
            return new PetOperations(instance);
        }
    }

}
