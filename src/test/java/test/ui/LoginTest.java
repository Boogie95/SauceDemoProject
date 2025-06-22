package test.ui;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductsPage;
import test.data.TestData;

public class LoginTest extends BaseTest{
    @Test(dataProviderClass = TestData.class,dataProvider ="testDataValid")
    public void loginWithValidCredentials(String username,String password){
        ProductsPage productsPage=new ProductsPage(driver);
        loginPage.logIn(username,password);
        Assert.assertTrue(productsPage.isProductSortDropDownDisplayed(),"DropDown isn't display");
    }

}
