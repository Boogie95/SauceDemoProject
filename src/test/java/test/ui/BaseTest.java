package test.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;

public class BaseTest {
    protected WebDriver driver;
    String url="https://www.saucedemo.com/";
    protected LoginPage loginPage;

    @BeforeMethod
    public void setup(){
        WebDriverManager.edgedriver().setup();
        driver=new EdgeDriver(new EdgeOptions().addArguments("--start-maximized"));
        driver.get(url);
        loginPage=new LoginPage(driver);
    }
    @AfterMethod
    public void tearDown(){driver.quit();}

}
