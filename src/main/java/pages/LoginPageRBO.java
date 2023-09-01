package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageRBO extends ParentPage {

    @FindBy(xpath = ".//label [@class='fileField formControl']")
    private WebElement LabelFileLogin;
    @FindBy(xpath = "//span [@class = 'keyFilename']")
    private WebElement isLabelFileLogin;

    @FindBy(xpath = "//input [@id = \"pwd_id\"]")
    private WebElement isPasswordRBO;

    @FindBy(xpath = ".//button [@CLASS='button loginSignatureBehavior next actionDefault']")
    private WebElement signInRbo;

    public LoginPageRBO(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//*[contains (text(),'Невірний ключ або пароль')]")
    private WebElement isInvalidPasswordRBO;

    public void openLoginPage(String url) {
        openPage(url);
    }

    public void checkIsInputPasswordRBOVisible(String elementName) {
        checkElementDisplayed(isPasswordRBO, elementName);
    }

    public void checkIsFileLoadRBOVisible() {
        checkElementDisplayed(isLabelFileLogin, "LabelFileLogin");
    }

    public void checkIsLabelFileRBOVisible(String elementName) {
        checkElementDisplayed(LabelFileLogin, elementName);
    }

    public LoginPageRBO enterTextIntoInputPasswordRBO(String passwordRbo) {
        enterTextIntoInput(isPasswordRBO, passwordRbo);
        return this;
    }

    public void checkSignInVisibleRBO(String elementName) {
        checkElementDisplayed(signInRbo, elementName);
    }

    public void clickOnButtonSignInRBO(String elementName) {
        clickOnElement(signInRbo, elementName);
    }

    public void checkIsInvalidPassRBOVisible(String elementName) {
        checkElementDisplayed(isInvalidPasswordRBO, elementName);
    }
}