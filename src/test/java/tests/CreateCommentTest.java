package tests;

import Utils.Config;
import Utils.StringUtils;
import Utils.VkApiUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import usermodel.User;

public class CreateCommentTest extends BaseTest {
    private String comment = StringUtils.getRandomString(Config.getProperty("strings"));
    private String comment_author = User.getName();
    @Test
    public void createComment() {
        int comment_id = VkApiUtils.createComment(comment, post.getId());
        Assert.assertEquals(home.getPostComment(post, comment_id), comment, "Wrong comment text or comment" +
                                                                                        "written in wrong post\n");
        Assert.assertEquals(home.getCommentAuthorName(post, comment_id), comment_author, "Wrong author name\n");
    }
}
