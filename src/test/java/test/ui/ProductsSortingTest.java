package test.ui;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductsPage;
import test.data.TestData;

public class ProductsSortingTest extends BaseTestWithLogin{
    @Test(dataProviderClass = TestData.class,dataProvider ="testOptionSort")
    public void sortingTest(String option){
     ProductsPage productsPage=new ProductsPage(driver);
        if (option.contains("Price")) {
            Assert.assertTrue(productsPage.isPricesSorted(option),
                    "Items are not sorted correctly by: " + option);
        } else {
            Assert.assertTrue(productsPage.isNamesSorted(option),
                    "Items are not sorted correctly by: " + option);
        }
    }
}
