package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header extends BasePage{

    public Header(WebDriver driver) {
        super(driver);
    }
    By shoppingCartContainer= By.id("shopping_cart_container");
    By menu=By.id("react-burger-menu-btn");
    By logoutSidebar=By.id("logout_sidebar_link");


    public void clickOnMenuBar(){click(menu);}
    public void clickOnLogout(){click(logoutSidebar);}
    public void clickOnCart(){
        click(shoppingCartContainer);
    }
}
