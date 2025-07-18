package test.ui;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.util.ArrayList;
import java.util.List;

public class SuccessfullyBuyItemTest extends BaseTestWithStandardLogin {
    @Test
    public void orderAnyItemTest(){
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);
        Header header = new Header(driver);
        CheckoutPage checkoutPage=new CheckoutPage(driver);
        CheckoutOverviewPage checkoutOverview=new CheckoutOverviewPage(driver);
        CheckoutCompletePage checkoutComplete=new CheckoutCompletePage(driver);



        List<String> expectedItems = new ArrayList<>();
        expectedItems.add(productsPage.addRandomElementToCart());
        productsPage.addBoltTShirtToCart();
        expectedItems.add("Sauce Labs Bolt T-Shirt");

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
