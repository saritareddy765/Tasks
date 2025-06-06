package Project.ParaBank.Pages;

import Project.ParaBank.Utilities.SeleniumActions;
import Project.ParaBank.Utilities.SeleniumWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenNewAccountPage {
    SeleniumActions seleniumActions;
    SeleniumWaits seleniumWaits;

    public OpenNewAccountPage(WebDriver driver){
        seleniumActions = new SeleniumActions(driver);
        seleniumWaits = new SeleniumWaits(driver);
        PageFactory.initElements(driver,this);
    }
    //click on open new account
    @FindBy(xpath = "//a[text()='Open New Account']")
    private WebElement openNewAccountLink;
    //click on savings account and its id
    @FindBy(css = "select[id='type']")
    private WebElement selectSavingsAccountTypeFromDropDownField;
    @FindBy(css = "select[id='fromAccountId']") private WebElement selectAccountId;
    @FindBy(css = "input[value='Open New Account']") private WebElement openAccountField;
    //validate the messages of opened new account
    @FindBy(xpath = "//div[@id='openAccountResult']/h1['Account Opened!']") private WebElement accountOpenTitle;
    @FindBy(xpath =
            "//div[@id='openAccountResult']/h1/following-sibling::p[contains(text(),'Congratulations')]")
    private WebElement openAccountResultMessage;
    @FindBy(xpath = "//div[@id='openAccountResult']/p/b[text()='Your new account number:']")
    private WebElement openAccountResultNewAccountNumber;

    public void clickOnOpenNewAccountLink(){
        seleniumWaits.waitForElementVisible(openNewAccountLink);
        seleniumActions.clickOnElement(openNewAccountLink);
    }
    public void getSelectSavingsAccountTypeFromDropDownField(String accountType){
        seleniumActions.selectByVisibleText
                (selectSavingsAccountTypeFromDropDownField, accountType);
    }
    public void clickOnAccountIdOfDropDown(){
        seleniumWaits.waitForElementVisible(selectAccountId);
        seleniumActions.clickOnElement(selectAccountId);
    }
    public void clickOnOpenAccountField(){
        seleniumWaits.waitForElementVisible(openAccountField);
        seleniumActions.clickOnElement(openAccountField);
    }
    public String getAccountOpenedTitle(){
        return seleniumActions.getTextMessage(accountOpenTitle);
    }
    public String getOpenAccountResultMessage(){
        seleniumWaits.waitForElementVisible(openAccountResultMessage);
        return seleniumActions.getTextMessage(openAccountResultMessage);
    }
    public String getOpenAccountResultNewNumberMessage(){
        seleniumWaits.waitForElementVisible(openAccountResultNewAccountNumber);
        return seleniumActions.getTextMessage(openAccountResultNewAccountNumber);
    }
}
