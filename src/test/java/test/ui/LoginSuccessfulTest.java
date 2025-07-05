package test.ui;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductsPage;
import test.data.TestData;

@Test(dataProviderClass = TestData.class, dataProvider = "validUsers")
public class LoginSuccessfulTest extends BaseTest{
    public void successfulLoginTest(String username, String password) {
        loginPage.logIn(username, password);
        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.isProductSortDropDownDisplayed(),
                "Products page not loaded for user: " + username);
    }
}