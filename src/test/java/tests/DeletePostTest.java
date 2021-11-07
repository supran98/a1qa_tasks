package tests;

import Utils.VkApiUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeletePostTest extends BaseTest {
    @Test
    public void deletePostTest() {
        VkApiUtils.deletePost(post.getId());
        Assert.assertFalse(home.postExists(post.getId()));
    }
}
