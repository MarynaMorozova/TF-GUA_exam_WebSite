package pages.tf_gua;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.ActionsWithElements;

public class ParentPageTF extends ActionsWithElements {


    public ParentPageTF(WebDriver webDriver) {
        super(webDriver);
    }

    public void openPage(String url) {
        try {
            webDriver.get(url);
            logger.info("Page was opened " + url);
        } catch (Exception e) {
            logger.error("Can not open " + url);
            Assert.fail("Can not open " + url);
        }
    }
}