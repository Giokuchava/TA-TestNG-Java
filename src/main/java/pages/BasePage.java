package pages;

import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;

    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {

        this.driver = driver;

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    }

    protected void click(By locator) {

        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();

    }

    protected void type(By locator, String text) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);

    }

    protected String getText(By locator) {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();

    }

    protected WebElement waitClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected WebElement waitVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void scrollTo(By locator) {
        WebElement el = waitVisible(locator);

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});" +
                        "window.scrollBy(0, -250);",  // 🔹 scroll a bit more up
                el
        );
    }



}