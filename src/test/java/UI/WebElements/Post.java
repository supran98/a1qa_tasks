package UI.WebElements;

import Utils.BrowserUtils;
import Utils.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Post {
    private WebElement post;
    private final String post_xpath_body = "//div[@id = 'post%s_%s']";
    private final String parent_xpath;
    private final int default_uid = Integer.parseInt(Config.get("TestUser2.user_id"));
    private final int user_id;
    private final int post_id;

    public Post(int user_id, int post_id) {
        this.user_id = user_id;
        this.post_id = post_id;
        parent_xpath = String.format(post_xpath_body, user_id, post_id);
        post = BrowserUtils.getDriver().findElement(By.xpath(parent_xpath));
    }
    public Post(int post_id) {
        this.post_id = post_id;
        this.user_id = default_uid;
        parent_xpath = String.format(post_xpath_body, user_id, post_id);
        post = BrowserUtils.getDriver().findElement(By.xpath(parent_xpath));
    }
    public String getAuthorName() {
        String child_xpath = "//a[@class = 'author']";
        WebElement author_label = BrowserUtils.waitForElement(parent_xpath + child_xpath);
        return author_label.getText();
    }
    public String getText() {
        String child_xpath = String.format("//div[@id = 'wpt%s_%s']", user_id, post_id);
        WebElement text_label = BrowserUtils.getDriver().findElement(By.xpath(parent_xpath + child_xpath));
        return text_label.getText();
    }
    public String getComment(int comment_id) {
        String child_xpath = String.format("//div[@id = 'wpt%s_%s']", user_id, comment_id);
        WebElement comment_label = BrowserUtils.getDriver().findElement(By.xpath(parent_xpath + child_xpath));
        return comment_label.getText();
    }
    public String getCommentAuthor(int comment_id) {
        String child_xpath = String.format(
                "//div[@id = 'post%s_%s']//div[@class = 'reply_author']//a", user_id, comment_id);
        WebElement comment_author_name = BrowserUtils.getDriver().findElement(By.xpath(parent_xpath + child_xpath));
        return comment_author_name.getText();
    }
    public void like() {
        String locator = String.format("//div[@id = 'post%s_%s']//div[@class = 'PostButtonReactions__icon ']",
                user_id, post_id);
        BrowserUtils.getDriver().findElement(By.xpath(locator)).click();
    }
    public int getId() {
        return post_id;
    }
    public int getUserId() {
        return user_id;
    }
}
