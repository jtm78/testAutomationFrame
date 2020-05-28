package core;

import com.sun.istack.NotNull;
import io.restassured.response.Response;

import java.util.Arrays;
import java.util.List;

public class ListOperations {

    public static <T>List<T> convertResponseToList(@NotNull Response response, Class<T[]> model){
        return Arrays.asList(response.as(model));
    }
}
