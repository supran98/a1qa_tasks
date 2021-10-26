package Utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.*;
import java.util.Random;

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
    public static String getRandomString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }
    public enum EndPoints {
        POSTS("/posts"), USERS("/users"), TYPE_JSON("application/json; charset=utf-8");

        private String endpoint;
        EndPoints(String str) {
            endpoint = str;
        }
        public String get() {
            return endpoint;
        }
    }
}
