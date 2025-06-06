package Project.ParaBank;

import Project.ParaBank.Automation.BasePage;
import Project.ParaBank.Pages.LoginPage;
import Project.ParaBank.Pages.OpenNewAccountPage;
import Project.ParaBank.Pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ParaBankTestCases extends BasePage {
    public RegistrationPage registrationPage;
    public LoginPage loginPage;
    public OpenNewAccountPage openNewAccountPage;

    @BeforeClass
    public void initializePages(){
        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
        openNewAccountPage = new OpenNewAccountPage(driver);
    }

    @Test
    public void verifyParaBankCustomerRegisterationTestCases() {
        //click on regestrationLink
        registrationPage.clickOnRegisterLink();
        //Entering the details of account registerForm page
        registrationPage.fillTheRegisterFormPage
                ("sai", "saritha", "HighSchool", "Guntur", "A.P", "522313", "123456789",
                        "sr", "S@i12345", "S@i12345");

        //message displaying after account created
        String createdAccontWelcomeMessage =
                registrationPage.getWelcomeMessageOfAccountUserName();
        System.out.println(createdAccontWelcomeMessage);
        Assert.assertEquals(createdAccontWelcomeMessage, "Welcome sr");

        String createdAccountMessage =
                registrationPage.getAccountCreatedSuccessfullyMessage();
        System.out.println(createdAccountMessage);

        Assert.assertEquals(createdAccountMessage,
                "Your account was created successfully. You are now logged in.");
        //logout after accont creation
        registrationPage.clickOnLogoutAfterAccountCreated();



        //customer login details
        String customerNameWelcomeMessage = "Welcome sai saritha";
        loginPage.customerLoginDetails("sr","S@i12345");
        String welcomeWithCustomerNameMessage = loginPage.getCustomerNameWelcomeMessage();
        System.out.println(welcomeWithCustomerNameMessage);
        Assert.assertEquals(welcomeWithCustomerNameMessage,customerNameWelcomeMessage);

        //customer open new account
        openNewAccountPage.clickOnOpenNewAccountLink();
        openNewAccountPage.getSelectSavingsAccountTypeFromDropDownField("SAVINGS");
        openNewAccountPage.clickOnAccountIdOfDropDown();
        openNewAccountPage.clickOnOpenAccountField();
        //customer open new account result message assertion
        String openAccountHeading = "Account Opened!";
        String openAccountWishesMessage = "Congratulations, your account is now open.";
        String openAccountNewNumber = "Your new account number:";
        //heading
       /* String openedAccountTitle = openNewAccountPage.getAccountOpenedTitle();
        System.out.println(openedAccountTitle);
       Assert.assertEquals(openedAccountTitle,openAccountHeading);*/
        //wishes message
        String openedAccountMessage = openNewAccountPage.getOpenAccountResultMessage();
        System.out.println(openedAccountMessage);
        Assert.assertEquals(openedAccountMessage,openAccountWishesMessage);
        //account number message
        String accountOpenedNumber = openNewAccountPage.getOpenAccountResultNewNumberMessage();
        System.out.println(accountOpenedNumber);
        Assert.assertEquals(accountOpenedNumber,openAccountNewNumber);
    }

}

