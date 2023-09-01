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

//    public void openLoginPage(String url) {
//        openPage(url);
//    }

    public LoginPage_RBO(WebDriver webDriver) throws FileNotFoundException {
        super(webDriver);
    }
    public void checkIsInputPasswordRBOVisible(String elementName) {
        checkElementDisplayed(isPasswordRBO, elementName);
    }

    public LoginPage_RBO loadKepRBO() {
        checkIsLabelFileRBOVisible("LabelFile");

        // Знайти label за вказаним XPath
        WebElement label = webDriver.findElement(By.xpath(".//label [@class='fileField formControl']"));

// Знайти батьківський елемент label і знайти в ньому інпут для завантаження файлу
        WebElement parentElement = label.findElement(By.xpath("./.."));
        WebElement fileInput = parentElement.findElement(By.tagName("input"));

        logger.info("Send file");
        // Відправити шлях до файлу в інпут
        fileInput.sendKeys(new File(KepRbo.toString()).getAbsolutePath());
        return this;
    }

    public void checkIsFileLoadRBOVisible() {
        checkElementDisplayed(isLabelFileLogin, "LabelFileLogin");
    }

    public void checkIsLabelFileRBOVisible(String elementName) {
        checkElementDisplayed(LabelFileLogin, elementName);
    }

    public LoginPage_RBO enterTextIntoInputPasswordRBO(String passwordRbo) {
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