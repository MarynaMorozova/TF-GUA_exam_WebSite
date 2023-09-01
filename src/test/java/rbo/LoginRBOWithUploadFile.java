package rbo;

import baseTest.BaseTest;
import categories.SmokeTestFilter;
import io.qameta.allure.*;
import libs.ConfigProvider;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static data.TestData.PASSWORD_RBO;
import static data.TestData.PASSWORD_RBO_invalid;
@Epic("Allure examples")
@Feature("Junit 4 support")


//@RunWith(JUnitParamsRunner.class) //позволяет использовать параметризацию
//@Category(SmokeTestFilter.class)
public class LoginRBOWithUploadFile extends BaseTest {
    @Description("Some detailed test description")
    @Link("https://example.org")
    @Link(name = "allure", type = "mylink")
    @Issue("123")
    @Issue("432")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Base support for bdd annotations")

    @Test //проверка входа с валидными данными
    //@Ignore
    @Category(SmokeTestFilter.class)
    public void validLogin() {
        String url = "https://rbo-dev.avrb.com.ua/ibank/home?0"; // Замініть на URL свого веб-сайту
        String filePath = "C://workSpaсe//КОФІТОН_37120506_директор.dat"; // Шлях до вашого файлу
        pageProvider.getLoginPageRBO().openLoginPage(url);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigProvider.configProperties.TIME_FOR_DEFAULT_WAIT()));//замість 5 секунд


        //    webDriver.manage().timeouts().implicitlyWait(Duration,TimeUnit.SECONDS);//замість 30 секунд
        pageProvider.getLoginPageRBO().checkIsLabelFileRBOVisible("LabelFile");

        // Знайти label за вказаним XPath
        WebElement label = webDriver.findElement(By.xpath(".//label [@class='fileField formControl']"));

// Знайти батьківський елемент label і знайти в ньому інпут для завантаження файлу
        WebElement parentElement = label.findElement(By.xpath("./.."));
        WebElement fileInput = parentElement.findElement(By.tagName("input"));

        logger.info("Send file");
        // Відправити шлях до файлу в інпут
        fileInput.sendKeys(new File(filePath).getAbsolutePath());
        //  webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        pageProvider.getLoginPageRBO().checkIsFileLoadRBOVisible();

  //      webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        pageProvider.getLoginPageRBO().checkIsInputPasswordRBOVisible("Password");
        pageProvider.getLoginPageRBO().enterTextIntoInputPasswordRBO(PASSWORD_RBO);
        pageProvider.getLoginPageRBO().checkSignInVisibleRBO("SignIn");

  //    webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        pageProvider.getLoginPageRBO().clickOnButtonSignInRBO("SignIn");
        //додати перевірка що немає сайнина
    }

  @Test//проверка входа с не валидными данными
  //@Ignore
    public void inValidLoginPassword() {
      String url = "https://rbo-dev.avrb.com.ua/ibank/home?0"; // Замініть на URL свого веб-сайту
      String filePath = "C://workSpaсe//КОФІТОН_37120506_директор.dat"; // Шлях до вашого файлу
      pageProvider.getLoginPageRBO().openLoginPage(url);
      webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigProvider.configProperties.TIME_FOR_DEFAULT_WAIT()));//замість 5 секунд

      pageProvider.getLoginPageRBO().checkIsLabelFileRBOVisible("LabelFile");

      // Знайти label за вказаним XPath
      WebElement label = webDriver.findElement(By.xpath(".//label [@class='fileField formControl']"));

// Знайти батьківський елемент label і знайти в ньому інпут для завантаження файлу
      WebElement parentElement = label.findElement(By.xpath("./.."));
      WebElement fileInput = parentElement.findElement(By.tagName("input"));

      logger.info("Send file");
      // Відправити шлях до файлу в інпут
      fileInput.sendKeys(new File(filePath).getAbsolutePath());
      //  webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
      pageProvider.getLoginPageRBO().checkIsFileLoadRBOVisible();

     // webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
      pageProvider.getLoginPageRBO().checkIsInputPasswordRBOVisible("Password");
      pageProvider.getLoginPageRBO().enterTextIntoInputPasswordRBO(PASSWORD_RBO_invalid)
              .checkSignInVisibleRBO("SignIn");

      //webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
      pageProvider.getLoginPageRBO().clickOnButtonSignInRBO("SignIn");
      pageProvider.getLoginPageRBO().checkIsInvalidPassRBOVisible("IsInvalidPassword");
  }
}
