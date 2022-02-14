package forms;

import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.util.List;

public class FirstCardPage extends Form {

    private final ITextBox passwordBox = getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder, 'Password')]"), "Password Box");
    private final ITextBox emailBox = getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder, 'email')]"), "Email Box");
    private final ITextBox domainBox = getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder, 'Domain')]"), "Domain Box");
    private final ICheckBox acceptToUse = getElementFactory().getCheckBox(By.xpath("//label[contains(@for, 'accept')]"), "Accept to use CheckBox");
    private final IButton nextButton = getElementFactory().getButton(By.xpath("//a[text()='Next']"), "Next card button");
    private final IButton selectEmailButton = getElementFactory().getButton(By.className("dropdown__opener"), "Select email");
    private final ILabel emailLabel = getElementFactory().getLabel(By.xpath("//div[text() = '.org']"), "Email label");
    private final IButton popUpClose = getElementFactory().getButton(By.xpath("//span[text() = 'Send']"), "PopUp closeButton");
    private final ILabel popUpIsHidden = getElementFactory().getLabel(By.xpath("//div[contains(@class,'help-form is-hidden')]"),"PopUp is hidden");
    private final IButton cookies_acceptButton = getElementFactory().getButton(By.xpath("//button[contains(text(),'Not really')]"), "Cookies acceptButton");
    private final By cookiesCheckOpen = By.className("cookies");
    private final By timerLabel = By.xpath("//div[contains(text(),'00:00:00')]");

    public FirstCardPage(){
        super(By.xpath("//input[contains(@placeholder, 'Password')]"), "FirstCardPage locator");
    }

    public void sendData(String password, String email, String domain){
        passwordBox.clearAndType(password);
        emailBox.clearAndType(email);
        domainBox.clearAndType(domain);
        selectEmailButton.click();
        emailLabel.click();
        acceptToUse.click();
    }

    public void goToNextCard(){
        nextButton.click();
    }

    public void closePopUp(){
        popUpClose.click();
    }

    public boolean isPopUpNotDisplayed(){
        return popUpIsHidden.state().isDisplayed();
    }

    public void acceptCookies(){
        cookies_acceptButton.click();
    }

    public boolean isCookiesDisplayed(){
        List <ILabel> checkDispList = getElementFactory().findElements(cookiesCheckOpen, ElementType.LABEL);
        return  (checkDispList.size() > 0);
    }

    public boolean isTimerZero(){
        List <ILabel> checkTimer = getElementFactory().findElements(timerLabel, ElementType.LABEL);
        return  (checkTimer.size() > 0);
    }
}
