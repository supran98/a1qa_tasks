package Utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
    private static final String properties_file = "src/test/resources/config.properties";
    public static String getConfigData(String property) {
        Properties props = new Properties();
        try (
                InputStream input = new FileInputStream(properties_file)) {
            props.load(input);
            return props.getProperty(property);
        }
        catch(Exception exception) {
            return null;
        }
    }
}
