package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static final Properties prop = new Properties();

    static {
        try (InputStream is = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (is != null) {
                prop.load(is);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed loading config.properties", e);
        }
    }

    public static String get(String key) {
        return prop.getProperty(key);
    }
}
