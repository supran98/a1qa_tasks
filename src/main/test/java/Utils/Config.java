package Utils;

import Utils.Enums.Data;
import Utils.Enums.Paths;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static final String default_props_file = Paths.RESOURCES.get() + Data.PROPS.get();

    public static String getProperty(String property, String filename) {
        Properties props = new Properties();
        try (InputStream input = new FileInputStream(filename)) {
            props.load(input);
            return props.getProperty(property);
        }
        catch(Exception exception) {
            return null;
        }
    }
    public static String getProperty(String property) {
        return getProperty(property, default_props_file);
    }
}
