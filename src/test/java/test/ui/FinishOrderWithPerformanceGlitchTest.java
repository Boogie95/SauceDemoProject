package test.ui;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.util.ArrayList;
import java.util.List;

public class FinishOrderWithPerformanceGlitchTest extends BaseTest{
    @Test
    public void orderAnyItemPerformanceUserTest() {
        loginPage.logIn("performance_glitch_user", "secret_sauce");
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);
        Header header = new Header(driver);
        CheckoutPage checkoutPage=new CheckoutPage(driver);
        CheckoutOverviewPage checkoutOverview=new CheckoutOverviewPage(driver);
        CheckoutCompletePage checkoutComplete=new CheckoutCompletePage(driver);

        List<String> expectedItems = new ArrayList<>();
        expectedItems.add(productsPage.addRandomElementToCart());

        header.clickOnCart();

        List<String> actualItems = cartPage.getAllCartItemNames();
        Assert.assertTrue(actualItems.containsAll(expectedItems));

        cartPage.clickOnCheckoutButton();
        checkoutPage.fillYourInformation("Jovan","Bundalo","19300");

        Assert.assertTrue(checkoutOverview.getAllCartItemNames().containsAll(expectedItems));
        checkoutOverview.finishOrder();
        checkoutComplete.verifyImOnCompletedOrderPage();
        Assert.assertTrue(checkoutComplete.backToProductsPage());

    }
}
