package Project.Cogmento.Pages;

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

    //enter mail,password and login
    @FindBy(xpath = "//input[@name='email']") private WebElement emailInputField;
    @FindBy(xpath = "//input[@name='password']") private WebElement passwordInputField;
    @FindBy(xpath = "//div[text()='Login']") private WebElement submitField;

    public void loginCredentials(String userEmail, String password){
        seleniumActions.enterValue(emailInputField,userEmail);
        seleniumActions.enterValue(passwordInputField,password);
        seleniumActions.clickOnElement(submitField);
    }
}
