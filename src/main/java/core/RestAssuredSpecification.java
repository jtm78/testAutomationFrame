package core;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;

public class RestAssuredSpecification {
    public static final ThreadLocal<RestAssuredSpecification> instance = new ThreadLocal<>();

    public static RestAssuredSpecification getInstance() {
        if (instance.get() == null)
            instance.set(new RestAssuredSpecification());
        return instance.get();
    }

    private RestAssuredSpecification() {
    }

    public RequestSpecBuilder getBaseSpecification() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .setBasePath(ConfigProperties.getInstance().getBasePath())
                .setBaseUri(ConfigProperties.getInstance().getBaseUrl());
    }

}
