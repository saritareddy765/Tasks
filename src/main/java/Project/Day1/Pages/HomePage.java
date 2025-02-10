package Project.Day1.Pages;

import Project.Day1.Utilities.SeleniumActions;
import Project.Day1.Utilities.SeleniumWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    SeleniumActions seleniumActions;
    SeleniumWaits seleniumWaits;
    public HomePage(WebDriver driver) {
        seleniumActions = new SeleniumActions(driver);
        PageFactory.initElements(driver, this);
    }

        @FindBy(xpath = "//button[text()='Accept All Cookies']")
        private WebElement AcceptCookiesButton;
    @FindBy(css = "input[id='search']") private WebElement searchField;
    @FindBy(css = "button[title='Search']") private WebElement searchButtonIcon;
    @FindBy(xpath = "//span[@class='product name product-item-name']/a[text()='Breakfast Pot']")
    private WebElement productText;
    @FindBy(css = "span[id='product-price-149871']") private WebElement productPrice;
    @FindBy(xpath = "//div[@class='product-bottom-details']/span/a[text()='Breakfast Pot']")
    private WebElement productDetailsPage;
    @FindBy(css = "button[title='Add to Basket']") private WebElement addField;

    public void cookiesButton(){
        seleniumActions.clickOnElement(AcceptCookiesButton);
    }
    public void searchBar(){
        seleniumActions.searchButton(searchField,"Breakfast pot");
        seleniumActions.clickOnElement(searchButtonIcon);
    }
    public String getProductText(){
        return seleniumActions.getTextMessage(productText);

    }
    public String getProductPrice(){
        return seleniumActions.getTextMessage(productPrice);
    }
    public void getProductDetails(){
        seleniumActions.clickOnElement(productDetailsPage);
    }
    public void addToBasketButton(){
        seleniumActions.clickOnElement(addField);
    }
}
