import junitparams.JUnitParamsRunner;
import libs.ConfigProvider;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static data.TestData.PASSWORD_DEFAULT;
import static data.TestData.PASSWORD_INVALID;


public class LoginWithUploadFile extends BaseTest { //extends ActionsWithElements {

//    public FileUploaderWithSelenium(WebDriver webDriver) {
//        super(webDriver);
//    }

    @Test
    public void validLogin() {
        String url = "https://loans-dmz.dev.apps.testdmz-avalaunch.aval/gua-tender"; // Замініть на URL свого веб-сайту
        String filePath = "C://workSpaсe//key-6.pfx"; // Шлях до вашого файлу
        pageProvider.getLoginPage().openLoginPage(url);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigProvider.configProperties.TIME_FOR_DEFAULT_WAIT()));//замість 5 секунд


        //    webDriver.manage().timeouts().implicitlyWait(Duration,TimeUnit.SECONDS);//замість 30 секунд
        pageProvider.getLoginPage().checkIsLabelFileVisible("LoginFile");

        // Знайти label за вказаним XPath
        WebElement label = webDriver.findElement(By.xpath(".//label [@for='upload']"));

//        JavascriptExecutor jsExecutor = (JavascriptExecutor) webDriver;
//        String script = "arguments[0].setAttribute('type', 'file');";
//        jsExecutor.executeScript(script, label);

// Знайти батьківський елемент label і знайти в ньому інпут для завантаження файлу
        WebElement parentElement = label.findElement(By.xpath("./.."));
        WebElement fileInput = parentElement.findElement(By.tagName("input"));

        logger.info("Send file");
        // Відправити шлях до файлу в інпут
        fileInput.sendKeys(new File(filePath).getAbsolutePath());
        //  webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        pageProvider.getLoginPage().checkIsFileLoadVisible("LoginNameFile");
//        WebDriverWait webDriverWait10 = new WebDriverWait(webDriver, 15);
//        webDriverWait10.until(ExpectedConditions.elementToBeClickable(webElement));
        webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        pageProvider.getLoginPage().checkIsInputPasswordVisible("Password");
        pageProvider.getLoginPage().enterTextIntoInputPassword(PASSWORD_DEFAULT);
        pageProvider.getLoginPage().checkSignInVisible("SignIn");

        //webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        pageProvider.getLoginPage().clickOnButtonSignIn("SignIn");
        pageProvider.getLoginPage().checkIsCheckBoxRobNotVisible();
        //webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        pageProvider.getLoginPage().checkIsStep1Visible("Step1");
    }
        @Test //проверка входа с невалидными данными
        //@Ignore
 public void inValidLoginPassword() {
    String url = "https://loans-dmz.dev.apps.testdmz-avalaunch.aval/gua-tender"; // Замініть на URL свого веб-сайту
    String filePath = "C://workSpaсe//key-6.pfx"; // Шлях до вашого файлу
        pageProvider.getLoginPage().openLoginPage(url);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigProvider.configProperties.TIME_FOR_DEFAULT_WAIT()));//замість 5 секунд


    //    webDriver.manage().timeouts().implicitlyWait(Duration,TimeUnit.SECONDS);//замість 30 секунд
        pageProvider.getLoginPage().checkIsLabelFileVisible("LoginFile");

    // Знайти label за вказаним XPath
    WebElement label = webDriver.findElement(By.xpath(".//label [@for='upload']"));

//        JavascriptExecutor jsExecutor = (JavascriptExecutor) webDriver;
//        String script = "arguments[0].setAttribute('type', 'file');";
//        jsExecutor.executeScript(script, label);

    // Знайти батьківський елемент label і знайти в ньому інпут для завантаження файлу
    WebElement parentElement = label.findElement(By.xpath("./.."));
    WebElement fileInput = parentElement.findElement(By.tagName("input"));

        logger.info("Send file");
    // Відправити шлях до файлу в інпут
        fileInput.sendKeys(new File(filePath).getAbsolutePath());
    //  webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        pageProvider.getLoginPage().checkIsFileLoadVisible("LoginNameFile");
//        WebDriverWait webDriverWait10 = new WebDriverWait(webDriver, 15);
//        webDriverWait10.until(ExpectedConditions.elementToBeClickable(webElement));
        webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        pageProvider.getLoginPage().checkIsInputPasswordVisible("Password");
        pageProvider.getLoginPage().enterTextIntoInputPassword(PASSWORD_INVALID);
        pageProvider.getLoginPage().checkSignInVisible("SignIn");

    //webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        pageProvider.getLoginPage().clickOnButtonSignIn("SignIn");
        pageProvider.getLoginPage().checkIsInvalidPasswordVisible("Ключ пошкоджено або невірний пароль.");
    }
}
