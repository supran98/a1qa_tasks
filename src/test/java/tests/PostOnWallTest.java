package tests;

import UI.WebElements.Post;
import UI.WebPages.HomePage;
import Utils.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostOnWallTest extends BaseTest {
    private final String text_to_post = StringUtils.getRandomString(Config.getProperty("strings"));
    private final String author_name = Config.get("TestUser2.name");
    @Test
    public void postOnWall() {
        BrowserUtils.get(Config.get("TestUser2.homepage"));
        home = new HomePage();
        Assert.assertTrue(home.isDisplayed(), "Page not opened\n");

        int post_id = VkApiUtils.postOnWall(text_to_post);
        post = new Post(post_id);
        Assert.assertEquals(home.getPostText(post), text_to_post, "Unexpected post text\n");
        Assert.assertEquals(home.getPostAuthorName(post), author_name, "Unexpected author name\n");
    }
}
