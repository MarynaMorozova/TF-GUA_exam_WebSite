package steps;

import baseTest.BaseTest;
import categories.SmokeTestFilter;

import libs.Util;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.time.Duration;

import static data.TestData.PASSWORD_DEFAULT;

public class Step2Test extends BaseTest {
    //Ввод тествових даних для Кроку 1
    String textInDropDownPH = "03111000-2";
    String inputIdProzorro = "UA-2023-06-28-009743-a";

    //Ввод тествових даних для Кроку 2
    String textInputEdrpou = "43646107";
    String inputAdresaPurch = "Фастов";
    String textInDropDownCategoryPrurch = "Органи соціального страхування";

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
        Util.waitABit(30);
        //webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        pageProvider.getLoginPageTF().clickOnButtonSignIn()
                .checkIsCheckBoxRobNotVisible();
        logger.info("--step1--");
        Util.waitABit(30);
        pageProvider.getStep1PagePage().checkIsStep1Visible()//певірка чи ми на Step1

                .selectTextInDropDownPH(textInDropDownPH, "DropDownPurh")
                .checkIsInputHrefVisible()
                .enterTextIntoInputIdProzorro(inputIdProzorro)
                .checkIsInputHrefVisible()
                .clickOnradioButtonEasy()
                .clickOnButtonNext();
    }

    @Test
    @Category(SmokeTestFilter.class)//маркуємо категорію для тесту
    public void Step2() throws FileNotFoundException {
        pageProvider.getStep2PagePage().checkIsStep2Visible();//перевірка чи ми на Step2
        logger.info("--step2--");
        Util.waitABit(30);
        pageProvider.getStep2PagePage().enterTextIntoInputPurchName()
                .enterTextIntoInputEdrpou(textInputEdrpou)
                .enterTextIntoInputAdresaPurch(inputAdresaPurch)
                .selectTextInDropDownCategoryPrurch(textInDropDownCategoryPrurch)
                .clickOnButtonNext3();
//        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
//        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div [text()= 'Крок 2 з 5']")));
        Util.waitABit(30);
        pageProvider.getStep2PagePage().checkIsStep2NotVisible();
    }
}

