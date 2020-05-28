package core.helpers;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonDecomposer {

    public <T> T decomposeFile(Class<T> modelClass) {
        String className = getClassName(modelClass);
        return generateInstance(modelClass, className);
    }

    private String getClassName(Class<?> className) {
        return className.getSimpleName();
    }

    private <T> T generateInstance(final Class<T> instance, final String className) {
        ObjectMapper reader = new ObjectMapper();
        try {
            return reader.readValue(new File(FilePathGenerator.generateFilePath(className)), instance);
        } catch (IOException e) {
            throw new RuntimeException("The document " + className + " isn't JSON", e);
        }
    }
}
