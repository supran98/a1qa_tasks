package Utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.*;

public class DataManager {
    private static final String filename = "src/test/test_data/TestData.json";
    public static String getTestData(String key) {
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

    public static String read(String filename) {
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            return sb.toString();
        }
        catch (IOException e) {
        }
        return null;
    }
}
