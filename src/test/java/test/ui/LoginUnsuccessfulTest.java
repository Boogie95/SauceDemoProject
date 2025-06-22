package test.ui;

import org.testng.annotations.Test;

public class LoginUnsuccessfulTest extends BaseTest{
    @Test
    public void loginEmptyUsernameTest(){
        loginPage.logIn("","secret_sauce");
        loginPage.verifyErrorMessage("Epic sadface: Username is required");
    }
    @Test
    public void loginLockedOutUserTest(){
        loginPage.logIn("locked_out_user","secret_sauce");
        loginPage.verifyErrorMessage("Epic sadface: Sorry, this user has been locked out.");
    }

}
