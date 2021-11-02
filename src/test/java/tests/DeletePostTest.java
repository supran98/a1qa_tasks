package tests;

import Utils.BrowserUtils;
import Utils.Config;
import Utils.VkApiUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeletePostTest extends BaseTest {
    @Test
    public void deletePostTest() {
        BrowserUtils.get(Config.get("TestUser2.homepage"));

        VkApiUtils.deletePost(post.getId());
        Assert.assertFalse(home.postExists(post.getId()));
    }
}
