package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



import java.time.Duration;

public class AlertTests {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @Test
    public void alertTest() throws InterruptedException {
        driver.get("https://demo.automationtesting.in/Alerts.html");
        driver.findElement(By.xpath("//a[contains(text(),'Alert with Textbox')]")).click();

        WebElement PromptButton =driver.findElement(By.xpath("//button[@onclick='promptbox()']"));
        PromptButton.click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert prompt = driver.switchTo().alert();
        String inputText="Giorgi Kuchava";
        prompt.sendKeys(inputText);
        prompt.accept();

        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("demo1")));
        String actualText = result.getText();

        Assert.assertTrue(actualText.contains(inputText), "Expected text not found! Actual text: " + actualText);


    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
