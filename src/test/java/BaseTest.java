
import io.github.bonigarcia.wdm.WebDriverManager;
import junitparams.JUnitParamsRunner;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Rule;

import org.junit.experimental.categories.Category;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import pages.PageProvider;
import org.openqa.selenium.chrome.ChromeDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;
//import io.qameta.allure.Allure;// для отчета епік-фіча...
//import libs.ConfigProvider;
//import libs.ScreenShot;
//import org.apache.log4j.Logger;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Rule;
//import org.junit.rules.TestName;
//import org.junit.rules.TestWatcher;
//import org.junit.runner.Description;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.safari.SafariDriver;
//import pages.PageProvider;
//
//@Epic("Allure examples")
//@Feature("Junit 4 support")
//
//
////@RunWith(JUnitParamsRunner.class) //позволяет использовать параметризацию
//@Category(SmokeTestFilter.class)


public class BaseTest {
    WebDriver webDriver;
    protected PageProvider pageProvider;
    protected Logger logger = Logger.getLogger(getClass());

//    @Description("Some detailed test description")
//    @Link("https://example.org")
//    @Link(name = "allure", type = "mylink")
//    @Issue("123")
//    @Issue("432")
//    @Severity(SeverityLevel.CRITICAL)
//    @Story("Base support for bdd annotations")

    @Before
    public void setUp() {
        logger.info("-----" + testName.getMethodName() + " was started ----");
        webDriver = initDriver();
        webDriver.manage().window().maximize();
        //   webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigProvider.configProperties.TIME_FOR_DEFAULT_WAIT()));//замість 5 секунд
        logger.info("Browser was opened");
        pageProvider = new PageProvider(webDriver);
        //       webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));//замість 30 секунд
    }

//    @After
//    public void tearDown() {
//        webDriver.quit();
//        logger.info("Browser was closed");
//        logger.info("-----" + testName.getMethodName() + " was stop ----");
//    }

    @Rule
    public TestName testName = new TestName();


    private WebDriver initDriver() {
        String browser = System.getProperty("browser");//передаємо з командної стрічки параметр -Dbrowser=chrome
        if ((browser == null) || ("edge".equals(browser.toLowerCase()))) {   //edge
            WebDriverManager.edgedriver().setup();
            webDriver = new EdgeDriver();
        } else if ("firefox".equals(browser.toLowerCase())) {
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
        } else if ("iedriver".equals(browser.toLowerCase())) {   //internet explorer
            WebDriverManager.iedriver().setup(); //zoom 100%
            webDriver = new InternetExplorerDriver();//security level medium
        } else if ("chrome".equals(browser.toLowerCase())) {//якщо нічого не передали або передали chrome, дефолтний браузер
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
        } else {
            throw new IllegalArgumentException("Browser" + browser + "is not supported");//якщо передали невірний браузер
        }
        return webDriver;
    }
}


