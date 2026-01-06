package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PracticeFormPage extends BasePage {
    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://demoqa.com/automation-practice-form");
    }

    @Step("Fill first and last name")
    public void fillName(String first, String last) {
        driver.findElement(By.id("firstName")).sendKeys(first);
        driver.findElement(By.id("lastName")).sendKeys(last);
    }

    @Step("Fill email")
    public void setEmail(String email) {
        driver.findElement(By.id("userEmail")).sendKeys(email);
    }

    @Step("Select gender")
    public void selectGender(String gender) {
        WebElement genderLabel =
                driver.findElement(By.xpath("//label[text()='" + gender + "']"));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", genderLabel);
    }

    @Step("Set mobile number")
    public void setMobile(String number) {
        driver.findElement(By.id("userNumber")).sendKeys(number);
    }

    @Step("Set birth date")
    public void setBirthDate(String month, String year, String day) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Open date picker
        WebElement dateInput = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("dateOfBirthInput")));
        js.executeScript("arguments[0].click();", dateInput);

        // Select month
        WebElement monthSelect = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.className("react-datepicker__month-select")));
        new Select(monthSelect).selectByVisibleText(month);

        // Select year
        WebElement yearSelect = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.className("react-datepicker__year-select")));
        new Select(yearSelect).selectByVisibleText(year);

        // Select day using aria-label (MOST RELIABLE)
        WebElement dayElement = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//div[contains(@aria-label,'" + day + "')]")
                )
        );

        js.executeScript("arguments[0].click();", dayElement);
    }

    @Step("Set subject")
    public void setSubject(String subject) {
        WebElement input = driver.findElement(By.id("subjectsInput"));
        input.sendKeys(subject);
        input.sendKeys(Keys.ENTER);
    }

    @Step("Set address")
    public void setAddress(String address) {
        driver.findElement(By.id("currentAddress")).sendKeys(address);
    }

    @Step("Select state and city")
    public void selectStateAndCity(String state, String city) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // STATE
        WebElement stateDropdown = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("state"))
        );
        stateDropdown.click();

        WebElement stateInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("react-select-3-input"))
        );
        stateInput.sendKeys(state);
        stateInput.sendKeys(Keys.ENTER);

        // CITY
        WebElement cityDropdown = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("city"))
        );
        cityDropdown.click();

        WebElement cityInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("react-select-4-input"))
        );
        cityInput.sendKeys(city);
        cityInput.sendKeys(Keys.ENTER);
    }

    @Step("Submit form")
    public void submit() {
        ((JavascriptExecutor) driver)
                .executeScript("document.getElementById('submit').click();");
    }

    public String getResultText() {
        return driver.findElement(By.className("modal-content")).getText();
    }
}
