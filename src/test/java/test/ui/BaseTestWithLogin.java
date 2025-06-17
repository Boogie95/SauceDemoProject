package test.ui;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;

public class BaseTestWithLogin extends BaseTest {

    @BeforeMethod
    public void setup(){
        super.setup();
        loginPage.logIn("standard_user","secret_sauce");
    }
    @AfterMethod
    public void tearDown(){super.tearDown();}
}
