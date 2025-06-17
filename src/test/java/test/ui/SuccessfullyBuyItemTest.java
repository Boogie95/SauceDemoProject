package test.ui;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class SuccessfullyBuyItemTest extends BaseTestWithLogin{
    @Test
    public void orderAnyItemTest(){
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);
        Header header = new Header(driver);
        CheckoutPage checkoutPage=new CheckoutPage(driver);
        CheckoutOverviewPage checkoutOverview=new CheckoutOverviewPage(driver);
        CheckoutCompletePage checkoutComplete=new CheckoutCompletePage(driver);

        String expected = productsPage.addRandomElementToCart();
        header.clickOnCart();
        Assert.assertEquals(cartPage.verifyInventoryItemName(), expected);
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillYourInformation("Jovan","Bundalo","19300");
        Assert.assertEquals(checkoutOverview.verifyImOnCheckoutOverviewWithSelectedItem(),expected);

        checkoutOverview.finishOrder();
        checkoutComplete.verifyImOnCompletedOrderPage();
        Assert.assertTrue(checkoutComplete.backToProductsPage());

    }
}
