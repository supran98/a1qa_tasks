package Utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtils {
    public static JSONArray getJsonArray(String json_arr) {
        try {
            JSONParser parser = new JSONParser();
            return  (JSONArray) parser.parse(json_arr);
        }
        catch (ParseException | NullPointerException e) {
            return null;
        }
    }
    public static String getJsonValue(String key, String json_str) {
        try {
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(json_str);

            return json.get(key).toString();
        }
        catch (ParseException | NullPointerException e) {
            return null;
        }
    }
    public static JSONObject convertToJson(String json_str) {
        try {
            JSONParser parser = new JSONParser();
            return (JSONObject) parser.parse(json_str);
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
    public static boolean equals(String json1_str, String json2_str) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode node1 = objectMapper.readTree(json1_str);
            JsonNode node2 = objectMapper.readTree(json2_str);
            return node1.equals(node2);
        }
        catch (JsonProcessingException e) {
            return false;
        }
    }
}
