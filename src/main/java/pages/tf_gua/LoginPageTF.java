package pages.tf_gua;

import io.qameta.allure.Step;
import libs.ConfigProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;

public class LoginPageTF extends ParentPageTF {

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


    public LoginPageTF(WebDriver webDriver) throws FileNotFoundException {
        super(webDriver);
    }

    public LoginPageTF loadKepTF() {
        checkIsLabelFileVisible("LoginFile");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigProvider.configProperties.TIME_FOR_DEFAULT_WAIT()));
// Знайти label за вказаним XPath
        WebElement label = webDriver.findElement(By.xpath(".//label [@for='upload']"));

// Знайти батьківський елемент label і знайти в ньому інпут для завантаження файлу
        WebElement parentElement = label.findElement(By.xpath("./.."));
        WebElement fileInput = parentElement.findElement(By.tagName("input"));
        logger.info("Send file");
        // Відправити шлях до файлу в інпут
        fileInput.sendKeys(new File(filePath).getAbsolutePath());
        return this;
    }

    @Step //хочемо бачити в репорті
    public LoginPageTF enterTextIntoInputPassword(String Password) {
        enterTextIntoInput(inputPassword, Password);
        return this;
    }

    @Step //хочемо бачити в репорті
    public LoginPageTF clickOnButtonSignIn() {
        clickOnElement(signIn, "SignIn");
        return this;
    }

    @Step //хочемо бачити в репорті
    public LoginPageTF checkIsLabelFileVisible(String elementName) {
        checkElementDisplayed(labelFile, elementName);
        return this;
    }

    @Step //хочемо бачити в репорті
    public LoginPageTF checkIsСheckBoxRobVisible() {
        checkElementDisplayed(checkBoxRob, "checkBoxRob");
        return this;
    }

    @Step //хочемо бачити в репорті
    public LoginPageTF checkIsCheckBoxRobNotVisible() {
        checkElementNotDisplayed(checkBoxRob, "checkBoxRob");// валідний логін
        return this;
    }

    @Step //хочемо бачити в репорті
    public LoginPageTF checkIsInputPasswordVisible() {
        checkElementDisplayed(inputPassword, "Password");
        return this;
    }

    public LoginPageTF checkIsInputPasswordNotVisible(String elementName) {
        checkElementNotDisplayed(inputPassword, elementName);
        return this;
    }

    @Step //хочемо бачити в репорті
    public LoginPageTF checkIsButtonSignInVisible() {
        checkElementDisplayed(signIn, "SignIn");
        return this;
    }

    public LoginPageTF checkIsButtonSignInNotVisible(String elementName) {
        checkElementNotDisplayed(signIn, elementName);
        return this;
    }

    public LoginPageTF checkIsFileLoadVisible() {
        checkElementDisplayed(isFileLoad, "LoginNameFile");
        logger.info("checkIsFileLoadVisible");
        return this;
    }

    public LoginPageTF checkSignInVisible() {
        checkElementDisplayed(signIn, "SignIn");
        return this;
    }

    //  @Step //хочемо бачити в репорті
    public LoginPageTF checkIsInvalidPasswordVisible() {// iнвалідний логін
        checkElementDisplayed(isInvalidPassword, "Ключ пошкоджено або невірний пароль.");
        return this;
    }
}