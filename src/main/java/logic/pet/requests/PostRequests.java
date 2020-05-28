package logic.pet.requests;

import endpoints.IPetEndpoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.pet.PetData;

public class PostRequests {

    public Response createPet(PetData body){
        return RestAssured.given()
                .body(body)
                .when()
                    .post(IPetEndpoints.createPet)
                .then()
                    .extract().response();

    }
}
