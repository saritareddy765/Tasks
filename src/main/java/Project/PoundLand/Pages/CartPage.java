package Project.PoundLand.Pages;

import Project.PoundLand.Utilities.SeleniumActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    SeleniumActions seleniumActions;

    public CartPage(WebDriver driver) {
        seleniumActions = new SeleniumActions(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Your Basket']/../span/span")
    private WebElement cartIcon;
    @FindBy(xpath = "//strong[@class='product-item-name']/a")
    private WebElement cartProductText;
    @FindBy(xpath = "//p[@class='price-per-unit desktop']/preceding-sibling::span/span/span")
    private WebElement cartProductPriceText;

    public void clickOnCartIcon() {
        seleniumActions.clickOnElement(cartIcon);
    }

    public String getCartProductText() {
        return seleniumActions.getTextMessage(cartProductText);
    }

    public String getCartProductPrice() {
        return seleniumActions.getTextMessage(cartProductPriceText);
    }
}
