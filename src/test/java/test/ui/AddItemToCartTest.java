package test.ui;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductsPage;
import test.data.TestData;

public class AddItemToCartTest extends BaseTest {
    @Test(dataProviderClass = TestData.class, dataProvider = "usersAddTShirt")
    public void addBoltTShirtToCartTest(String username, boolean canAdd){
        loginPage.logIn(username, "secret_sauce");
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addBoltTShirtToCart();
        Assert.assertEquals(
                productsPage.isBoltTShirtInCart(),
                canAdd,
                "Unexpected  behavior for user: " + username
        );
    }
}