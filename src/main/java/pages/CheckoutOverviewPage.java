package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CheckoutOverviewPage extends BasePage{

    By inventoryItemName= By.xpath("//div[@class='inventory_item_name']");
    By finishingOrderButton=By.id("finish");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }
    public List<String> getAllCartItemNames() {
        waitForElementToBeVisible(inventoryItemName);
        List<WebElement> items = driver.findElements(inventoryItemName);
        List<String> names = new ArrayList<>();
        for (WebElement item : items) {
            names.add(item.getText());
        }
        return names;
    }
    public void finishOrder(){ click(finishingOrderButton);}
}
