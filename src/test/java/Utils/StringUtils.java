package Utils;

import org.json.simple.JSONArray;
import java.util.Random;

public class StringUtils {
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
    public static String getRandomString(String filename) {
        String data = Utils.readFile(filename);
        JSONArray arr = JsonUtils.getJsonArray(data);
        final int MAX = arr.size() - 1;
        int rand_num = (int) (Math.random() * MAX);
        return arr.get(rand_num).toString();
    }
}
