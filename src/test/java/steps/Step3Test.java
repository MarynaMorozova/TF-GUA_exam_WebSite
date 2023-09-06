package steps;

import baseTest.BaseTest;
import categories.SmokeTestFilter;
import io.qameta.allure.*;
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
import static data.TestData.PASSWORD_INVALID;

@Category(SmokeTestFilter.class)
public class Step3Test extends BaseTest {
    String textInDropDownPH = "03111000-2";
    String inputIdProzorro = "UA-2023-06-28-009743-a";

    //Ввод тествових даних для Кроку 2
    String textInputEdrpou = "43646107";
    String inputAdresaPurch = "Фастов";
    String textInDropDownCategoryPrurch = "Органи соціального страхування";

    //Ввод тествових даних для Кроку 3

    String inputDateTerminDii = "25.03.2024";
    String inputDatePrPropoz = "26.09.2023";
    String inputSumGarant = "20000";
    String inDropDownSelectAccount = "UA613808050000000026005728147";// звідси переносити номер рахунку
    String inputTextarea5 = "11";
    String inputTextarea6 = "22";

    @Before
    public void validLoginAndStep1() throws SQLException, ClassNotFoundException, FileNotFoundException {
        pageProvider.getLoginPageTF().openPageTF();
        Util.waitABit(10);
        pageProvider.getLoginPageTF().loadKepTF()
                .checkIsFileLoadVisible();
//        WebDriverWait webDriverWait10 = new WebDriverWait(webDriver, 15);
       //webDriverWait10.until(ExpectedConditions.elementToBeClickable(inputPassword));
        //    webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        pageProvider.getLoginPageTF().checkIsInputPasswordVisible()
                .enterTextIntoInputPassword(PASSWORD_DEFAULT)
                .checkSignInVisible();

        //webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        pageProvider.getLoginPageTF().clickOnButtonSignIn()
                .checkIsCheckBoxRobNotVisible();
        logger.info("--step1--");
        pageProvider.getStep1PagePage().checkIsStep1Visible()//певірка чи ми на Step1
                .selectTextInDropDownPH("03111000-2", "DropDownPurh")
                .checkIsInputHrefVisible()
                .enterTextIntoInputIdProzorro("UA-2023-06-28-009743-a")
                .checkIsInputHrefVisible()
                .clickOnradioButtonEasy()
                .clickOnButtonNext();
        logger.info("--step2--");
        pageProvider.getStep2PagePage().enterTextIntoInputPurchName()
                .enterTextIntoInputEdrpou("43646107")
                .enterTextIntoInputAdresaPurch("Фастов")
                .selectTextInDropDownCategoryPrurch("Органи соціального страхування")
                .clickOnButtonNext3()
                .checkIsStep3Visible();//певірка чи ми на Step3
    }

    @Description("Step3")
//    @Link("https://example.org")
//    @Link(name = "allure", type = "mylink")
//    @Issue("123")
//    @Issue("432")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Base support for bdd annotations")

    @Test
    //@Ignore // проінорувати тест
    @Category(SmokeTestFilter.class)
//маркуємо категорію для тесту- ставиться перед класом або методом(якщо не параметризований)
    public void Step3() throws FileNotFoundException {
        logger.info("--step3--");

        pageProvider.getStep3PagePage().enterTextIntoInputDateTerminDii(inputDateTerminDii)
                .enterTextIntoInputDatePrPropoz(inputDatePrPropoz)
                .enterTextIntoInputSumGarant(inputSumGarant)
                .selectTextInDropDownSelectAccount(inDropDownSelectAccount)// звідси переносити номер рахунку
                .enterTextIntoInputTextarea5(inputTextarea5)
                .enterTextIntoInputTextarea6(inputTextarea6)
                .clickOnButtonNext4();
        Util.waitABit(10);
        pageProvider.getStep3PagePage().checkIsStep3NotVisible();
    }
}

