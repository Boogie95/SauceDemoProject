package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;

import java.time.Duration;
import java.util.List;
import java.util.Random;


public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementToBeVisible(By by) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    public void waitForElementToBeClickable(By by) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
    }
    public void waitForElementToBeClickable(WebElement webElement) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
    public void insertText(By elementLocator, String textToInsert) {
        waitForElementToBeVisible(elementLocator);
        WebElement webElement = driver.findElement(elementLocator);
        webElement.clear();
        webElement.sendKeys(textToInsert);
    }
    public void click(By elementLocator) {
        waitForElementToBeClickable(elementLocator);
        WebElement webElement = driver.findElement(elementLocator);
        webElement.click();
    }
    public void click(WebElement webElement) {
        waitForElementToBeClickable(webElement);
        webElement.click();
    }
    public String getTextFromElement(By elementLocator) {
        waitForElementToBeVisible(elementLocator);
        WebElement webElement = driver.findElement(elementLocator);
        return webElement.getText();
    }
    void assertElementText(By elementLocator, String expectedText) {
        String actualText = getTextFromElement(elementLocator);
        Assert.assertEquals(actualText, expectedText);
    }

    public boolean isElementDisplayed(By element) {
        return driver.findElement(element).isDisplayed();
    }
}
