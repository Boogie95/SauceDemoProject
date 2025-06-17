package test.ui;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.Header;
import pages.ProductsPage;
import test.data.TestData;

public class CheckoutPageTest extends BaseTestWithLogin{

    @Test(dataProviderClass = TestData.class,dataProvider ="testInvalidFillForm")
    public void invalidFillInfo(String firstName,String lastName,String zip,String errorMessage){
        ProductsPage productsPage=new ProductsPage(driver);
        CheckoutPage checkoutPage=new CheckoutPage(driver);
        Header header=new Header(driver);
        CartPage cartPage=new CartPage(driver);

        productsPage.addRandomElementToCart();
        header.clickOnCart();
        cartPage.clickOnCheckoutButton();

        checkoutPage.fillYourInformation(firstName,lastName,zip);
        checkoutPage.verifyErrorMessage(errorMessage);
    }
}
