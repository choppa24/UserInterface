package testCases;

import base.BaseTest;
import enums.Interests;
import enums.LengthString;
import enums.ScrollTypes;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.LoggerUtility;
import utils.RandomUtility;

public class testCase1 extends BaseTest {
    private final static String SCRIPT = "./src/main/resources/AutoItScript.exe";

    @Test
    public void test() throws java.lang.InterruptedException{
        Assert.assertTrue(welcomePage.isDisplayed(), "Welcome Page not open");

        LoggerUtility.info("Step2: go to first card");
        welcomePage.goToFirstCard();
        Assert.assertTrue(firstCardPage.isDisplayed(), "FirstCard Page not open");

        LoggerUtility.info("Step3: data input");
        getBrowser().scrollWindowBy(ScrollTypes.SCROLL_X.toInteger(), ScrollTypes.SCROLL_Y.toInteger());
        firstCardPage.sendData(RandomUtility.getRandomPassword(LengthString.LEN_15.toInteger()),
                RandomUtility.getRandomString(LengthString.LEN_15.toInteger()),
                RandomUtility.getRandomString(LengthString.LEN_5.toInteger()));
        firstCardPage.goToNextCard();
        Assert.assertTrue(secondCardPage.isDisplayed(), "SecondCard Page not open");

        LoggerUtility.info("Step4: Choose interests and photo upload");
        secondCardPage.selectInterest(Interests.UNSELECT_ALL.toString());
        secondCardPage.selectInterest(Interests.PONIES.toString());
        secondCardPage.selectInterest(Interests.POLO.toString());
        secondCardPage.selectInterest(Interests.DOUGH.toString());
        secondCardPage.uploadPhoto(SCRIPT);
        getBrowser().scrollWindowBy(ScrollTypes.SCROLL_X.toInteger(), ScrollTypes.SCROLL_Y.toInteger());
        secondCardPage.nextButtonClick();
        Assert.assertTrue(thirdCardPage.isDisplayed(), "ThirdCard Page not open");
    }
}
