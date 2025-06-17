package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    By firstNameField= By.id("first-name");
    By lastNameField=By.id("last-name");
    By postalCodeField=By.id("postal-code");
    By continueButton=By.id("continue");
    By errorMessage=(By.xpath("//div[@class='error-message-container error']"));


    public void fillYourInformation(String firstname,String lastName,String zipCode){
        insertText(firstNameField,firstname);
        insertText(lastNameField,lastName);
        insertText(postalCodeField,zipCode);
        click(continueButton);
    }
    public void verifyErrorMessage(String expected){
        assertElementText(errorMessage,expected);
    }


}
