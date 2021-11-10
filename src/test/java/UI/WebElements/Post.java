package UI.WebElements;

import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import usermodel.User;

public class Post {
    private final String post_xpath_body = "//div[@id = 'post%s_%s']";
    private final String post_author_lbl_xpath = "//a[@class = 'author']";
    private final String post_content_xpath = "//div[@id = 'wpt%s_%s']";
    private final String comment_lbl_xpath = "//div[@class = 'PostBottomAction PostBottomAction--withBg comment _comment  _reply_wrap']";
    private final String comment_author_lbl = "//div[@id = 'post%s_%s']//div[@class = 'reply_author']//a";
    private final String comment_xpath = "//div[@class = 'wall_reply_text']";
    private final String like_btn_xpath = "//div[@id = 'post%s_%s']//div[@class = 'PostButtonReactions__icon ']";
    private final String show_next_comments_span = "//span[@class = 'js-replies_next_label']";
    private final String parent_xpath;
    private final int user_id;
    private final int post_id;

    public Post(int post_id) {
        this.post_id = post_id;
        this.user_id = User.getUserId();
        parent_xpath = String.format(post_xpath_body, user_id, post_id);
    }
    public String getAuthorName() {
        WebElement author_label = BrowserUtils.waitForElement(parent_xpath + post_author_lbl_xpath);
        return author_label.getText();
    }
    public String getText() {
        String child_xpath = String.format(post_content_xpath, user_id, post_id);
        WebElement text_label = BrowserUtils.getDriver().findElement(By.xpath(parent_xpath + child_xpath));
        return text_label.getText();
    }
    public String getComment(int comment_id) {
        String comment_content_xpath = String.format(post_xpath_body, user_id, comment_id);
        if (commentFound(comment_id))
            return BrowserUtils.getDriver().findElement(By.xpath(comment_content_xpath)).getText();
        else
            return findComment(comment_id);
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
    private boolean commentFound(int comment_id) {
        String locator = String.format(post_xpath_body, user_id, comment_id);
        return BrowserUtils.getDriver().findElements(By.xpath(locator)).size() != 0;
    }
    private String findComment(int id) {
        String post_content_xpath = String.format(post_xpath_body, user_id, id);
        String locator = parent_xpath + comment_lbl_xpath;
        WebElement comment_lbl = BrowserUtils.getDriver().findElement(By.xpath(locator));
        int comments_count = Integer.parseInt(comment_lbl.getAttribute("data-count"));

        for (int i=0; i<comments_count; i++) {
            BrowserUtils.getDriver().findElement(By.xpath(parent_xpath + show_next_comments_span)).click();
            if (commentFound(id))
                return BrowserUtils.getDriver().findElement(By.xpath(post_content_xpath + comment_xpath)).getText();
        }
        return "";
    }
}
