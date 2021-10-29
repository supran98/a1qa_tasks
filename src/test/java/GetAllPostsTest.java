import Utils.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetAllPostsTest {
    private final String url = DataManager.getTestData("Global.base_url") + Enums.EndPoints.POSTS.get();
    @Test
    public void getAllPostsTest() {
        ApiUtils.get(url);

        Assert.assertEquals(ApiUtils.getStatusCode(), Enums.StatusCodes.OK.get(), "Unexpected status code\n");
        Assert.assertEquals(ApiUtils.getContentType(), Enums.ContentTypes.TYPE_JSON.get(), "Unexpected content type\n");
        Assert.assertTrue(Utils.idIsAscending(ApiUtils.getResponseBody()), "Wrong id order\n");
    }


}
