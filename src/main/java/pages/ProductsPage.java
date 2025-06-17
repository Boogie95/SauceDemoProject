package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }
    By productSortContainer = By.xpath("//select");

    public void selectSortOption(String option){
        click(productSortContainer);
        click(driver.findElement(By.xpath("//option[contains(text(),'" + option + "')]")));
    }

    public List<Double> getSortedPrices(){
        List<WebElement> elementList = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        List<Double> prices = new ArrayList<>();
        for(WebElement priceElement : elementList){
            prices.add(getPriceAsDouble(priceElement));
        }
        return prices;
    }

    public List<String> getSortedNames(){
        List<WebElement> elementList = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        List<String> names = new ArrayList<>();
        for(WebElement nameElement : elementList){
            names.add(nameElement.getText());
        }
        return names;
    }

    public boolean isPricesSorted(String option) {
        selectSortOption(option);
        List<Double> prices = getSortedPrices();

        for (int i = 0; i < prices.size() - 1; i++) {
            if (option.equals("Price (low to high)")) {
                if (prices.get(i) > prices.get(i + 1)) return false;
            } else if (option.equals("Price (high to low)")) {
                if (prices.get(i) < prices.get(i + 1)) return false;
            }
        }
        return true;
    }
    public boolean isNamesSorted(String option) {
        selectSortOption(option);
        List<String> names = getSortedNames();

        for (int i = 0; i < names.size() - 1; i++) {
            if (option.equals("Name (A to Z)")) {
                if (names.get(i).compareToIgnoreCase(names.get(i + 1)) > 0) return false;
            } else if (option.equals("Name (Z to A)")) {
                if (names.get(i).compareToIgnoreCase(names.get(i + 1)) < 0) return false;
            }
        }
        return true;
    }

    private double getPriceAsDouble(WebElement webElement){
        String element = webElement.getText();
        String reduceDollar = element.replace("$","");
        return Double.parseDouble(reduceDollar);
    }

    public String addRandomElementToCart() {
        List<WebElement> elementList = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        if (elementList.isEmpty()) {
            throw new SkipException("Empty list");
        }
        Random random = new Random();
        WebElement chosenElement = elementList.get(random.nextInt(elementList.size()));
        String chosenElementName = chosenElement.findElement(By.className("inventory_item_name")).getText();
        WebElement addToCartBtn = chosenElement.findElement(By.tagName("button"));
        click(addToCartBtn);
        return chosenElementName;
    }

    public boolean isProductSortDropDownDisplayed(){
        return isElementDisplayed(productSortContainer);
    }
}

