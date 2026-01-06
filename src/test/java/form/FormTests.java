package form;
import base.TestBase;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PracticeFormPage;
import utils.DriverFactory;

@Epic("Forms")
@Feature("Practice Form")
public class FormTests extends TestBase {

    @Test
    @Story("Submit valid form")
    @Severity(SeverityLevel.NORMAL)
    public void submitFormTest() {
        Allure.step("Open practice from page");
        DriverFactory.getDriver().get("https://demoqa.com/automation-practice-form");

        PracticeFormPage form = new PracticeFormPage(DriverFactory.getDriver());
        Allure.step("Fill user details");
        form.fillName("Giorgi", "Kuchava");
        form.setEmail("giorgi.kuchava@example.com");
        form.selectGender("Male");
        form.setMobile("5991234561");
        form.setBirthDate("May", "2000", "15");
        form.setSubject("Maths");
        form.setAddress("Tbilisi, Georgia");
        form.selectStateAndCity("Haryana", "Karnal");
        Allure.step("Submit form");
        form.submit();

        Assert.assertTrue(
                form.getResultText().contains("Giorgi Kuchava"),
                "Form submission failed!"
        );
    }
}