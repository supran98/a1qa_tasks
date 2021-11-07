package tests;

import UI.WebElements.Post;
import UI.WebPages.HomePage;
import Utils.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import usermodel.User;

public class PostOnWallTest extends BaseTest {
    private final String text_to_post = StringUtils.getRandomString(Config.getProperty("strings"));

    @Test
    public void postOnWall() {
        home = new HomePage();
        Assert.assertTrue(home.isDisplayed(), "Page not opened\n");

        int post_id = VkApiUtils.postOnWall(text_to_post);
        post = new Post(post_id);
        Assert.assertEquals(home.getPostText(post), text_to_post, "Unexpected post text\n");
        Assert.assertEquals(home.getPostAuthorName(post), User.getName(), "Unexpected author name\n");
    }
}