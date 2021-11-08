package Utils.VkApiUtils;

import Utils.ApiUtils;
import Utils.JsonUtils;
import org.json.simple.JSONArray;

public class Likes {
    public static JSONArray getUsersLiked(int post_id) {
        String request = VkApiUtils.baseRequest("likes.getList") + "&type=post" + "&item_id=" + post_id;
        String response = JsonUtils.getJsonValue(ApiUtils.get(request), "$.response.items");
        return JsonUtils.getJsonArray(response);
    }
}
