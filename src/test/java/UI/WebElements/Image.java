package UI.WebElements;

import Utils.BrowserUtils;
import Utils.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Image {
    private final int post_id;
    private final int user_id;
    private final int default_uid = Integer.parseInt(Config.get("TestUser2.user_id"));
    private final String img_xpath;
    private WebElement image;

    public Image(int post_id) {
        this.post_id = post_id;
        this.user_id = default_uid;
        String img_xpath_body = "//div[@id = 'post%s_%s']//div[@class = 'page_post_sized_thumbs  clear_fix']//a";
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
