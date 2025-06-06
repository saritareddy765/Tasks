package Project.ParaBank.Pages;

import Project.ParaBank.Utilities.SeleniumActions;
import Project.ParaBank.Utilities.SeleniumWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    SeleniumActions seleniumActions;
    SeleniumWaits seleniumWaits;

    public LoginPage(WebDriver driver){
        seleniumActions = new SeleniumActions(driver);
        seleniumWaits = new SeleniumWaits(driver);
        PageFactory.initElements(driver,this);
    }
    //Customer login credentials
    @FindBy(css = "input[name='username']") private WebElement customerUserNameField;
    @FindBy(css = "input[type='password']") private WebElement customerPasswordField;
    @FindBy(css = "input[value='Log In']") private WebElement loginButton;
    @FindBy(css = "p[class='smallText']") private WebElement customerNameWelcomeMessage;

    public void customerLoginDetails(String customerUserName, String customerPassword){
        seleniumActions.enterValue(customerUserNameField, customerUserName);
        seleniumActions.enterValue(customerPasswordField, customerPassword);
        seleniumActions.clickOnElement(loginButton);
    }
    public String getCustomerNameWelcomeMessage(){
        seleniumWaits.waitForElementVisible(customerNameWelcomeMessage);
        return seleniumActions.getTextMessage(customerNameWelcomeMessage);
    }
}
