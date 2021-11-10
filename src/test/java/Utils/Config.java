package Utils;

import Utils.Enums.Data;
import Utils.Enums.Paths;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.*;
import java.util.Properties;

public class Config {
    private static final String default_props_file = Paths.RESOURCES.get() + Data.PROPS.get();
    private static final String default_data_file = Paths.RESOURCES.get() + Data.JSONDATA.get();

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
    
    public static String get(String key, String filename) {
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(filename));
            JSONObject json = (JSONObject) obj;

            String parent_object = key.split("\\.")[0];
            String child_object = key.split("\\.")[1];
            JSONObject parent = (JSONObject) json.get(parent_object);

            return parent.get(child_object).toString();
        }
        catch(Exception e) {
            return null;
        }
    }
    public static String get(String key) {
        return get(key, default_data_file);
    }
}
