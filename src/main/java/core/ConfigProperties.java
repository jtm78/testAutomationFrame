package core;

import lombok.Getter;
import core.helpers.PropertiesLoaderHelper;

import java.util.Properties;

@Getter
public class ConfigProperties {
    public static final ThreadLocal<ConfigProperties> instance = new ThreadLocal<>();

    public static ConfigProperties getInstance() {
        if (instance.get() == null)
            instance.set(new ConfigProperties());
        return instance.get();
    }

    private static final String BASE_URL_CONFIG = "base.url";
    private static final String BASE_PATH = "base.path";

    private String baseUrl;
    private String basePath;

    private ConfigProperties() {
        Properties properties = PropertiesLoaderHelper.getProperties("config.properties");
        baseUrl = properties.getProperty(BASE_URL_CONFIG);
        basePath = properties.getProperty(BASE_PATH);

    }
}
