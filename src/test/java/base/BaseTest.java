package base;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import forms.FirstCardPage;
import forms.SecondCardPage;
import forms.ThirdCardPage;
import forms.WelcomePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import utils.ConfigUtility;
import utils.LoggerUtility;
import utils.TestUtility;

public class BaseTest {

    protected WelcomePage welcomePage;
    protected FirstCardPage firstCardPage;
    protected SecondCardPage secondCardPage;
    protected ThirdCardPage thirdCardPage;

    @BeforeTest
    public void beforeTest() {
        ConfigUtility.setConfigUtility();
        TestUtility.setTestUtility();
    }

    @BeforeMethod
    public void beforeMethod() {
        LoggerUtility.info("Step1: go to site");
        getBrowser().goTo(ConfigUtility.getStringValue("urlTestCase"));
        getBrowser().maximize();
        getBrowser().waitForPageToLoad();
        welcomePage = new WelcomePage();
        firstCardPage = new FirstCardPage();
        secondCardPage = new SecondCardPage();
        thirdCardPage = new ThirdCardPage();
    }

    @AfterMethod
    public void quit(){
        LoggerUtility.info("Driver quit");
        if (AqualityServices.isBrowserStarted()) {
            AqualityServices.getBrowser().quit();
        }
    }

    protected Browser getBrowser() {
        return AqualityServices.getBrowser();
    }
}
