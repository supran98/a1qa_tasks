import Utils.ApiUtils;
import Utils.DataManager;
import Utils.JsonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetAllPostsTest {
    private final String url = DataManager.getTestData("Global.base_url") + DataManager.EndPoints.POSTS.get();
    @Test
    public void getAllPostsTest() {
        ApiUtils.get(url);

        Assert.assertEquals(ApiUtils.getStatusCode(), 200, "Unexpected status code\n");
        Assert.assertEquals(ApiUtils.getContentType(), DataManager.EndPoints.TYPE_JSON.get(), "Unexpected content type\n");
        Assert.assertTrue(idIsAscending(), "Wrong id order\n");
    }
    private boolean idIsAscending() {
        int posts_count = JsonUtils.getJsonArray(ApiUtils.getResponseBody()).size();
        int exp_id = 1;
        for (int i = 0; i < posts_count; i++) {
            String post_obj = JsonUtils.getJsonArray(ApiUtils.getResponseBody()).get(i).toString();
            int id = Integer.parseInt(JsonUtils.getJsonValue("id", post_obj));
            if (id != exp_id++)
                return false;
        }
        return true;
    }

}
