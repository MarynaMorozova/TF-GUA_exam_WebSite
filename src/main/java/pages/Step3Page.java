package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Step3Page extends ParentPage {


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

    public Step3Page(WebDriver webDriver) {
        super(webDriver);
    } //конструктор

    public void openStep3Page() {
        String url = "https://loans-dmz.dev.apps.testdmz-avalaunch.aval/gua-tender";
        openPage(url);
    }

    public Step3Page enterTextIntoInputDateTerminDii() {
        enterTextIntoInput(dateTerminDii, "25.03.2024");
        return this;
    }

    public Step3Page enterTextIntoInputDatePrPropoz() {
        enterTextIntoInput(datePrPropoz, "26.09.2023");
        return this;
    }
    public Step3Page enterTextIntoInputSumGarant() {
        enterTextIntoInput(sumGarant, "20000");
        return this;
    }

    public Step3Page selectTextInDropDownSelectAccount() { // метод для вибору значення з дропдауну по id
        String elementAccount="UA613808050000000026005728147";
        selectTextInDropDownByUI(dropDownSelectAccount, elementAccount, "ElementAccount");
        return this;
    }

    public Step3Page enterTextIntoInputTextarea5() {
        enterTextIntoInput(textarea5, "11");
        return this;
    }
    public Step3Page enterTextIntoInputTextarea6() {
        enterTextIntoInput(textarea6, "22");
        return this;
    }

    public Step3Page clickOnButtonNext4(String elementName) {
        clickOnElement(buttonNextTo4, elementName);
        return this;
    }
}