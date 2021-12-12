package Utils;

import Utils.Enums.Data;
import Utils.Enums.Paths;
import com.jayway.jsonpath.JsonPath;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static final String default_data_file = Paths.RESOURCES.get() + Data.JSONDATA.get();
    private static final String default_props_file = Paths.RESOURCES.get() + Data.PROPERTIES.get();

    public static String get(String jsonpath, File json) {
        try {
            return JsonPath.parse(json).read(jsonpath).toString();
        } catch (IOException e) {
            return null;
        }
    }
    public static String get(String jsonpath) {
        try {
            return JsonPath.parse(new File(default_data_file)).read(jsonpath).toString();
        } catch (IOException e) {
            return null;
        }
    }

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
