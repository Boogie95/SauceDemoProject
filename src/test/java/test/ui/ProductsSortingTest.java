package test.ui;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductsPage;
import test.data.TestData;

public class ProductsSortingTest extends BaseTest{
    @Test(dataProviderClass = TestData.class,dataProvider ="sortOptionsWithUsers")
    public void sortingTestWithOptionsUsers(String username,String option){
     loginPage.logIn(username, "secret_sauce");
     ProductsPage productsPage=new ProductsPage(driver);
        if (option.contains("Price")) {
            Assert.assertTrue(productsPage.isPricesSorted(option),
                    "Items are not sorted correctly by: " + option);
        } else {
            Assert.assertTrue(productsPage.isNamesSorted(option),
                    "Items are not sorted correctly by: " + option);
        }
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "priceSortUsers")
    public void sortingPricePerUserTest(String username, String sortOption, boolean expectedResult) {
        loginPage.logIn(username, "secret_sauce");
        ProductsPage productsPage = new ProductsPage(driver);

        boolean isSorted = productsPage.isPricesSorted(sortOption);
        Assert.assertEquals(isSorted, expectedResult,
                "Unexpected sorting behavior for user: " + username);
    }
    @Test
    public void sortingErrorUserTest(){
        loginPage.logIn("error_user", "secret_sauce");
        ProductsPage productsPage = new ProductsPage(driver);
        boolean alertShown = productsPage.isAlertShow("Price (low to high)");
        Assert.assertTrue(alertShown, "Alert isn't displayed");
    }

}
