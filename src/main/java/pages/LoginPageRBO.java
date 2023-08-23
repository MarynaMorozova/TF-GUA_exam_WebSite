package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageRBO extends ParentPage {

//    @FindBy(xpath = ".//label [@for='upload']")
//    private WebElement labelFile;
//
//    @FindBy(xpath = ".//input [@type='password']")
//    private WebElement inputPassword;
//
//    @FindBy(xpath = ".//span [@class='sec-button-text']")
//    private WebElement signIn;
//
//    @FindBy(xpath = ".//div [@class ='recaptcha-checkbox-border']")
//    private WebElement checkBoxRob;
//    @FindBy(xpath = ".//div [@class ='input-view text ng-star-inserted']")
//    private WebElement isFileLoad;
//
//    @FindBy(xpath = "//div [@class=\"tender-field-error ng-star-inserted\"]")
//    private WebElement isInvalidPassword;
//
//    @FindBy(xpath = "//div [text()= 'Крок 1 з 5']")
//    private WebElement step1;

    @FindBy(xpath = ".//label [@class='fileField formControl']")
    private WebElement LabelFileLogin;
    @FindBy(xpath = "//span [@class = 'keyFilename']")
    private WebElement isLabelFileLogin;

    @FindBy(xpath ="//input [@id = \"pwd_id\"]")
    private WebElement isPasswordRBO;

    @FindBy(xpath = "//button [@CLASS='button loginSignatureBehavior next actionDefault']")
    private WebElement signInRbo;

    public LoginPageRBO(WebDriver webDriver) {
        super(webDriver);
    }

    //    @Override
//    protected String getRelativeUrl() {
//        return "/";
//    }
    public void openLoginPage(String url) {
        openPage(url);
        //   checkUrl();
    }

//    public void enterTextIntoInputPassword(String Password) {
//        enterTextIntoInput(inputPassword, Password);
// //       logger.info("Password input");
//    }
//
//    public void clickOnButtonSignIn(String elementName) {
//        clickOnElement(signIn, elementName);
//    }

//    public void loginWithValidCreds() {
//        openLoginPage(BASE_URL);
////        enterTextIntoInputUserName(TestData.LOGIN_DEFAULT);
//        enterTextIntoInputPassword(TestData.PASSWORD_DEFAULT);
//        clickOnButtonSignIn();
//    }
    public void checkIsInputPasswordRBOVisible(String elementName)
        {            checkElementDisplayed(isPasswordRBO, elementName);
        }

        public void checkIsFileLoadRBOVisible() { checkElementDisplayed(isLabelFileLogin, "LabelFileLogin");}

    public void checkIsLabelFileRBOVisible(String elementName) {
        checkElementDisplayed(LabelFileLogin, elementName);
    }

    public LoginPageRBO enterTextIntoInputPasswordRBO(String passwordRbo) {
        enterTextIntoInput(isPasswordRBO, passwordRbo);
        return this;
    }

    public void checkSignInVisibleRBO(String elementName) {
        checkElementDisplayed(signInRbo,elementName);
  //      logger.info("signInVisible");
    }

    public void clickOnButtonSignInRBO(String elementName) {
        clickOnElement(signInRbo,elementName);
    }
    }