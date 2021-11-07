package tests;

import UI.WebElements.Image;
import Utils.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;

public class EditPostTest extends BaseTest{
    private final String update = StringUtils.getRandomString(Config.getProperty("strings"));
    @Test
    public void editPost() {
        File photo = new File(Config.getProperty("test_image"));
        int photo_id = VkApiUtils.editPost(post.getId(), update, photo);
        Image image = new Image(post.getId());

        Assert.assertTrue(image.isDisplayed(), "Uploaded image not displayed\n");
        Assert.assertTrue(image.getPhotoId().contains(Integer.toString(photo_id)), "Returned id doesn't match "+
                                                                                            "uploaded photo id\n");
        Assert.assertEquals(home.getPostText(post), update, "Post didn't update");
    }
}
