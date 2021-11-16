package Utils;

import Utils.Enums.Data;
import Utils.Enums.Paths;
import com.jayway.jsonpath.JsonPath;
import java.io.File;
import java.io.IOException;

public class Config {
    private static final String default_data_file = Paths.RESOURCES.get() + Data.JSONDATA.get();

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
}
