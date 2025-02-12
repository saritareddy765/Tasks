package Project.Day2.Pages;

import Project.Day2.Utilities.SeleniumActions;
import Project.Day2.Utilities.SeleniumWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
    SeleniumActions seleniumActions;
    SeleniumWaits seleniumWaits;

    public RegistrationPage(WebDriver driver){
        seleniumActions = new SeleniumActions(driver);
        seleniumWaits = new SeleniumWaits(driver);
        PageFactory.initElements(driver,this);
    }
    //click on registerLink
    @FindBy(xpath = "//a[text()='Register']") private WebElement registerLink;

    //fill in the fields of registration page
    @FindBy(css = "input[id='customer.firstName']") private WebElement firstNameInputField;
    @FindBy(css = "input[name='customer.lastName']") private WebElement lastNameInputField;
    @FindBy(css = "input[id='customer.address.street']")
    private WebElement addressInputField;
    @FindBy(css = "input[name='customer.address.city']") private WebElement cityInputField;
    @FindBy(css = "input[id='customer.address.state']") private WebElement stateInputField;
    @FindBy(css = "input[name='customer.address.zipCode']")
    private WebElement zipCodeInputField;
    @FindBy(css = "input[id='customer.ssn']") private WebElement ssnNumberInputField;

    @FindBy(css = "input[name='customer.username']") private WebElement userNameInputField;
    @FindBy(css = "input[id='customer.password']") private WebElement passwordInputField;
    @FindBy(css = "input[name='repeatedPassword']")
    private WebElement confirmPasswordInputField;
    @FindBy(css = "input[value='Register']") private WebElement registerButtonField;

    //verify message after account creation
    @FindBy(css = ".title") private WebElement welcomeMessage;
    @FindBy(xpath = "//p[contains(text(),'Your account was created successfully')]")
    private WebElement accountCreatedSuccessfullyMessage;

    //logout after account created
    @FindBy(xpath = "//div[@id='leftPanel']/ul/li/a[text()='Log Out']")
    private WebElement logoutLink;

    public void clickOnRegisterLink(){
        seleniumActions.clickOnElement(registerLink);
    }
    public void fillTheRegisterFormPage
            (String firstName, String lastName, String address, String city, String state,
             String zipCode, String ssnNumber,
             String userName, String password,String confirmPassword){
        seleniumActions.enterValue(firstNameInputField, firstName);
        seleniumActions.enterValue(lastNameInputField,lastName);
        seleniumActions.enterValue(addressInputField,address);
        seleniumActions.enterValue(cityInputField, city);
        seleniumActions.enterValue(stateInputField, state);
        seleniumActions.enterValue(zipCodeInputField, zipCode);
        seleniumActions.enterValue(ssnNumberInputField, ssnNumber);
        seleniumActions.enterValue(userNameInputField,userName);
        seleniumActions.enterValue(passwordInputField, password);
        seleniumActions.enterValue(confirmPasswordInputField, confirmPassword);
        seleniumActions.clickOnElement(registerButtonField);
    }
    public String getWelcomeMessageOfAccountUserName(){
        seleniumWaits.waitForElementVisible(welcomeMessage);
        return seleniumActions.getTextMessage(welcomeMessage);
    }
    public String getAccountCreatedSuccessfullyMessage(){
        seleniumWaits.waitForElementVisible(accountCreatedSuccessfullyMessage);
        return seleniumActions.getTextMessage(accountCreatedSuccessfullyMessage);
    }
    public void clickOnLogoutAfterAccountCreated(){
        seleniumWaits.waitForElementVisible(logoutLink);
        seleniumActions.clickOnElement(logoutLink);
    }
}
