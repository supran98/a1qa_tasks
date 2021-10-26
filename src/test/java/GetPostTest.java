import Utils.ApiUtils;
import Utils.DataManager;
import Utils.JsonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetPostTest {
    private final String url = DataManager.getTestData("Global.base_url") + DataManager.EndPoints.POSTS.get() +
            DataManager.getTestData("GetPostTest.post_number");
    private final int expected_id = 99;
    private final int expected_user_id = 10;
    @Test
    public void getPost() {
        ApiUtils.get(url);
        Assert.assertEquals(ApiUtils.getStatusCode(), 200, "Unexpected status code\n");

        int user_id = Integer.parseInt(JsonUtils.getJsonValue("userId", ApiUtils.getResponseBody()));
        Assert.assertEquals(user_id, expected_user_id, "Unexpected user id\n");

        int id = Integer.parseInt(JsonUtils.getJsonValue("id", ApiUtils.getResponseBody()));
        Assert.assertEquals(id, expected_id, "Unexpected id\n");

        String title = JsonUtils.getJsonValue("title", ApiUtils.getResponseBody());
        Assert.assertFalse(title.isEmpty(), "Title is empty\n");

        String body = JsonUtils.getJsonValue("body", ApiUtils.getResponseBody());
        Assert.assertFalse(body.isEmpty(), "Body is empty\n");
    }
}
