package Utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtils {
    public static JSONArray getJsonArray(String json_arr) {
        try {
            JSONParser parser = new JSONParser();
            return (JSONArray) parser.parse(json_arr);
        }
        catch (ParseException e) {
            return null;
        }
    }
    public static String serialize(Object json) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
        }
        catch (JsonProcessingException e) {
        }
        return null;
    }
    public static String getJsonValue(String json, String jsonpath) {
        return JsonPath.parse(json).read(jsonpath).toString();
    }
}
