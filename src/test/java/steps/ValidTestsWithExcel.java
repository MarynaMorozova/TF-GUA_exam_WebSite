package steps;

import baseTest.BaseTest;
import categories.SmokeTestFilter;
import libs.SpreadsheetData;
import libs.Util;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import static data.TestData.PASSWORD_DEFAULT;
import static libs.ConfigProvider.configProperties;

/*Step1
- данні для теста витягнути з testData.xls,
створивши в ньому відповідний аркуш і додавши тестові данні:
1.    предмет закупівлі: заповнити код та назву,
посилання на ID оголошення Prozorro,
обирає вид закупівлі.

Візуалізувати посилання на сайт Prozorro за допомогою ID
*/
@RunWith(Parameterized.class)//тест буде брати дані з ексель, скільки раз скільки рядків
@Category(SmokeTestFilter.class)//маркуємо категорію для тесту

public class ValidTestsWithExcel extends BaseTest {
    //данні для Title, body, чекбокса і дропдауна витягнути з testData.xls,
    String purchaseCN;
    String idProzorro;

    public ValidTestsWithExcel(String purchaseCN, String idProzorro) { // конструктор
        this.purchaseCN = purchaseCN;
        this.idProzorro = idProzorro;
    }

    @Parameterized.Parameters
    //створивши в ньому відповідний аркуш і додавши тестові данні
    public static Collection testData() throws IOException {// метод який повертає колекцію з даними
        FileInputStream inputStream = new FileInputStream( // створюємо конекшен до файлу з даними
                configProperties.DATA_FILE_PATH() + "testData.xls");//
        return new SpreadsheetData(inputStream, "ParametrStep1").getData(); // створюємо колекцію з даними з екселю, вказуючи на вхід конекшен до файлу і назву листа
    }

    @Before
    public void validLogin() throws SQLException, ClassNotFoundException, FileNotFoundException {
        pageProvider.getLoginPageTF().openPageTF();
        Util.waitABit(10);
        pageProvider.getLoginPageTF().loadKepTF()
                .checkIsFileLoadVisible();
//        WebDriverWait webDriverWait10 = new WebDriverWait(webDriver, 15);
//        webDriverWait10.until(ExpectedConditions.elementToBeClickable(webElement));
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        pageProvider.getLoginPageTF().checkIsInputPasswordVisible()
                .enterTextIntoInputPassword(PASSWORD_DEFAULT)
                .checkSignInVisible();

        //webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        pageProvider.getLoginPageTF().clickOnButtonSignIn()
                .checkIsCheckBoxRobNotVisible();
    }

    @Test
    public void step1() throws FileNotFoundException {
        logger.info("--step1--");
        pageProvider.getStep1PagePage().checkIsStep1Visible();//певірка чи ми на Step1

        pageProvider.getStep1PagePage().selectTextInDropDownPH(purchaseCN, "DropDownPurh");
        pageProvider.getStep1PagePage().checkIsInputHrefVisible();

        pageProvider.getStep1PagePage().enterTextIntoInputIdProzorro(idProzorro);
        pageProvider.getStep1PagePage().checkIsInputHrefVisible();
        pageProvider.getStep1PagePage().clickOnradioButtonEasy();

        pageProvider.getStep1PagePage().clickOnButtonNext();
        //перевірка, що немає сайн
    }
}
