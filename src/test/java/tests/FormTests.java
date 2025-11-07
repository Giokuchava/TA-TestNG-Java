package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.time.Duration;

public class FormTests {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void fillAndSubmitForm() throws InterruptedException {
        driver.get("https://demoqa.com/automation-practice-form");

        driver.findElement(By.id("firstName")).sendKeys("Giorgi");
        driver.findElement(By.id("lastName")).sendKeys("Kuchava");

        WebElement submitButton = driver.findElement(By.id("submit"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true); window.scrollBy(0, -200);", submitButton);

        driver.findElement(By.id("userEmail")).sendKeys("giorgi.kuchava@example.com");

        WebElement gender = driver.findElement(By.xpath("//label[text()='Male']"));
        gender.click();

        driver.findElement(By.id("userNumber")).sendKeys("5991234569");

        WebElement dateOfBirthInput = driver.findElement(By.id("dateOfBirthInput"));
        dateOfBirthInput.click();

        WebElement monthDropdown = driver.findElement(By.className("react-datepicker__month-select"));
        Select selectMonth = new Select(monthDropdown);
        selectMonth.selectByVisibleText("May");

        WebElement yearDropdown = driver.findElement(By.className("react-datepicker__year-select"));
        Select selectYear = new Select(yearDropdown);
        selectYear.selectByVisibleText("2000");

        WebElement day = driver.findElement(By.cssSelector(".react-datepicker__day--015"));
        day.click();

        WebElement subjectsInput = driver.findElement(By.id("subjectsInput"));
        subjectsInput.sendKeys("Maths");
        subjectsInput.sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//label[text()='Sports']")).click();

        driver.findElement(By.id("currentAddress")).sendKeys("Tbilisi, Georgia");

        WebElement stateDropdown = driver.findElement(By.id("state"));
        stateDropdown.click();
        WebElement stateInput = driver.findElement(By.id("react-select-3-input"));
        stateInput.sendKeys("Haryana");
        stateInput.sendKeys(Keys.ENTER);

        WebElement cityDropdown = driver.findElement(By.id("city"));
        cityDropdown.click();
        WebElement cityInput = driver.findElement(By.id("react-select-4-input"));
        cityInput.sendKeys("Karnal");
        cityInput.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("example-modal-sizes-title-lg")));

        WebElement modal = driver.findElement(By.className("modal-content"));
        String modalText = modal.getText();

        Assert.assertTrue(modalText.contains("Giorgi Kuchava"), "Full name not found in the modal!");
        Assert.assertTrue(modalText.contains("giorgi.kuchava@example.com"), "Email not found!");
        Assert.assertTrue(modalText.contains("Male"), "Gender not found!");
        Assert.assertTrue(modalText.contains("599123456"), "Mobile number not found!");
        Assert.assertTrue(modalText.contains("Maths"), "Subject not found!");
        Assert.assertTrue(modalText.contains("Sports"), "Hobby not found!");
        Assert.assertTrue(modalText.contains("Tbilisi, Georgia"), "Address not found!");
        Assert.assertTrue(modalText.contains("Haryana"), "City not found!");
        Assert.assertTrue(modalText.contains("Karnal"), "State not found!");


    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}