package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BasePage{
    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }
    By backHomeButton= By.id("back-to-products");
    By successfulOrderMessage=By.tagName("h2");

    public void verifyImOnCompletedOrderPage(){
        assertElementText(successfulOrderMessage,"Thank you for your order!");
    }

    public boolean backToProductsPage(){
        click(backHomeButton);
        ProductsPage productsPage=new ProductsPage(driver);
        return productsPage.isProductSortDropDownDisplayed();
    }
}
