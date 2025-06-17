package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage{

    By inventoryItemName= By.xpath("//div[@class='inventory_item_name']");
    By finishingOrderButton=By.id("finish");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }
    public String verifyImOnCheckoutOverviewWithSelectedItem(){
        return getTextFromElement(inventoryItemName);
    }
    public void finishOrder(){ click(finishingOrderButton);}
}
