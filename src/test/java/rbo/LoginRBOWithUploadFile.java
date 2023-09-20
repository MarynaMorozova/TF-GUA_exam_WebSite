package rbo;

import baseTest.BaseTest;
import categories.SmokeTestFilter;
import io.qameta.allure.*;

import libs.Util;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.FileNotFoundException;

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
                .checkIsInputPasswordRBOVisible()
                .enterTextIntoInputPasswordRBO(PASSWORD_RBO)
                .checkSignInVisibleRBO();
        Util.waitABit(10);
        pageProvider.getLoginPageRBO().clickOnButtonSignInRBO();
        Util.waitABit(30);
        pageProvider.getLoginPageRBO().checkSignInNotVisibleRBO(); // перевірка що немає SignIn
    }

    @Test//проверка входа с не валидными данными
    @Ignore
    public void inValidLoginPassword() throws FileNotFoundException {
        pageProvider.getLoginPageRBO().openPageRBO();
        Util.waitABit(10);
        pageProvider.getLoginPageRBO().loadKepRBO()

                .checkIsFileLoadRBOVisible()
                .checkIsInputPasswordRBOVisible()
                .enterTextIntoInputPasswordRBO(PASSWORD_RBO_invalid)
                .checkSignInVisibleRBO();
        Util.waitABit(10);
        pageProvider.getLoginPageRBO().clickOnButtonSignInRBO();
        Util.waitABit(20);
        pageProvider.getLoginPageRBO().checkIsInvalidPassRBOVisible();// перевірка, що ввели не валідний пароль
    }
}