package core.helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoaderHelper {

    public static Properties getProperties(final String configName) {
        Properties properties = new Properties();
        try (InputStream inputStream = new FileInputStream(Constants.RESOURCES_PATH + configName)) {
            properties.load(inputStream);
            return properties;
        } catch (IOException e) {
            throw new RuntimeException("Unable to find " + e);
        }
    }
}
