package UI.WebPages;

import UI.WebElements.Post;
import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage {
    private String avatar_locator = "//img[@class = 'page_avatar_img']";
    private WebElement avatar = BrowserUtils.getDriver().findElement(By.xpath(avatar_locator));

    public boolean isDisplayed() {
        return avatar.isDisplayed();
    }
    public String getPostAuthorName(Post post) {
        return post.getAuthorName();
    }
    public String getPostText(Post post) {
        return post.getText();
    }
    public String getPostComment(Post post, int comment_id) {
        return post.getComment(comment_id);
    }
    public String getCommentAuthorName(Post post, int comment_id) {
        return post.getCommentAuthor(comment_id);
    }
    public boolean postExists(int post_id) {
        String locator = String.format("//div[@id='wpt627657327_%s']", post_id);
        return !BrowserUtils.getDriver().findElements(By.xpath(locator)).isEmpty();
    }
    public void like(Post post) {
        post.like();
    }
}
