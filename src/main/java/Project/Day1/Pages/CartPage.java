package Project.Day1.Pages;

import Project.Day1.Utilities.SeleniumActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    SeleniumActions seleniumActions;
    public CartPage(WebDriver driver){
        seleniumActions = new SeleniumActions(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "(//*[name()='svg'])[10]") private WebElement viewCartIcon;
    @FindBy(xpath = "//strong[@class='product-item-name']/a[text()='Breakfast Pot']")
    private WebElement cartProductText;
    @FindBy(xpath = "//p[@class='price-per-unit desktop']/preceding-sibling::span/span/span")
    private WebElement cartPriceText;

    public void viewCart(){
        seleniumActions.clickOnElement(viewCartIcon);
    }
    public String getCartProductText(){
        return seleniumActions.getTextMessage(cartProductText);
    }
    public String getCartProductPrice(){
        return seleniumActions.getTextMessage(cartPriceText);
    }
}
