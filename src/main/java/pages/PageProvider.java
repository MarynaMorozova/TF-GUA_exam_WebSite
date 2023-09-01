package pages;

import org.openqa.selenium.WebDriver;
import pages.rbo.LoginPage_RBO;

import java.io.FileNotFoundException;

public class PageProvider {
    WebDriver webDriver;

    public PageProvider(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public LoginPage getLoginPage() {
        return new LoginPage(webDriver);
    }


    public Step1Page getStep1PagePage() {
        return new Step1Page(webDriver);
    }

    public Step2Page getStep2PagePage() {
        return new Step2Page(webDriver);
    }

    public Step3Page getStep3PagePage() {
        return new Step3Page(webDriver);
    }

    public LoginPage_RBO getLoginPageRBO() throws FileNotFoundException {
        return new LoginPage_RBO(webDriver);
    }

    public LoginPage_RBO getLoginPage_RBO() throws FileNotFoundException {
        return new LoginPage_RBO(webDriver);
    }

    public HomePage getHomePage() {
        return new HomePage(webDriver);
    }

}

