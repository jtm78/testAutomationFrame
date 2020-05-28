package logic.pet.requests;

import endpoints.IPetEndpoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetRequests {
    public Response getPetById(String id) {
        return RestAssured.when()
                .get(IPetEndpoints.getPetById + id)
                .then()
                    .extract().response();
    }

    public Response getPetsList(String status) {
        return RestAssured.given()
                .param("status", status)
                .when()
                    .get(IPetEndpoints.findPetsByStatus)
                .then()
                    .extract().response();
    }
}
