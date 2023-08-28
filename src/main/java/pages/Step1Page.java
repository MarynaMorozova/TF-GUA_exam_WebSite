package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Step1Page extends ParentPage {

    @FindBy(xpath = "//div [text()= 'Крок 1 з 5']")
    private WebElement step1;

    @FindBy(xpath = ".//input [@class='mat-autocomplete-trigger regular ng-untouched ng-pristine ng-valid']")
    private WebElement dropDownPur;

    @FindBy(xpath = ".//input[@placeholder='UA-0000-00-00-000000-a']")
    private WebElement inputHref;

    @FindBy(xpath = ".//div [@class='subtext h9rh14 ng-star-inserted']")
    private WebElement isVisibleHref;

    @FindBy(xpath = ".//input[@id='mat-radio-2-input']")
    private WebElement radioButtonEasy;

    @FindBy(xpath = "//button [@CLASS='mat-focus-indicator next-button mat-button mat-button-base']")
    private WebElement buttonNext;

    public Step1Page(WebDriver webDriver) {
        super(webDriver);
    }


    public void openStep1Page() {
        String url = "https://loans-dmz.dev.apps.testdmz-avalaunch.aval/gua-tender";
        openPage(url);
    }

    public void checkIsStep1Visible(String elementName) {
        checkElementDisplayed(step1, elementName);
    }

    public void checkIsInputHrefVisible(String elementName) {
        checkElementDisplayed(inputHref, elementName);
    }

    public void enterTextIntoInputIdProzorro(String idProzorro) {
        enterTextIntoInput(inputHref, idProzorro);
        logger.info("inputHref");
    }


    public Step1Page selectTextInDropDownPH(String purchaseCN, String elementName) { // метод для вибору значення з дропдауну по id
        selectTextInDropDownByUI(dropDownPur, purchaseCN, elementName);
        return this;
    }

    public void clickOnradioButtonEasy(String elementName) {
        clickOnElement(radioButtonEasy, elementName);
    }

    public void clickOnButtonNext(String elementName) {
        clickOnElement(buttonNext, elementName);
    }
}