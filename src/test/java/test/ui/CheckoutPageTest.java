package test.ui;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.Header;
import pages.ProductsPage;
import test.data.TestData;

import java.util.ArrayList;
import java.util.List;

public class CheckoutPageTest extends BaseTestWithStandardLogin {

    @Test(dataProviderClass = TestData.class,dataProvider ="testInvalidFillForm")
    public void invalidFillInfo(String firstName,String lastName,String zip,String errorMessage){
        ProductsPage productsPage=new ProductsPage(driver);
        CheckoutPage checkoutPage=new CheckoutPage(driver);
        Header header=new Header(driver);
        CartPage cartPage=new CartPage(driver);

        header.clickOnCart();
        cartPage.clickOnCheckoutButton();

        checkoutPage.fillYourInformation(firstName,lastName,zip);
        checkoutPage.verifyErrorMessage(errorMessage);
    }
}
