package utils.Managers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {
    private static Properties PROPERTIES = new Properties();

    private PropertiesManager() {
    }

    static {
        try {
            var path = new FileInputStream("src/test/resources/selenium.properties");
            PROPERTIES.load(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String key) {
        if (System.getProperty(key) != null) {
            return System.getProperty(key);
        }
        return PROPERTIES.getProperty(key);
    }

    static boolean getBoolProperty(String key) {

        return Boolean.parseBoolean(getProperty(key));
    }

    public static void setProperty(String key, String value) {

        PROPERTIES.setProperty(key, value);
    }
}
