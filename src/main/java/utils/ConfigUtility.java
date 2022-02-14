package utils;

import enums.Paths;
import enums.Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtility {
    private static Properties property;

    private ConfigUtility() {
    }

    public static void setConfigUtility() {
        try {
            LoggerUtility.info("Creating a utility for the config file");
            FileInputStream fis = new FileInputStream(Paths.RESOURCES + Resources.CONFIG.toString());
            property = new Properties();
            property.load(fis);
        } catch (IOException e) {
            LoggerUtility.error("ERROR: config file is missing");
            throw new RuntimeException();
        }
    }

    public static String getStringValue(String key) {
        setConfigUtility();
        LoggerUtility.info("Getting a text value '" + key + "' from config file ");
        return property.getProperty(key);
    }

    public static int getIntValue(String key) {
        setConfigUtility();
        LoggerUtility.info("Getting an integer value '" + key + "' from config file ");
        return Integer.parseInt(property.getProperty(key));
    }
}