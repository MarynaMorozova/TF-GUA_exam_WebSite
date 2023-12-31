package steps;

import baseTest.BaseTest;
import categories.SmokeTestFilter;
import libs.ConfigProvider;
import libs.SpreadsheetData;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileInputStream;
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
    public void validLogin() throws SQLException, ClassNotFoundException {
        String url = "https://loans-dmz.dev.apps.testdmz-avalaunch.aval/gua-tender"; // Замініть на URL свого веб-сайту
        String filePath = "C://workSpaсe//key-6.pfx"; // Шлях до вашого файлу
        pageProvider.getLoginPage().openLoginPage(url);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigProvider.configProperties.TIME_FOR_DEFAULT_WAIT()));//замість 5 секунд

        pageProvider.getLoginPage().checkIsLabelFileVisible("LoginFile");

        // Знайти label за вказаним XPath
        WebElement label = webDriver.findElement(By.xpath(".//label [@for='upload']"));

        // Знайти батьківський елемент label і знайти в ньому інпут для завантаження файлу
        WebElement parentElement = label.findElement(By.xpath("./.."));
        WebElement fileInput = parentElement.findElement(By.tagName("input"));

        logger.info("Send file");
        // Відправити шлях до файлу в інпут
        fileInput.sendKeys(new File(filePath).getAbsolutePath());
        //  webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        pageProvider.getLoginPage().checkIsFileLoadVisible("LoginNameFile");

        webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        pageProvider.getLoginPage().checkIsInputPasswordVisible("Password");
        pageProvider.getLoginPage().enterTextIntoInputPassword(PASSWORD_DEFAULT);
        pageProvider.getLoginPage().checkSignInVisible("SignIn");

        pageProvider.getLoginPage().clickOnButtonSignIn("SignIn");
        pageProvider.getLoginPage().checkIsCheckBoxRobNotVisible();
    }

    @Test
    public void step1() {
        logger.info("--step1--");
        pageProvider.getStep1PagePage().checkIsStep1Visible("Step1");//певірка чи ми на Step1

        pageProvider.getStep1PagePage().selectTextInDropDownPH(purchaseCN, "DropDownPurh");
        pageProvider.getStep1PagePage().checkIsInputHrefVisible("InputHref");

        pageProvider.getStep1PagePage().enterTextIntoInputIdProzorro(idProzorro);
        pageProvider.getStep1PagePage().checkIsInputHrefVisible("IsVisibleHref");
        pageProvider.getStep1PagePage().clickOnradioButtonEasy("RadioButtonEasy");

        pageProvider.getStep1PagePage().clickOnButtonNext("ButtonNext");
        //перевірка, що немає сайн
    }
}
