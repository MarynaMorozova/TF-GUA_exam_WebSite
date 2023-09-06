package pages.rbo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.FileNotFoundException;

public class LoginPage_RBO extends ParentPageRBO {

    @FindBy(xpath = ".//label [@class='fileField formControl']")
    private WebElement LabelFileLogin;
    @FindBy(xpath = "//span [@class = 'keyFilename']")
    private WebElement isLabelFileLogin;

    @FindBy(xpath = "//input [@id = \"pwd_id\"]")
    private WebElement isPasswordRBO;

    @FindBy(xpath = ".//button [@CLASS='button loginSignatureBehavior next actionDefault']")
    private WebElement signInRbo;

    @FindBy(xpath = "//*[contains (text(),'Невірний ключ або пароль')]")
    private WebElement isInvalidPasswordRBO;


    public LoginPage_RBO(WebDriver webDriver) throws FileNotFoundException {
        super(webDriver);
    }

    public LoginPage_RBO checkIsInputPasswordRBOVisible() {
        checkElementDisplayed(isPasswordRBO, "Password");
        return this;
    }

    public LoginPage_RBO loadKepRBO() {
        checkIsLabelFileRBOVisible("LabelFile");

        WebElement fileInput = webDriver.findElement(By.xpath(".//input [@class='fileField formControl fileField-hidden']"));

        logger.info("Send file");
        // Відправити шлях до файлу в інпут
        fileInput.sendKeys(new File(KepRbo).getAbsolutePath());
        return this;
    }

    public LoginPage_RBO checkIsFileLoadRBOVisible() {
        checkElementDisplayed(isLabelFileLogin, "LabelFileLogin");
        return this;
    }

    public LoginPage_RBO checkIsLabelFileRBOVisible(String elementName) {
        checkElementDisplayed(LabelFileLogin, elementName);
        return this;
    }

    public LoginPage_RBO enterTextIntoInputPasswordRBO(String passwordRbo) {
        enterTextIntoInput(isPasswordRBO, passwordRbo);
        return this;
    }

    public LoginPage_RBO checkSignInVisibleRBO() {
        checkElementDisplayed(signInRbo, "SignIn");
        return this;
    }

    public LoginPage_RBO clickOnButtonSignInRBO() {
        clickOnElement(signInRbo, "SignIn");
        return this;
    }

    public LoginPage_RBO checkIsInvalidPassRBOVisible() {
        checkElementDisplayed(isInvalidPasswordRBO, "IsInvalidPassword");
        return this;
    }
    public LoginPage_RBO checkSignInNotVisibleRBO() {
        checkElementNotDisplayed(signInRbo, "SignIn");
        return this;
    }
}