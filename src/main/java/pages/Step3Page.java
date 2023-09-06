package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.tf_gua.ParentPageTF;

import java.io.FileNotFoundException;

public class Step3Page extends ParentPageTF {


    @FindBy(xpath = "//div [text()= 'Крок 3 з 5']")
    private WebElement step3;

    @FindBy(xpath = ".//input[@tabindex=1]")
    private WebElement dateTerminDii;

    @FindBy(xpath = ".//input[@tabindex=2]")
    private WebElement datePrPropoz;

    @FindBy(xpath = ".//input[@tabindex=3]")
    private WebElement sumGarant;

    @FindBy(xpath = "//span [text()='Оберіть доступний рахунок']") // закритий дропдаун
    private WebElement dropDownSelectAccount;

        @FindBy(xpath = ".//textarea[@tabindex=5]")
    private WebElement textarea5;

    @FindBy(xpath = ".//textarea[@tabindex=6]")
    private WebElement textarea6;

    @FindBy(xpath = ".//button[@tabindex=7]")
    private WebElement buttonNextTo4;

    public Step3Page(WebDriver webDriver) throws FileNotFoundException {
        super(webDriver);
    } //конструктор

    public void openStep3Page() {
        String url = "https://loans-dmz.dev.apps.testdmz-avalaunch.aval/gua-tender";
        openPageTF();
    }

    public Step3Page enterTextIntoInputDateTerminDii(String element) {
        enterTextIntoInput(dateTerminDii, element);
        return this;
    }

    public Step3Page enterTextIntoInputDatePrPropoz(String element) {
        enterTextIntoInput(datePrPropoz, element);
        return this;
    }
    public Step3Page enterTextIntoInputSumGarant(String element) {
        enterTextIntoInput(sumGarant, element);
        return this;
    }

    public Step3Page selectTextInDropDownSelectAccount(String elementAccount) { // метод для вибору значення з дропдауну по id
       // String elementAccount="UA613808050000000026005728147";// тестові дані передавати стрінгой в тесті
        selectTextInDropDownByUI(dropDownSelectAccount, elementAccount, "ElementAccount");
        return this;
    }

    public Step3Page enterTextIntoInputTextarea5(String inputTextarea5) {
        enterTextIntoInput(textarea5, inputTextarea5);// тестові дані передавати стрінгой
        return this;
    }
    public Step3Page enterTextIntoInputTextarea6(String inputTextarea6) {
        enterTextIntoInput(textarea6, inputTextarea6);// тестові дані передавати стрінгой
        return this;
    }

    public void clickOnButtonNext4() {
        clickOnElement(buttonNextTo4, "ButtonNextOnStep4");
    }
    public Step3Page checkIsStep3Visible() {
        checkElementDisplayed(step3, "Step3");
        return this;
    }

    public Step3Page checkIsStep3NotVisible() {
        checkElementNotDisplayed(step3, "Step3");//перевірка, що ми вийшли з Step3
        return this;
    }
}