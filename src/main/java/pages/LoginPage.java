package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By usernameField=(By.id("user-name"));
    By passwordField=(By.id("password"));
    By loginButton=(By.id("login-button"));
    By errorMessage=(By.className("error-message-container"));
    By loginCredentials=(By.xpath("//h4[contains(text(),'usernames')]"));


    public void logIn(String username,String pass){
        insertText(usernameField,username);
        insertText(passwordField,pass);
        click(loginButton);
    }

    public void verifyErrorMessage(String expected){
        assertElementText(errorMessage,expected);
    }

    public void verifyImOnLoginPage(){
        assertElementText(loginCredentials,"Accepted usernames are:");
    }




}



