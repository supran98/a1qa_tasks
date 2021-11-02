package Utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.util.Properties;

public class Config {
    private static final String properties_file = "src/test/resources/data.properties";
    private static final String data_file = "src/test/resources/TestData.json";

    public static String getProperty(String property) {
        Properties props = new Properties();
        try (InputStream input = new FileInputStream(properties_file)) {
            props.load(input);
            return props.getProperty(property);
        }
        catch(Exception exception) {
            return null;
        }
    }
    private static String getData(String key, String filename) {
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
    public static String get(String key, String filename) {
        return getData(key, filename);
    }
    public static String get(String key) {
        return getData(key, data_file);
    }
}
