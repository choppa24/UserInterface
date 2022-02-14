package forms;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class ThirdCardPage extends Form {

    public ThirdCardPage(){
        super(By.xpath("//h3[text() = 'Personal details']"), "ThirdCardPage locator");
    }
}
