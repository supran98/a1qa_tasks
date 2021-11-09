package UI.WebElements;

import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import usermodel.User;

public class Post {
    private final String post_xpath_body = "//div[@id = 'post%s_%s']";
    private final String post_author_lbl = "//a[@class = 'author']";
    private final String post_content_xpath = "//div[@id = 'wpt%s_%s']";
    private final String comment_author_lbl = "//div[@id = 'post%s_%s']//div[@class = 'reply_author']//a";
    private final String like_btn_xpath = "//div[@id = 'post%s_%s']//div[@class = 'PostButtonReactions__icon ']";
    private final String parent_xpath;
    private final int user_id;
    private final int post_id;

    public Post(int post_id) {
        this.post_id = post_id;
        this.user_id = User.getUserId();
        parent_xpath = String.format(post_xpath_body, user_id, post_id);
    }
    public String getAuthorName() {
        WebElement author_label = BrowserUtils.waitForElement(parent_xpath + post_author_lbl);
        return author_label.getText();
    }
    public String getText() {
        String child_xpath = String.format(post_content_xpath, user_id, post_id);
        WebElement text_label = BrowserUtils.getDriver().findElement(By.xpath(parent_xpath + child_xpath));
        return text_label.getText();
    }
    public String getComment(int comment_id) {
        String child_xpath = String.format(post_content_xpath, user_id, comment_id);
        WebElement comment_label = BrowserUtils.getDriver().findElement(By.xpath(parent_xpath + child_xpath));
        return comment_label.getText();
    }
    public String getCommentAuthor(int comment_id) {
        String child_xpath = String.format(comment_author_lbl, user_id, comment_id);
        WebElement comment_author_name = BrowserUtils.getDriver().findElement(By.xpath(parent_xpath + child_xpath));
        return comment_author_name.getText();
    }
    public void like() {
        String locator = String.format(like_btn_xpath, user_id, post_id);
        BrowserUtils.getDriver().findElement(By.xpath(locator)).click();
    }
    public int getId() {
        return post_id;
    }
    public int getUserId() {
        return user_id;
    }
}
