package usermodel;

import Utils.Config;
import Utils.JsonUtils;
import Utils.Utils;

public class User {
    private static final String jsondata = Utils.readFile(Config.getProperty("test_data"));
    private static final int user_id = Integer.parseInt(Config.getProperty("user"));
    private static final String name = JsonUtils.getJsonValue(jsondata, "$." + user_id + ".name");
    private static final String access_token = JsonUtils.getJsonValue(jsondata, "$." + user_id + ".access_token");
    private static final String homepage_url = JsonUtils.getJsonValue(jsondata, "$." + user_id + ".homepage");

    public static String getName() {
        return name;
    }

    public static int getUserId() {
        return user_id;
    }

    public static String getAccessToken() {
        return access_token;
    }

    public static String getHomepageUrl() {
        return homepage_url;
    }
    public static String getPassword() {
        return Config.get(user_id + ".password", Config.getProperty("credentials"));
    }
    public static String getLogin() {
        return Config.get(user_id + ".login", Config.getProperty("credentials"));
    }
}
