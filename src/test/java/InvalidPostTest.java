import Utils.ApiUtils;
import Utils.DataManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InvalidPostTest {
    private final String url = DataManager.getTestData("Global.base_url") + DataManager.EndPoints.USERS.get() +
            DataManager.getTestData("InvalidPostTest.post_number");
    @Test
    public void requestInvalidPost() {
        ApiUtils.get(url);

        Assert.assertEquals(ApiUtils.getStatusCode(), 404, "Unexpected status code\n");
        Assert.assertEquals(ApiUtils.getResponseBody(), "{}", "Unexpected response body\n");
    }
}
