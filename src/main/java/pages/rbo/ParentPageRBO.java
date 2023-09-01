package pages.rbo;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.ActionsWithElements;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static libs.ConfigProvider.configProperties;

public class ParentPageRBO extends ActionsWithElements {
    String urlRBO = "https://rbo-dev.avrb.com.ua/ibank/home?0"; // Замініть на URL свого веб-сайту
    protected FileInputStream KepRbo = new FileInputStream( // створюємо конекшен до файлу з даними
            configProperties.DATA_FILE_PATH() + "rbo/" + "КОФІТОН_37120506_директор.dat");

    public ParentPageRBO(WebDriver webDriver) throws FileNotFoundException {
        super(webDriver);
    }

    public void openPageRBO() {
        try {
            webDriver.get(urlRBO);
            logger.info("Page was opened " + urlRBO);
        } catch (Exception e) {
            logger.error("Can not open " + urlRBO);
            Assert.fail("Can not open " + urlRBO);
        }
    }
}