package UI.WebElements;

import Utils.BrowserUtils;
import org.openqa.selenium.WebElement;
import usermodel.User;

public class Image {
    private final int post_id;
    private final int user_id;
    private final String img_xpath_body = "//div[@id = 'post%s_%s']//div[@class = 'page_post_sized_thumbs  clear_fix']//a";
    private final String img_xpath;
    private WebElement image;

    public Image(int post_id) {
        this.post_id = post_id;
        this.user_id = User.getUserId();
        img_xpath = String.format(img_xpath_body, user_id, post_id);
        image = BrowserUtils.waitForElement(img_xpath);
    }
    public boolean isDisplayed() {
        return image.isDisplayed();
    }
    public String getPhotoId() {
        return image.getAttribute("data-photo-id");
    }
}
