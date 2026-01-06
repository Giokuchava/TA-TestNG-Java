package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlertPage extends BasePage {
    public AlertPage(WebDriver driver) {
        super(driver);
    }

    private By alertTab = By.xpath("//a[contains(text(),'Alert with Textbox')]");
    private By alertButton = By.xpath("//button[@onclick='promptbox()']");
    private By resultText = By.id("demo1");
    public void open() {
        driver.get("https://demo.automationtesting.in/Alerts.html");
    }

    @Step("Open alert with text box")
    public void openPromptAlert() {
        driver.findElement(alertTab).click();
        driver.findElement(alertButton).click();
    }

    @Step("Enter text into alert and accept")
    public void enterTextAndAccept(String text) {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(text);
        alert.accept();
    }

    @Step("Get alert result text")
    public String getResultText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(resultText)).getText();
    }

}
