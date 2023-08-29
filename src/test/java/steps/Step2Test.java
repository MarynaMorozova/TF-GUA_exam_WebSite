package steps;

import baseTest.BaseTest;
import libs.ConfigProvider;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.sql.SQLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static data.TestData.PASSWORD_DEFAULT;


//@RunWith(JUnitParamsRunner.class) //позволяет использовать параметризацию

public class Step2Test extends BaseTest {
    @Before
    public void validLoginAndStep1() throws SQLException, ClassNotFoundException {
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

        logger.info("--step1--");
        pageProvider.getStep1PagePage().checkIsStep1Visible("Step1");//певірка чи ми на Step1

        pageProvider.getStep1PagePage().selectTextInDropDownPH("03111000-2", "DropDownPurh");
        pageProvider.getStep1PagePage().checkIsInputHrefVisible("InputHref");

        pageProvider.getStep1PagePage().enterTextIntoInputIdProzorro("UA-0000-00-00-000002-a");
        pageProvider.getStep1PagePage().checkIsInputHrefVisible("IsVisibleHref");
        pageProvider.getStep1PagePage().clickOnradioButtonEasy("RadioButtonEasy");

        pageProvider.getStep1PagePage().clickOnButtonNext("ButtonNext");
    }

    @Test
    public void Step2() {
        pageProvider.getStep2PagePage().checkIsStep2Visible("Step2");//певірка чи ми на Step2
        logger.info("--step2--");

        pageProvider.getStep2PagePage().enterTextIntoInputPurchName()
                .enterTextIntoInputEdrpou()
                .enterTextIntoInputAdresaPurch()
                .selectTextInDropDownCategoryPrurch();
        pageProvider.getStep2PagePage().clickOnButtonNext3("ButtonNextOnStep3")
                .checkIsStep3Visible("Step3");
    }
}

