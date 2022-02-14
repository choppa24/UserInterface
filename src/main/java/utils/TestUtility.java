package utils;

import enums.Paths;
import enums.Resources;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestUtility {
    private static Properties property;

    private TestUtility() {
    }

    public static void setTestUtility() {
        try {
            LoggerUtility.info("Creating a utility for the test file");
            FileInputStream fis = new FileInputStream(Paths.RESOURCES + Resources.TEST.toString());
            property = new Properties();
            property.load(fis);
        } catch (IOException var1) {
            LoggerUtility.error("ERROR: test file is missing");
            throw new RuntimeException();
        }
    }

    public static String getStringValue(String key) {
        LoggerUtility.info("Getting a text value '" + key + "' from config file ");
        return property.getProperty(key);
    }

    public static int getIntValue(String key) {
        LoggerUtility.info("Getting an integer value '" + key + "' from config file ");
        return Integer.parseInt(property.getProperty(key));
    }
}