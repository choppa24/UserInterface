package forms;

import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class WelcomePage extends Form {

    private final ILink firstCardLink = getElementFactory().getLink(By.className("start__link"), "firstCardLink");

    public WelcomePage(){
        super(By.xpath("//div[contains(@class,'start')]"), "WelcomePage locator");
    }

    public void goToFirstCard(){
       firstCardLink.click();
    }
}
