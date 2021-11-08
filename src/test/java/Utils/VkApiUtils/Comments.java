package Utils.VkApiUtils;

import Utils.ApiUtils;
import Utils.JsonUtils;

public class Comments {
    public static int createComment(String comment, int post_id) {
        String request = VkApiUtils.baseRequest("wall.createComment") + "&post_id=" + post_id + "&message=" + comment;
        return Integer.parseInt(
                JsonUtils.getJsonValue(ApiUtils.post(request), "$.response.comment_id"));
    }
}
