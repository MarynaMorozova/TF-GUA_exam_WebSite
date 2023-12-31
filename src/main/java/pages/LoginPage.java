package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends ParentPage {

    @FindBy(xpath = ".//label [@for='upload']")
    private WebElement labelFile;

    @FindBy(xpath = ".//input [@type='password']")
    private WebElement inputPassword;

    @FindBy(xpath = ".//span [@class='sec-button-text']")
    private WebElement signIn;

    @FindBy(xpath = ".//div [@class ='recaptcha-checkbox-border']")
    private WebElement checkBoxRob;
    @FindBy(xpath = ".//div [@class ='input-view text ng-star-inserted']")
    private WebElement isFileLoad;

    @FindBy(xpath = "//div [@class=\"tender-field-error ng-star-inserted\"]")
    private WebElement isInvalidPassword;

    @FindBy(xpath = "//div [text()= 'Крок 1 з 5']") // пошукати параметризований локатор 1 в стрінгу (як в пості)
    private WebElement step1;

    @FindBy(xpath = ".//label [@class='fileField formControl']")
    private WebElement LabelFileLogin;

    //це як варіант webDriver.findElement(By.xpath("//div[@class='alert alert-danger small liveValidateMessage liveValidateMessage--visible']"));
//    @FindBy(xpath = "@FindBy(xpath = \"//div[@class='alert alert-danger text-center' and text() = 'Invalid username / pasword']\")\n" +
//            "    private WebElement messageInvalidUsernameAndPassword;")
//    private List<WebElement> alertDanger;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }
    @Step //хочемо бачити в репорті
    public void openLoginPage(String url) {
        openPage(url);
    }

    @Step //хочемо бачити в репорті

    public void enterTextIntoInputPassword(String Password) {
        enterTextIntoInput(inputPassword, Password);
    }

    @Step //хочемо бачити в репорті
    public void clickOnButtonSignIn(String elementName) {
        clickOnElement(signIn, elementName);
    }

    @Step //хочемо бачити в репорті
    public void checkIsLabelFileVisible(String elementName) {
        checkElementDisplayed(labelFile, elementName);
    }

    @Step //хочемо бачити в репорті
    public void checkIsСheckBoxRobVisible() {
        checkElementDisplayed(checkBoxRob, "checkBoxRob");
    }

    @Step //хочемо бачити в репорті
    public void checkIsCheckBoxRobNotVisible() {
        checkElementNotDisplayed(checkBoxRob, "checkBoxRob");// валідний логін
    }
    @Step //хочемо бачити в репорті
    public void checkIsInputPasswordVisible(String elementName) {
        checkElementDisplayed(inputPassword, elementName);
    }

    public void checkIsInputPasswordNotVisible(String elementName) {
        checkElementNotDisplayed(inputPassword, elementName);
    }
    @Step //хочемо бачити в репорті
    public void checkIsButtonSignInVisible() {
        checkElementDisplayed(signIn, "SignIn");
    }

    public void checkIsButtonSignInNotVisible(String elementName) {
        checkElementNotDisplayed(signIn, elementName);
    }

    public void checkIsFileLoadVisible(String elementName) {
        checkElementDisplayed(isFileLoad, elementName);
        logger.info("checkIsFileLoadVisible");
    }

    public void checkSignInVisible(String elementName) {
        checkElementDisplayed(signIn, elementName);
    }
    @Step //хочемо бачити в репорті
    public void checkIsInvalidPasswordVisible(String elementName) {checkElementDisplayed(isInvalidPassword, elementName);}// iнвалідний логін

}