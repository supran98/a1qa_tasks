import Utils.*;
import org.json.simple.JSONArray;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

public class GetUsersTest {
    private String url = DataManager.getTestData("Global.base_url") + Enums.EndPoints.USERS.get();
    Map<String, Object> user = new HashMap<>();
    private final String user_data = ConfigManager.getConfigData("test_data_dir") + "/User5.json";
    @Test
    public void getUsers() {
        ApiUtils.get(url);
        Assert.assertEquals(ApiUtils.getStatusCode(), Enums.StatusCodes.OK.get(), "Unexpected status code\n");
        Assert.assertEquals(ApiUtils.getContentType(), Enums.ContentTypes.TYPE_JSON.get(), "Unexpected content type\n");

        ApiUtils.getWithParams(url, user);
        JSONArray response_arr = JsonUtils.getJsonArray(ApiUtils.getResponseBody());
        Assert.assertEquals(response_arr.size(), 1, "Wrong returned array's size\n"); // the only element should be found
        Assert.assertEquals(response_arr.get(0), JsonUtils.convertToJson(DataManager.read(user_data)), "Unexpected response body\n");
    }
    @BeforeTest
    private void fillId() {
        user.put("id", DataManager.getTestData("GetUsersTest.user_id"));
    }
}
