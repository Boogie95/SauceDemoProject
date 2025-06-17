package test.ui;

import org.testng.annotations.Test;
import pages.Header;

public class LogoutTest extends BaseTestWithLogin{
    @Test
    public void logOutFromProductsPage(){
        Header header=new Header(driver);
        header.clickOnMenuBar();
        header.clickOnLogout();
        loginPage.verifyImOnLoginPage();
    }
}
