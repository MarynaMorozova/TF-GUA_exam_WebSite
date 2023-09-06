package rbo;

import baseTest.BaseTest;
import categories.SmokeTestFilter;
import io.qameta.allure.*;

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

import static data.TestData.PASSWORD_RBO;
import static data.TestData.PASSWORD_RBO_invalid;

@Epic("Allure examples")
@Feature("Junit 4 support")

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
    public void validLogin() throws FileNotFoundException {
        pageProvider.getLoginPageRBO().openPageRBO();
        Util.waitABit(10);
        pageProvider.getLoginPageRBO().loadKepRBO()
                .checkIsFileLoadRBOVisible()

                //      webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                .checkIsInputPasswordRBOVisible()
                .enterTextIntoInputPasswordRBO(PASSWORD_RBO)
                .checkSignInVisibleRBO();

        //    webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        pageProvider.getLoginPageRBO().clickOnButtonSignInRBO();
        Util.waitABit(10);
        pageProvider.getLoginPageRBO().checkSignInNotVisibleRBO(); // перевірка що немає сайнина
    }

    @Test//проверка входа с не валидными данными
    //@Ignore
    public void inValidLoginPassword() throws FileNotFoundException {
        pageProvider.getLoginPageRBO().openPageRBO();
        Util.waitABit(10);
        pageProvider.getLoginPageRBO().loadKepRBO()

                .checkIsFileLoadRBOVisible()
                //      webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                .checkIsInputPasswordRBOVisible()
                .enterTextIntoInputPasswordRBO(PASSWORD_RBO_invalid)
                .checkSignInVisibleRBO();

        //webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        pageProvider.getLoginPageRBO().clickOnButtonSignInRBO();
        Util.waitABit(10);
        pageProvider.getLoginPageRBO().checkIsInvalidPassRBOVisible();// перевірка, що ввели не валідний пароль
    }
}
