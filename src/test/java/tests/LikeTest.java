package tests;

import Utils.VkApiUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import usermodel.User;

public class LikeTest extends BaseTest {
    private String user_id = Integer.toString(User.getUserId());
    @Test
    public void likeTest() {
        Assert.assertFalse(VkApiUtils.getUsersLiked(post.getId()).toString().contains(user_id), "User has " +
                                                                                        "already liked the post\n");
        home.like(post);
        Assert.assertTrue(VkApiUtils.getUsersLiked(post.getId()).toJSONString().contains(user_id), "The post " +
                                                                                        "is not liked\n");
    }
}
