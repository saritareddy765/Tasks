package Project.Day1;

import Project.Day1.Automation.BasePage;
import Project.Day1.Pages.CartPage;
import Project.Day1.Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductsTest extends BasePage {
    public HomePage homePage;
    public CartPage cartPage;
    @BeforeClass
    public void initialize(){
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);

    }
    @Test
    public void verifyProductsTest() throws InterruptedException{
        homePage.cookiesButton();
        homePage.searchBar();
        String productItemText = homePage.getProductText();
        System.out.println(productItemText);
        String productItemPrice = homePage.getProductPrice();
        System.out.println(productItemPrice);
        homePage.getProductDetails();
        Thread.sleep(5000);
        homePage.addToBasketButton();
        Thread.sleep(5000);

        cartPage.viewCart();
        String cartProductText = cartPage.getCartProductText();
        System.out.println(cartProductText);
        String cartProductPrice = cartPage.getCartProductPrice();
        System.out.println(cartProductPrice);
        Assert.assertEquals(productItemText,cartProductText);
        Assert.assertEquals(productItemPrice,cartProductPrice);

    }

}
