package Project.ParaBank.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SeleniumActions {
    WebDriver driver;

    public SeleniumActions(WebDriver driver){
        this.driver = driver;
    }
    public void clickOnElement(WebElement element){
        element.click();
    }
    public void enterValue(WebElement element, String data){
        element.clear();
        element.sendKeys(data);
    }
    public String getTextMessage(WebElement element){
        return element.getText();
    }
    public void selectByVisibleText(WebElement element, String data){
        Select selectText = new Select(element);
        selectText.selectByVisibleText(data);
    }
}
