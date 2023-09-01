package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Step2Page extends ParentPage {

    @FindBy(xpath = "//div [text()= 'Крок 2 з 5']")
    private WebElement step2;



    @FindBy(xpath = ".//input[@placeholder='Введіть повне найменування']")
    private WebElement purchName;

    @FindBy(xpath = ".//input[@placeholder='Введіть код ЄДРПОУ']")
    private WebElement edrpou;

    @FindBy(xpath = ".//input[@placeholder='Введіть адресу']")
    private WebElement adresaPurch;

    @FindBy(xpath = ".//span[@class='mat-select-placeholder mat-select-min-line ng-tns-c66-1 ng-star-inserted']")
    private WebElement categoryPurch;

    @FindBy(xpath = ".//button[@class='mat-focus-indicator next-button mat-button mat-button-base']")
    private WebElement buttonNext3;

    public Step2Page(WebDriver webDriver) {
        super(webDriver);
    } //конструктор

    public void openStep2Page() {
        String url = "https://loans-dmz.dev.apps.testdmz-avalaunch.aval/gua-tender";
        openPage(url);
    }

    public void checkIsStep2Visible(String elementName) {
        checkElementDisplayed(step2, elementName);
    }

    public Step2Page enterTextIntoInputPurchName() {
        enterTextIntoInput(purchName, "ТОВ \" БЕЙЛ ТРЕЙД\"");
        return this;
    }

    public Step2Page enterTextIntoInputEdrpou() {
        enterTextIntoInput(edrpou, "43646107");
        return this;
    }

    public Step2Page enterTextIntoInputAdresaPurch() {
        enterTextIntoInput(adresaPurch, "Фастов");
        return this;
    }
    public Step2Page selectTextInDropDownCategoryPrurch() { // метод для вибору значення з дропдауну по id
        String elementCategoryPurch="Органи соціального страхування";
        selectTextInDropDownByUI(categoryPurch, elementCategoryPurch, "ElementCategoryPurch");
        return this;
    }
    public Step3Page clickOnButtonNext3(String elementName) {
        clickOnElement(buttonNext3,elementName);
        return new Step3Page(webDriver);
    }

}