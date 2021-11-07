package Utils;

import org.json.simple.JSONArray;
import usermodel.User;

import java.io.File;

public class VkApiUtils {
    public static int postOnWall(String message) {
        String request = baseRequest("wall.post") + "&message=" + message;
        return Integer.parseInt(
                JsonUtils.getJsonValue(ApiUtils.post(request), "$.response.post_id"));
    }
    public static int editPost(int post_id, String upd, File image) {
        String upload_url = getWallUploadServer();
        String response = ApiUtils.post(upload_url, image);

        String photo = JsonUtils.getJsonValue(response, "$.photo");
        String server = JsonUtils.getJsonValue(response, "$.server");
        String hash = JsonUtils.getJsonValue(response, "$.hash");

        String response2 = ApiUtils.postPhoto(baseRequest("photos.saveWallPhoto"), photo, server, hash);
        int photo_id = Integer.parseInt(JsonUtils.getJsonValue(response2, "$.response[0].id"));

        String attachments = String.format("photo%s_%s", User.getUserId(), photo_id);
        String request = baseRequest("wall.edit") + "&post_id=" + post_id + "&message=" + upd;
        ApiUtils.post(request, attachments);
        return photo_id;
    }
    public static void editPost(int post_id, String upd) {
        String request = baseRequest("wall.edit") + "&post_id=" + post_id + "&message=" + upd;
        ApiUtils.post(request);
    }
    private static String baseRequest(String method) {
        String request_body = "%s/method/%s?user_id=%s&v=%s&access_token=%s";
        return String.format(request_body, Config.get("Api.base_api_uri"), method,
                User.getUserId(), Config.get("Api.api_version"), User.getAccessToken());
    }
    private static String getWallUploadServer() {
        String response = ApiUtils.get(baseRequest("photos.getWallUploadServer"));
        return JsonUtils.getJsonValue(response, "$.response.upload_url");
    }
    public static int createComment(String comment, int post_id) {
        String request = baseRequest("wall.createComment") + "&post_id=" + post_id + "&message=" + comment;
        return Integer.parseInt(
                JsonUtils.getJsonValue(ApiUtils.post(request), "$.response.comment_id"));
    }
    public static JSONArray getUsersLiked(int post_id) {
        String request = baseRequest("likes.getList") + "&type=post" + "&item_id=" + post_id;
        String response = JsonUtils.getJsonValue(ApiUtils.get(request), "$.response.items");
        return JsonUtils.getJsonArray(response);
    }
    public static int deletePost(int post_id) {
        String request = baseRequest("wall.delete") + "&post_id=" + post_id;
        return Integer.parseInt(
                JsonUtils.getJsonValue(ApiUtils.post(request), "$.response"));
    }
}
