package logic.pet.requests;

import endpoints.PetEndpoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetRequests {
    public Response getPetById(String id) {
        return RestAssured.when()
                .get(PetEndpoints.GET_PET_BY_ID + id)
                .then()
                    .extract().response();
    }

    public Response getPetsList(String status) {
        return RestAssured.given()
                .param("status", status)
                .when()
                    .get(PetEndpoints.FIND_PET_BY_STATUS)
                .then()
                    .extract().response();
    }
}
