package loginTFGUA;

import baseTest.BaseTest;
import categories.SmokeTestFilter;
import io.qameta.allure.*;
import junitparams.Parameters;
import libs.ConfigProvider;
import libs.Util;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static data.TestData.PASSWORD_DEFAULT;
import static data.TestData.PASSWORD_INVALID;

@Epic("Allure examples")
@Feature("Junit 4 support")


//@Category(SmokeTestFilter.class)
public class LoginWithUploadFile extends BaseTest {

    @Test //проверка входа с валидными данными
    //   @Step
//    //@Ignore
    @Category(SmokeTestFilter.class)
    @Parameters(method = "parametersForCheckValidLoginPassword") //параметризация
    public void validLoginTF() throws FileNotFoundException {
        pageProvider.getLoginPageTF().openPageTF();
        Util.waitABit(40);
        pageProvider.getLoginPageTF().loadKepTF()
                .checkIsFileLoadVisible();
//        WebDriverWait webDriverWait10 = new WebDriverWait(webDriver, 15);
//        webDriverWait10.until(ExpectedConditions.elementToBeClickable(webElement));
        webDriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        pageProvider.getLoginPageTF().checkIsInputPasswordVisible()
                .enterTextIntoInputPassword(PASSWORD_DEFAULT)
                .checkSignInVisible();
        pageProvider.getLoginPageTF().clickOnButtonSignIn()
                .checkIsCheckBoxRobNotVisible();
    }

    @Test //проверка входа с не валидными данными
    @Ignore
    @Category(SmokeTestFilter.class)
    // @Parameters(method = "parametersForCheckInvalidLoginPassword") //параметризация
    public void inValidLoginPassword() throws FileNotFoundException {
        pageProvider.getLoginPageTF().openPageTF();
        Util.waitABit(10);
        pageProvider.getLoginPageTF().loadKepTF()
                .checkIsFileLoadVisible();
//        WebDriverWait webDriverWait10 = new WebDriverWait(webDriver, 15);
//        webDriverWait10.until(ExpectedConditions.elementToBeClickable(webElement));
 //       webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Util.waitABit(10);
        pageProvider.getLoginPageTF().checkIsInputPasswordVisible()
                .enterTextIntoInputPassword(PASSWORD_INVALID)
                .checkSignInVisible()
                .clickOnButtonSignIn();
        Util.waitABit(10);
        pageProvider.getLoginPageTF().checkIsInvalidPasswordVisible();
    }
}
