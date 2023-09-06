package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.tf_gua.ParentPageTF;

import java.io.FileNotFoundException;

public class Step1Page extends ParentPageTF {
    @FindBy(xpath = "//*[@id='gear']")
    private WebElement spinWaite;

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

    public Step1Page(WebDriver webDriver) throws FileNotFoundException {
        super(webDriver);
    }


    public Step1Page openStep1Page() {
      //  String url = "https://loans-dmz.dev.apps.testdmz-avalaunch.aval/gua-tender";
        openPageTF();
        return this;
    }

    public Step1Page checkIsStep1Visible() {
        checkElementDisplayed(step1, "Step1");
        return this;
    }

    public Step1Page checkIsInputHrefVisible() {
        checkElementDisplayed(inputHref, "InputHref");
        return this;
    }

    public Step1Page enterTextIntoInputIdProzorro(String idProzorro) {
        enterTextIntoInput(inputHref, idProzorro);
        logger.info("inputHref");
        return this;
    }


    public Step1Page selectTextInDropDownPH(String purchaseCN, String elementName) { // метод для вибору значення з дропдауну по id
        selectTextInDropDownByUI(dropDownPur, purchaseCN, elementName);
        return this;
    }

    public Step1Page clickOnradioButtonEasy() {
        clickOnElement(radioButtonEasy, "RadioButtonEasy");
        return this;
    }

    public void clickOnButtonNext() {clickOnElement(buttonNext, "ButtonNext");
    }

    public void checkIsStep1NotVisible() {
        checkElementNotDisplayed(step1, "Step1");
    }
}