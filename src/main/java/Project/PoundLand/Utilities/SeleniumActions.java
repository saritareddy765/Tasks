package Project.PoundLand.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumActions {
    private WebDriver driver;
    public SeleniumActions(WebDriver driver){
        this.driver = driver;
    }
    public void clickOnElement(WebElement element){
        element.click();
    }
    public void clickOnElement(By by){
        driver.findElement(by).click();
    }
    public void searchButton(WebElement element,String data){
        element.clear();
        element.sendKeys(data);
    }
    public String getTextMessage(WebElement element){
        return element.getText();
    }
}
