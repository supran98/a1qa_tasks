package Pages;

import Utils.DialogRobot;
import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.waitings.IConditionalWait;
import aquality.selenium.elements.interfaces.IElementFactory;
import org.openqa.selenium.By;

public class SecondForm {
    private static IElementFactory elementFactory = AqualityServices.getElementFactory();

    private final String page_indicator_xpath = "//div[text() = '2 / 4']";
    private final String upload_link_xpath = "//a[@class = 'avatar-and-interests__upload-button']";
    private final String checkboxes_xpath = "(//span[@class = 'icon icon-check checkbox__check'])[%s]";
    private final String button_next_xpath = "//button[@class = 'button button--stroked button--white button--fluid']";
    private final String download_img_btn_xpath = "//button[text() = 'Download image']";

    private final IConditionalWait waiter = AqualityServices.getConditionalWait();
    private final int dialog_timeout = 2000;
    private final int manual_input_timeout = 20000;
    private final int checkboxes_to_uncheck = 17;
    private final int scroll_value = 300;

    public boolean isDisplayed() {
        return elementFactory.getLabel(By.xpath(page_indicator_xpath), "indicator").state().isDisplayed();
    }

    public void upload_avatar() {
        downloadDefaultImage();
        elementFactory.getLink(By.xpath(upload_link_xpath), "upload_link").click();
        addFileFromDialogWindow();
    }
    public void ChooseInterests() {
        AqualityServices.getBrowser().scrollWindowBy(0, scroll_value);

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
        synchronized (waiter) {
            try {
                DialogRobot.addToClipBoard("Pictures");
                DialogRobot.openSearchBar();
                DialogRobot.paste();
                DialogRobot.pressEnter();

                DialogRobot.pressEnter();
                waiter.wait(dialog_timeout);
                DialogRobot.pressEnter();
                waiter.wait(dialog_timeout);
                DialogRobot.pressEnter();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private void handleDialogWindow() {
        synchronized (waiter) {
            try {
                DialogRobot.addToClipBoard("please, choose an image manually");
                DialogRobot.paste();
                waiter.wait(manual_input_timeout);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private void downloadDefaultImage() {
        elementFactory.getButton(By.xpath(download_img_btn_xpath), "download_btn").click();
        DialogRobot.pressEnter();
    }
}
