package pages;

import Utils.StaticMap;
import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IComboBox;
import aquality.selenium.elements.interfaces.IElementFactory;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class ResearchPage extends Form {
    private IElementFactory factory = AqualityServices.getElementFactory();

    private static final String page_indicator_xpath = "//*[text() = 'Research cars']";
    private final String make_select_xpath = "//select[@id = 'make-select']";
    private final String model_select_xpath = "//select[@id = 'model-select']";
    private final String year_select_xpath = "//select[@id = 'year-select']";
    private final String research_btn_xpath = "//button[text() = 'Research']";
    private final String compare_models_link_xpath = "//a[text() = 'Compare models']";

    private IComboBox make_cb = factory.getComboBox(By.xpath(make_select_xpath), "make_cb");
    private IComboBox model_cb = factory.getComboBox(By.xpath(model_select_xpath), "model_cb");
    private IComboBox year_cb = factory.getComboBox(By.xpath(year_select_xpath), "year_cb");

    public ResearchPage() {
        super(By.xpath(page_indicator_xpath), "research_page");
    }
    public void randomSearch() {
        make_cb.selectByIndex(getRandomInt(1, make_cb.getValues().size()-1));
        model_cb.selectByIndex(getRandomInt(1, model_cb.getValues().size()-1));
        year_cb.selectByIndex(getRandomInt(1, year_cb.getValues().size()-1));
        saveParams();
    }
    private void saveParams() {
        StaticMap.put("make", make_cb.getSelectedText());
        StaticMap.put("model", model_cb.getSelectedText());
        StaticMap.put("year", year_cb.getSelectedText());
    }
    private int getRandomInt(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }
    public void clickResearch() {
        factory.getButton(By.xpath(research_btn_xpath), "research_btn").click();
    }
    public void goToCompare() {
        factory.getLink(By.xpath(compare_models_link_xpath), "compare_link").click();
    }

}
