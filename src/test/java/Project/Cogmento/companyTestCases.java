package Project.Cogmento;

import Project.Cogmento.Pages.BasePage;
import Project.Cogmento.Pages.LoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class companyTestCases extends BasePage {
    public LoginPage loginPage;
    @BeforeClass
    public void initializePages(){
        loginPage = new LoginPage(driver);
    }
    @Test
    public void verifyCogmentoCompanyTestCases(){
        //loginCredentials details
        loginPage.loginCredentials("saritareddy3024@gmail.com","sarita123");

    }
}
