package Project.Cogmento.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumActions {
    WebDriver driver;
    public SeleniumActions(WebDriver driver){
        this.driver =driver;
    }
    public void clickOnElement(WebElement element){
        element.click();
    }
    public void enterValue(WebElement element,String data){
       // element.clear();
        element.sendKeys(data);
    }

}
