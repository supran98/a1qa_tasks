package Utils.VkApiUtils;

import Utils.ApiUtils;
import Utils.JsonUtils;
import usermodel.User;
import java.io.File;

public class Publications {
    public static int postOnWall(String message) {
        String request = VkApiUtils.baseRequest("wall.post") + "&message=" + message;
        return Integer.parseInt(
                JsonUtils.getJsonValue(ApiUtils.post(request), "$.response.post_id"));
    }
    public static int editPost(int post_id, String upd, File image) {
        String upload_url = getWallUploadServer();
        String response = ApiUtils.uploadPhoto(upload_url, image);

        String photo = JsonUtils.getJsonValue(response, "$.photo");
        String server = JsonUtils.getJsonValue(response, "$.server");
        String hash = JsonUtils.getJsonValue(response, "$.hash");

        String response2 = ApiUtils.postPhoto(VkApiUtils.baseRequest("photos.saveWallPhoto"), photo, server, hash);
        int photo_id = Integer.parseInt(JsonUtils.getJsonValue(response2, "$.response[0].id"));

        String attachments = String.format("photo%s_%s", User.getUserId(), photo_id);
        String request = VkApiUtils.baseRequest("wall.edit") + "&post_id=" + post_id + "&message=" + upd;
        ApiUtils.postAttachments(request, attachments);
        return photo_id;
    }
    public static void editPost(int post_id, String upd) {
        String request = VkApiUtils.baseRequest("wall.edit") + "&post_id=" + post_id + "&message=" + upd;
        ApiUtils.post(request);
    }
    public static int deletePost(int post_id) {
        String request = VkApiUtils.baseRequest("wall.delete") + "&post_id=" + post_id;
        return Integer.parseInt(
                JsonUtils.getJsonValue(ApiUtils.post(request), "$.response"));
    }
    private static String getWallUploadServer() {
        String response = ApiUtils.get(VkApiUtils.baseRequest("photos.getWallUploadServer"));
        return JsonUtils.getJsonValue(response, "$.response.upload_url");
    }
}
