package Utils.VkApiUtils;

import Utils.Config;
import usermodel.User;

public class VkApiUtils {
    public static String baseRequest(String method) {
        String request_body = "%s/method/%s?user_id=%s&v=%s&access_token=%s";
        return String.format(request_body, Config.get("Api.base_api_uri"), method,
                User.getUserId(), Config.get("Api.api_version"), User.getAccessToken());
    }
}
