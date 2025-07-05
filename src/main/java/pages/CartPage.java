package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
    }
    By inventoryItemName= By.xpath("//div[@class='inventory_item_name']");
    By checkOutButton=By.id("checkout");

    public List<String> getAllCartItemNames() {
        waitForElementToBeVisible(inventoryItemName);
        List<WebElement> items = driver.findElements(inventoryItemName);
        List<String> names = new ArrayList<>();
        for (WebElement item : items) {
            names.add(item.getText());
        }
        return names;
    }


    public void clickOnCheckoutButton(){click(checkOutButton);}
}
