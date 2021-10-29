package Utils;

public class Utils {
    public static boolean idIsAscending(String json_str) {
        int posts_count = JsonUtils.getJsonArray(json_str).size();
        int exp_id = 1;
        for (int i = 0; i < posts_count; i++) {
            String post_obj = JsonUtils.getJsonArray(json_str).get(i).toString();
            int id = Integer.parseInt(JsonUtils.getJsonValue("id", post_obj));
            if (id != exp_id++)
                return false;
        }
        return true;
    }
}
