import libs.ConfigProvider;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static data.TestData.*;

public class LoginRBOWithUploadFile extends BaseTest {

    @Test
    public void validLogin() {

        String url = "https://rbo-dev.avrb.com.ua/ibank/home?0"; // Замініть на URL свого веб-сайту
        String filePath = "C://workSpaсe//КОФІТОН_37120506_директор.dat"; // Шлях до вашого файлу
        pageProvider.getLoginPageRBO().openLoginPage(url);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigProvider.configProperties.TIME_FOR_DEFAULT_WAIT()));//замість 5 секунд


        //    webDriver.manage().timeouts().implicitlyWait(Duration,TimeUnit.SECONDS);//замість 30 секунд
        pageProvider.getLoginPageRBO().checkIsLabelFileRBOVisible("LabelFile");

        // Знайти label за вказаним XPath
        WebElement label = webDriver.findElement(By.xpath(".//label [@class='fileField formControl']"));

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
        pageProvider.getLoginPageRBO().checkIsFileLoadRBOVisible();
//        WebDriverWait webDriverWait10 = new WebDriverWait(webDriver, 15);
//        webDriverWait10.until(ExpectedConditions.elementToBeClickable(webElement));
        webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        pageProvider.getLoginPageRBO().checkIsInputPasswordRBOVisible("Password");
        pageProvider.getLoginPageRBO().enterTextIntoInputPasswordRBO(PASSWORD_RBO);
        pageProvider.getLoginPageRBO().checkSignInVisibleRBO("SignIn");

        //webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        pageProvider.getLoginPageRBO().clickOnButtonSignInRBO("SignIn");

    }
}
  /*  @Test
    public void inValidLoginPassword() {

//        String url = "https://loans-dmz.dev.apps.testdmz-avalaunch.aval/gua-tender"; // Замініть на URL свого веб-сайту
        String filePath = "C://workSpaсe//key-6.pfx"; // Шлях до вашого файлу
        pageProvider.getLoginPage().openLoginPage();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigProvider.configProperties.TIME_FOR_DEFAULT_WAIT()));//замість 5 секунд


        //    webDriver.manage().timeouts().implicitlyWait(Duration,TimeUnit.SECONDS);//замість 30 секунд
        pageProvider.getLoginPage().checkIsLabelFileVisible();

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
        pageProvider.getLoginPage().checkIsFileLoadVisible();
//        WebDriverWait webDriverWait10 = new WebDriverWait(webDriver, 15);
//        webDriverWait10.until(ExpectedConditions.elementToBeClickable(webElement));
//        webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//        pageProvider.getLoginPage().checkIsInputPasswordVisible();
//        pageProvider.getLoginPage().enterTextIntoInputPassword(PASSWORD_INVALID);
//        pageProvider.getLoginPage().checkSignInVisible();
//
//        //webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//        pageProvider.getLoginPage().clickOnButtonSignIn();
//        pageProvider.getLoginPage().checkIsInvalidPasswordVisible();
//
//    }
//} */
