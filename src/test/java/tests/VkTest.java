package tests;

import UI.WebElements.Image;
import UI.WebElements.Post;
import UI.WebPages.AuthPage;
import UI.WebPages.FeedPage;
import UI.WebPages.HomePage;
import Utils.BrowserUtils;
import Utils.Config;
import Utils.StringUtils;
import Utils.VkApiUtils.Comments;
import Utils.VkApiUtils.Likes;
import Utils.VkApiUtils.Publications;
import org.testng.Assert;
import org.testng.annotations.*;
import usermodel.User;
import java.io.File;

public class VkTest {
    private Post post;
    private HomePage home;
    private final String text_to_post = StringUtils.getRandomStringFromJson(Config.getProperty("strings"));
    private final String upd_msg = StringUtils.getRandomStringFromJson(Config.getProperty("strings"));
    private final String comment = StringUtils.getRandomStringFromJson(Config.getProperty("strings"));
    private final String comment_author = User.getName();
    private static int comment_id;
    private static boolean comment_created = false;
    private final String user_id = Integer.toString(User.getUserId());

    @BeforeClass (groups = {"auth", "afterAuth"})
    private void setUp() {
        BrowserUtils.initDriver();
    }
    @AfterClass (groups = {"auth", "afterAuth"})
    private void tearDown() {
        BrowserUtils.quitDriver();
    }

    @BeforeGroups (groups = {"auth"})
    private void openAuthPage() {
        BrowserUtils.get(Config.get("AuthTest.auth_url"));
    }
    @BeforeGroups (groups = {"afterAuth"})
    private void openUserPage() {
        BrowserUtils.get(User.getHomepageUrl());
    }

    @Test (groups = {"auth"}, priority = 1)
    public void authTest() {
        AuthPage auth_page = new AuthPage();

        Assert.assertTrue(auth_page.isDisplayed(), "Auth page not displayed\n");
        auth_page.enterLogin(User.getLogin());
        auth_page.enterPassword(User.getPassword());
        auth_page.clickSignInBtn();

        FeedPage feed = new FeedPage();
        Assert.assertTrue(feed.isDisplayed(), "Authentication failed\n");
    }

    @Test (groups = {"afterAuth"}, priority = 2)
    public void postOnWall() {
        home = new HomePage();
        Assert.assertTrue(home.isDisplayed(), "Page not opened\n");

        int post_id = Publications.postOnWall(text_to_post);
        post = new Post(post_id);
        Assert.assertEquals(home.getPostText(post), text_to_post, "Unexpected post text\n");
        Assert.assertEquals(home.getPostAuthorName(post), User.getName(), "Unexpected author name\n");
    }

    @Test (groups = {"afterAuth"}, priority = 3)
    public void editPost() {
        File photo = new File(Config.getProperty("test_image"));
        int photo_id = Publications.editPost(post.getId(), upd_msg, photo);
        Image image = new Image(post.getId());

        Assert.assertTrue(image.isDisplayed(), "Uploaded image not displayed\n");
        Assert.assertTrue(image.getPhotoId().contains(Integer.toString(photo_id)), "Returned id doesn't match "+
                "uploaded photo id\n");
        Assert.assertEquals(home.getPostText(post), upd_msg, "Post didn't update");
    }

    @Test (groups = {"afterAuth"}, priority = 4, retryAnalyzer = Repeater.class)
    public void createComment() {
        if (!comment_created) {
            comment_id = Comments.createComment(comment, post.getId());
            comment_created = true;
        } // test may fail, because the comment added using api request, is not visible.
       // after refreshing we should not create another one, but check the existing comment; otherwise the error repeats

        Assert.assertEquals(home.getPostComment(post, comment_id), comment, "Wrong comment text or comment" +
                "written in wrong post\n");
        Assert.assertEquals(home.getCommentAuthorName(post, comment_id), comment_author, "Wrong author name\n");
    }

    @Test (groups = {"afterAuth"}, priority = 5)
    public void likeTest() {
        Assert.assertFalse(Likes.getUsersLiked(post.getId()).toString().contains(user_id), "User has " +
                "already liked the post\n");
        home.like(post);
        Assert.assertTrue(Likes.getUsersLiked(post.getId()).toJSONString().contains(user_id), "The post " +
                "is not liked\n");
    }

    @Test (groups = {"afterAuth"}, priority = 6)
    public void deletePostTest() {
        Publications.deletePost(post.getId());
        Assert.assertFalse(home.postExists(post.getId()));
    }
}
