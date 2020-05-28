package core.assertions;

import com.sun.istack.NotNull;
import io.restassured.response.Response;

public class DefaultAssert {

    public static void assertStatusCode(@NotNull Response response, int statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }

}
