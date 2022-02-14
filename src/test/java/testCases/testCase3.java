package testCases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.LoggerUtility;

public class testCase3 extends BaseTest {

    @Test
    public void test(){
        Assert.assertTrue(welcomePage.isDisplayed(), "Welcome Page not open");

        LoggerUtility.info("Step2: go to first card");
        welcomePage.goToFirstCard();
        Assert.assertTrue(firstCardPage.isDisplayed(), "FirstCard Page not open");

        LoggerUtility.info("Step3: accept cookies");
        firstCardPage.acceptCookies();
        Assert.assertFalse(firstCardPage.isCookiesDisplayed(), "Cookies is not accept");
    }
}
