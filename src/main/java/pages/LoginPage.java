package pages;

import data.TestData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.Logger;

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



    //це як варіант webDriver.findElement(By.xpath("//div[@class='alert alert-danger small liveValidateMessage liveValidateMessage--visible']"));
//    @FindBy(xpath = "@FindBy(xpath = \"//div[@class='alert alert-danger text-center' and text() = 'Invalid username / pasword']\")\n" +
//            "    private WebElement messageInvalidUsernameAndPassword;")
//    private List<WebElement> alertDanger;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

//    @Override
//    protected String getRelativeUrl() {
//        return "/";
//    }
    public void openLoginPage() {
        openPage(BASE_URL);
     //   checkUrl();
    }

    public void enterTextIntoInputPassword(String Password) {
        enterTextIntoInput(inputPassword, Password);
        logger.info("Password input");
    }

    public void clickOnButtonSignIn() {
        clickOnElement(signIn);
    }

    public void loginWithValidCreds() {
        openLoginPage();
//        enterTextIntoInputUserName(TestData.LOGIN_DEFAULT);
        enterTextIntoInputPassword(TestData.PASSWORD_DEFAULT);
        clickOnButtonSignIn();
    }
    public void checkIsLabelFileVisible() {
        checkElementDisplayed(labelFile);
    }


    public void checkIsСheckBoxRobVisible() {
        checkElementDisplayed(checkBoxRob);
    }

    public void checkIsCheckBoxRobNotVisible() {
        checkElementNotDisplayed(checkBoxRob);// валідний логін
    }

    public void checkIsInputPasswordVisible() {
        checkElementDisplayed(inputPassword);
    }

    public void checkIsInputPasswordNotVisible() {
        checkElementNotDisplayed(inputPassword);
    }

    public void checkIsButtonSignInVisible() {
        checkElementDisplayed(signIn);
    }

    public void checkIsButtonSignInNotVisible() {
        checkElementNotDisplayed(signIn);
    }

    public void checkIsFileLoadVisible() {
        checkElementDisplayed(isFileLoad);
        logger.info("checkIsFileLoadVisible");
    }

    public void checkSignInVisible() {
        checkElementDisplayed(signIn);
        logger.info("signInVisible");
    }

    public void checkIsInvalidPasswordVisible() {
        checkElementDisplayed(isInvalidPassword);
    }


//    public LoginPage enterTextIntoRegistrationUserNameField(String userName) {
//        enterTextIntoInput(inputUserNameRegistration, userName);
//        return this;
//    }
//    public LoginPage enterTextIntoRegistrationEmailField(String email) {
//        enterTextIntoInput(inputUserEmailRegistration, email);
//        return this;
//    }
//    public LoginPage enterTextIntoRegistrationPasswordField(String password) {
//        enterTextIntoInput(inputUserPasswordRegistration, password);
//        return this;
//    }
//
//    public LoginPage checkErrorsMessages(String expectedMessages) {
//        //error1;error2;->[error1;error2]
//        String [] errors = expectedMessages.split(";");
//        //wait util number or error will be expected
//        webDriverWait10.until(
//                ExpectedConditions.numberOfElementsToBe(
//                        By.xpath(listErrorsMessagesLocator), errors.length));
//        Util.waitABit(1);//wait for visibility of all messages
//        Assert.assertEquals("Number of elements", errors.length, getListOfErrors().size());
//
//        ArrayList atualTextFromErrors = new ArrayList();
//        for (WebElement element : getListOfErrors()) {
//            atualTextFromErrors.add(element.getText());
//        }
//
//        SoftAssertions softAssertions = new SoftAssertions();
//        for (int i = 0; i < errors.length; i++) {
//            softAssertions.assertThat(errors[i])//візьми очикуваний результат та виконай дію
//                    .as("Error " + errors[i] + " was not found")//message if assertion is failed
//                    //      .isEqualToIgnoringCase(atualTextFromErrors.get(i).toString());//порівняй очікуваний результат з фактичним
//                    .isIn(atualTextFromErrors.get(i).toString());//порівняй очікуваний результат з фактичним, порядок не важливий
//        }
//        softAssertions.assertAll();//check all assertion, виведе, що не співпало
//
//        return this;
//    }
//    private List<WebElement> getListOfErrors() {
//        return webDriver.findElements(By.xpath(listErrorsMessagesLocator));
//    }
//    public LoginPage checkErrorMessageLogin(String expectedErrorMessageLogin) {
//        // Очикування, поки повідомлення про помилку буде видимим
//        webDriverWait10.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(errorMessageLogin)));
//        Util.waitABit(1);
//
//        // Перевірте, що кількість повідомлень про помилку = 1
//        Assert.assertEquals("Number of error messages", 1, getErrorLogin().size());
//
//        // Отримайте фактичний текст повідомлення про помилку
//        String actualErrorMessage = getErrorLogin().get(0).getText();
//
//        // Порівняйте очікувані та фактичні повідомлення
//        Assert.assertEquals("Error message", expectedErrorMessageLogin, actualErrorMessage);
//
//        return this;
//    }
//    private List<WebElement> getErrorLogin() {
//        return webDriver.findElements(By.xpath(errorMessageLogin));
//    }
}

