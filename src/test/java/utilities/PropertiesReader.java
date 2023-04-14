package utilities;

import java.io.FileInputStream;
import java.util.Properties;

// This utility will contain relevant code to read the Configuration.properties file
public class PropertiesReader {
    private static Properties configFile;
    static {
        try {
            // path or 'file name' of the content to read and store in heap memory
            FileInputStream fileInputStream = new FileInputStream("Configuration.properties");
            configFile = new Properties();
            configFile.load(fileInputStream);
            fileInputStream.close();
        } catch (Exception e) {
            System.out.println("Failed to load properties");
            e.printStackTrace();
        }
    }

    // The method we will frequently call (getter) to take a key's value
    public static String getProperties(String key) {
        return configFile.getProperty(key);
    }
}
