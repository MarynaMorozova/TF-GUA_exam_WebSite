package pages;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import java.time.Duration;



public class ActionsWithElements {
    Logger logger = Logger.getLogger(getClass());
    protected WebDriver webDriver;
//    protected WebDriverWait webDriverWait10, webDriverWait15;


    public ActionsWithElements(WebDriver webDriver) {//constructor
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this); //initialization of elements
        // element in @FindBy
//        webDriverWait10 = new WebDriverWait(webDriver, Duration.ofSeconds(10));
//        webDriverWait15 = new WebDriverWait(webDriver, Duration.ofSeconds(ConfigProvider.configProperties.TIME_FOR_EXPLICIT_WAIT_LOW()));

    }
    @Step //хочемо бачити в репорті
    public void clickOnElement(WebElement element, String elementName) { //method for clicking on element
        try {
            element.click();
            logger.info(elementName+" element was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }
    @Step //хочемо бачити в репорті
    public void clickOnElement(String locator, String elementName) {
        try {
            clickOnElement(webDriver.findElement(By.xpath(locator)), elementName);
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    @Step //хочемо бачити в репорті
    public void enterTextIntoInput(WebElement element, String text) { //method for inputting text
        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text + " was inputted ");
        } catch (Exception e) {
// System.out.println("Can not work with element" + e);
// Assert.fail("Can not work with element" + e);
            printErrorAndStopTest(e);
        }
    }
    @Step //хочемо бачити в репорті
    public boolean isElementDisplayed(WebElement element, String elementName) {
        try {
            boolean state = element.isDisplayed();
            if (state) {
                logger.info(elementName+ " element is displayed");
            } else {
                logger.info( elementName +" element is not displayed");
            }
            return state;
        } catch (Exception e) {
            logger.info(elementName +" element is not displayed");
            return false;
        }
    }
//    @Step //хочемо бачити в репорті
    public void checkElementDisplayed(WebElement element, String elementName) {
        Assert.assertTrue(elementName + " element is not displayed", isElementDisplayed(element, elementName));
    }
//    @Step //хочемо бачити в репорті
    public void checkElementNotDisplayed(WebElement element,String elementName ) {
        Assert.assertFalse(elementName+ " element is displayed", isElementDisplayed(element,elementName));
    }
@Step //хочемо бачити в репорті
    // метод вибору значення з дропдауну
    public void selectTextInDropDownByUI(WebElement dropDown, String text, String nameElement) {
        try {
            clickOnElement(dropDown, nameElement);
            clickOnElement(dropDown.findElement(By.xpath("//*[contains(text(),'" + text + "')]")), nameElement);
            logger.info(text + " was selected in DropDown");
        } catch (Exception e) { // якщо в дропдауні немає вибраного значення
            printErrorAndStopTest(e);
        }
    }
 //   @Step //хочемо бачити в репорті
    private void printErrorAndStopTest(Exception e) {
        logger.error("Can not work with element" + e);
        Assert.fail("Can not work with element" + e);
    }
}


