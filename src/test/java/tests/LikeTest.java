package tests;

import Utils.BrowserUtils;
import Utils.Config;
import Utils.VkApiUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LikeTest extends BaseTest {
    private String user_id = Config.get("TestUser2.user_id");
    @Test
    public void likeTest() {
        BrowserUtils.get(Config.get("TestUser2.homepage"));
        Assert.assertFalse(VkApiUtils.getUsersLiked(post.getId()).toString().contains(user_id), "User has " +
                                                                                        "already liked the post\n");
        home.like(post);
        Assert.assertTrue(VkApiUtils.getUsersLiked(post.getId()).toJSONString().contains(user_id), "The post " +
                                                                                        "is not liked\n");
    }
}
