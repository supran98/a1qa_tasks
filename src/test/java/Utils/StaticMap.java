package Utils;

import java.util.HashMap;
import java.util.Map;

public class StaticMap {
    private static Map<String, String> map = new HashMap<>();

    public static void put(String key, String value) {
        map.put(key, value);
    }
    public static String get(String value) {
        return map.get(value);
    }
}
