package Project.PoundLand;

import Project.PoundLand.Automation.BasePage;
import Project.PoundLand.Pages.CartPage;
import Project.PoundLand.Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PoundLandTestCases extends BasePage {
    public HomePage homePage;
    public CartPage cartPage;
    @BeforeClass
    public void initialize(){
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);

    }
    @Test
    public void verifyProductsTest() throws InterruptedException{
        homePage.clickOnAcceptAllCookiesField();
        homePage.searchAndClickOnProductItem("Breakfast Pot");
        String productItemText = homePage.getsearchProductText();
        System.out.println(productItemText);
        String productItemPrice = homePage.getsearchProductPrice();
        System.out.println(productItemPrice);
        homePage.getsearchProductDetails();
        Thread.sleep(5000);
        homePage.ClickOnAddField();
        Thread.sleep(5000);

        cartPage.clickOnCartIcon();
        String cartProductText = cartPage.getCartProductText();
        System.out.println(cartProductText);
        String cartProductPrice = cartPage.getCartProductPrice();
        System.out.println(cartProductPrice);
        Assert.assertEquals(productItemText,cartProductText);
        Assert.assertEquals(productItemPrice,cartProductPrice);

    }


}
