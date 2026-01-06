package alert;
import base.TestBase;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertPage;
import utils.DriverFactory;

@Epic("Alerts")
@Feature("Prompt Alert")
public class AlertTests extends TestBase {

    @Test
    @Story("User enters text in alert")
    @Severity(SeverityLevel.CRITICAL)
    public void alertTest() {
        Allure.step("Open Alerts page");
        DriverFactory.getDriver().get("https://demo.automationtesting.in/Alerts.html");

        AlertPage alertPage = new AlertPage(DriverFactory.getDriver());
        Allure.step("Open alert and enter text");
        alertPage.openPromptAlert();
        alertPage.enterTextAndAccept("Giorgi Kuchava");
        Allure.step("Verify alert result");
        Assert.assertTrue(
                alertPage.getResultText().contains("Giorgi Kuchava"),
                "Alert text was not displayed correctly"
        );
    }
}