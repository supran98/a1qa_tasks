import Utils.ApiUtils;
import Utils.DataManager;
import Utils.JsonUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

public class PostRequestTest {
    private final String url = DataManager.getTestData("Global.base_url") + DataManager.EndPoints.USERS.get();
    private final Map<String, Object> map = new HashMap<>();
    private final String title = DataManager.getRandomString();
    private final String body = DataManager.getRandomString();
    private final String user_id = DataManager.getTestData("PostRequestTest.user_id");

    @Test
    public void createPostRequest() {
        ApiUtils.post(url, map);

        String response = ApiUtils.getResponseBody();
        Assert.assertEquals(ApiUtils.getStatusCode(), 201, "Unexpected status code\n");
        Assert.assertEquals(JsonUtils.getJsonValue("title", response), title, "Response value doesn't match expected\n");
        Assert.assertEquals(JsonUtils.getJsonValue("body", response), body, "Response value doesn't match expected\n");
        Assert.assertEquals(JsonUtils.getJsonValue("userId", response), user_id, "Response value doesn't match expected\n");
        Assert.assertNotNull(JsonUtils.getJsonValue("id", response), "Id is null");
    }
    @BeforeTest
    private void fillMap() {
        map.put("title", title);
        map.put("body", body);
        map.put("userId", user_id);
    }
}
