package logic.pet.requests;

import endpoints.PetEndpoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j;
import models.pet.PetData;

@Log4j
public class PostRequests {

    public Response createPet(PetData body){
        return RestAssured.given()
                .body(body)
                .when()
                    .post(PetEndpoints.CREATE_PET)
                .then()
                    .extract().response();

    }
}
