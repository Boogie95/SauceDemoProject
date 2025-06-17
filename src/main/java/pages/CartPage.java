package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
    }
    By inventoryItemName= By.xpath("//div[@class='inventory_item_name']");
    By checkOutButton=By.id("checkout");

    public String verifyInventoryItemName() {
         return getTextFromElement(inventoryItemName);
    }
    public void clickOnCheckoutButton(){click(checkOutButton);}
}
