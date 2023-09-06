package pages.tf_gua;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.ActionsWithElements;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static libs.ConfigProvider.configProperties;

public class ParentPageTF extends ActionsWithElements {

    String urlTF = "https://loans-dmz.dev.apps.testdmz-avalaunch.aval/gua-tender"; // Замініть на URL свого веб-сайту
    protected String filePath = configProperties.DATA_FILE_PATH() + "tf/" + "key-6.pfx";
  //  String KepTF = "C://workSpaсe//key-6.pfx";
    public ParentPageTF(WebDriver webDriver) throws FileNotFoundException {
        super(webDriver);
    }

    public void openPageTF() {
        try {
            webDriver.get(urlTF);
            logger.info("Page was opened " + urlTF);
        } catch (Exception e) {
            logger.error("Can not open " + urlTF);
            Assert.fail("Can not open " + urlTF);
        }
    }
}