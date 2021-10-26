import Utils.ApiUtils;
import Utils.DataManager;
import Utils.JsonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetUserTest {
    private final String user_data = "src/test/test_data/User5.json";
    String url = DataManager.getTestData("Global.base_url") + DataManager.EndPoints.USERS.get() +
            DataManager.getTestData("GetUserTest.user_number");
    @Test
    public void getUser() {
        ApiUtils.get(url);

        Assert.assertEquals(ApiUtils.getStatusCode(), 200, "Unexpected status code\n");
        Assert.assertEquals(JsonUtils.convertToJson(ApiUtils.getResponseBody()),
                            JsonUtils.convertToJson(DataManager.read(user_data)), "Unexpected response body\n");
    }
}
