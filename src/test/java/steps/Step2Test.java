package steps;

import baseTest.BaseTest;
import categories.SmokeTestFilter;
import libs.ConfigProvider;
import libs.Util;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static data.TestData.PASSWORD_DEFAULT;


public class Step2Test extends BaseTest {
    @Before
    public void validLoginAndStep1() throws SQLException, ClassNotFoundException, FileNotFoundException {
        pageProvider.getLoginPageTF().openPageTF();
        Util.waitABit(10);
        pageProvider.getLoginPageTF().loadKepTF()
                .checkIsFileLoadVisible();
//        WebDriverWait webDriverWait10 = new WebDriverWait(webDriver, 15);
//        webDriverWait10.until(ExpectedConditions.elementToBeClickable(webElement));
        //webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        pageProvider.getLoginPageTF().checkIsInputPasswordVisible()
                .enterTextIntoInputPassword(PASSWORD_DEFAULT)
                .checkSignInVisible();

        //webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        pageProvider.getLoginPageTF().clickOnButtonSignIn()
                .checkIsCheckBoxRobNotVisible();
        logger.info("--step1--");
        pageProvider.getStep1PagePage().checkIsStep1Visible();//певірка чи ми на Step1

        pageProvider.getStep1PagePage().selectTextInDropDownPH("03111000-2", "DropDownPurh");
        pageProvider.getStep1PagePage().checkIsInputHrefVisible();

        pageProvider.getStep1PagePage().enterTextIntoInputIdProzorro("UA-2023-06-28-009743-a");
        pageProvider.getStep1PagePage().checkIsInputHrefVisible();
        pageProvider.getStep1PagePage().clickOnradioButtonEasy();

        pageProvider.getStep1PagePage().clickOnButtonNext();
    }

    @Test
    @Category(SmokeTestFilter.class)//маркуємо категорію для тесту
    public void Step2() throws FileNotFoundException {
        pageProvider.getStep2PagePage().checkIsStep2Visible();//певірка чи ми на Step2
        logger.info("--step2--");

        pageProvider.getStep2PagePage().enterTextIntoInputPurchName()
                .enterTextIntoInputEdrpou()
                .enterTextIntoInputAdresaPurch()
                .selectTextInDropDownCategoryPrurch();
        pageProvider.getStep2PagePage().clickOnButtonNext3();
        //pageProvider.getStep2PagePage().checkIsStep3Visible("Step3");
    }
}

