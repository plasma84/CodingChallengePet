package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBPropertyUtil {
    public static String getConnectionString(String propertyFileName) throws IOException {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(propertyFileName)) {
            properties.load(fis);
        }
        return properties.getProperty("connectionString");
    }
}