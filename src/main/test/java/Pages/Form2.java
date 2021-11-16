package Pages;

import Utils.DialogRobot;
import aquality.selenium.browser.AqualityServices;
import org.openqa.selenium.By;

public class Form2 extends BaseForm {
    private final String page_indicator_xpath = "//div[text() = '2 / 4']";
    private final String upload_link_xpath = "//a[@class = 'avatar-and-interests__upload-button']";
    private final String checkboxes_xpath = "(//span[@class = 'icon icon-check checkbox__check'])[%s]";
    private final String button_next_xpath = "//button[@class = 'button button--stroked button--white button--fluid']";
    private final String download_img_btn_xpath = "//button[text() = 'Download image']";

    public boolean isDisplayed() {
        return elementFactory.getLabel(By.xpath(page_indicator_xpath), "indicator").state().isDisplayed();
    }

    public void upload_avatar() {
        downloadDefaultImage();
        elementFactory.getLink(By.xpath(upload_link_xpath), "upload_link").click();
        addFileFromDialogWindow();
    }
    public void ChooseInterests() {
        AqualityServices.getBrowser().scrollWindowBy(0, 300);

        final int checkboxes_to_uncheck = 17;
        for (int i=1; i<checkboxes_to_uncheck; i++) {
            String locator = String.format(checkboxes_xpath, i);
            elementFactory.getCheckBox(By.xpath(locator), "cb").click();
        }
    }
    public void goToNextForm() {
        elementFactory.getButton(By.xpath(button_next_xpath), "btn_next").click();
    }
    private void addFileFromDialogWindow() {
        if (System.getProperty("os.name").equals("Linux"))
            handleLinuxDialogWindow();
        else
            handleDialogWindow();

    }
    private void handleLinuxDialogWindow() {
        try {
            DialogRobot.addToClipBoard("Pictures");
            DialogRobot.openSearchBar();
            DialogRobot.paste();
            DialogRobot.pressEnter();
            Thread.sleep(1000);
            DialogRobot.pressEnter();
            Thread.sleep(1000);
            DialogRobot.pressEnter();
            Thread.sleep(1000);
            DialogRobot.pressEnter();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private void handleDialogWindow() {
        try {
            DialogRobot.addToClipBoard("please, choose an image manually");
            DialogRobot.paste();
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private void downloadDefaultImage() {
        elementFactory.getButton(By.xpath(download_img_btn_xpath), "download_btn").click();
        DialogRobot.pressEnter();
    }
}
