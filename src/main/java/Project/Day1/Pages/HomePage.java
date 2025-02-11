package Project.Day1.Pages;

import Project.Day1.Utilities.SeleniumActions;
import Project.Day1.Utilities.SeleniumWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

     static final String browsingTheProductItem = "Waggle Honey, 250g";
    private static final String browsingTheProductId = "209847";

    SeleniumActions seleniumActions;
    SeleniumWaits seleniumWaits;
    public HomePage(WebDriver driver) {
        seleniumActions = new SeleniumActions(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()='Accept All Cookies']")
    private WebElement acceptCookiesDialougeField;
    @FindBy(css = "input[id='search']")
    private WebElement searchBarField;
    @FindBy(css = "button[title='Search']")
    private WebElement searchButtonIcon;
    @FindBy(xpath = "//span[@class='product name product-item-name']/a[text()='"+browsingTheProductItem+"']")
    private WebElement searchProductText;
    @FindBy(xpath = "//div[@data-product-id='"+browsingTheProductId+"']")
    private WebElement searchProductPrice;
    @FindBy(xpath = "//div[@class='product-bottom-details']/span/a[text()='"+browsingTheProductItem+"']")
    private WebElement searchProductDetailsPage;
    @FindBy(css = "button[title='Add to Basket']") private WebElement addToBasketField;

    public void clickOnAcceptAllCookiesField(){
        seleniumActions.clickOnElement(acceptCookiesDialougeField);
    }
    public void searchAndClickOnProductItem(String searchProductName){
        seleniumActions.searchButton(searchBarField,searchProductName);
        seleniumActions.clickOnElement(searchButtonIcon);
    }
    public String getsearchProductText(){
        return seleniumActions.getTextMessage(searchProductText);

    }
    public String getsearchProductPrice(){
        return seleniumActions.getTextMessage(searchProductPrice);
    }
    public void getsearchProductDetails(){
        seleniumActions.clickOnElement(searchProductDetailsPage);
    }
    public void ClickOnAddField(){
        seleniumActions.clickOnElement(addToBasketField);
    }
}
