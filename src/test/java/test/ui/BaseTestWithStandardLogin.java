package test.ui;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTestWithStandardLogin extends BaseTest {

    @BeforeMethod
    public void setup(){
        super.setup();
        loginPage.logIn("standard_user","secret_sauce");
    }
    @AfterMethod
    public void tearDown(){super.tearDown();}
}
