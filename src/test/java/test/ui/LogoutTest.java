package test.ui;

import org.testng.annotations.Test;
import pages.Header;
import test.data.TestData;

public class LogoutTest extends BaseTest{
    @Test(dataProviderClass = TestData.class, dataProvider = "logoutUsers")
    public void logOutFromProductsPage(String username,String pass){
        loginPage.logIn(username,pass);
        Header header=new Header(driver);
        header.clickOnMenuBar();
        header.clickOnLogout();
        loginPage.verifyImOnLoginPage();
    }
}
