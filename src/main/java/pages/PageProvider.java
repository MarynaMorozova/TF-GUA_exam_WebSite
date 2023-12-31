package pages;

import org.openqa.selenium.WebDriver;

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

    public LoginPageRBO getLoginPageRBO() {
        return new LoginPageRBO(webDriver);
    }

    public HomePage getHomePage() {
        return new HomePage(webDriver);
    }

}

