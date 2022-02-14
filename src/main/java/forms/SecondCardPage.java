package forms;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import utils.ConfigUtility;

public class SecondCardPage extends Form {
    private final String PASTE = "''";
    private final int dPASTE = 1;
    private final StringBuffer interest = new StringBuffer("//span[text() = '']//parent::div//label");
    private final IButton uploadPhotoButton = getElementFactory().getButton(By.xpath("//a[text()='upload']"), "UploadPhoto button");
    private final IButton nextButton = getElementFactory().getButton(By.xpath("//button[text()='Next']"), "UploadPhoto button");

    public SecondCardPage(){
        super(By.xpath("//h2[text()='This is me']"), "SecondCardPage locator");
    }

    public void selectInterest(String value){
        int positionPaste = interest.indexOf(PASTE);
        StringBuffer copyInterest = new StringBuffer(interest.toString());
        IButton unselectAll = getElementFactory().getButton(By.xpath(copyInterest.insert(positionPaste+dPASTE,value).toString()), "Unselect all");
        unselectAll.click();
    }

    public void uploadPhoto(String script) throws java.lang.InterruptedException{
        uploadPhotoButton.click();
        Thread.sleep(ConfigUtility.getIntValue("threadSleep"));
        try {
            Runtime.getRuntime().exec(script);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void nextButtonClick () throws java.lang.InterruptedException{
        Thread.sleep(ConfigUtility.getIntValue("threadSleep"));
        nextButton.click();
    }
}
