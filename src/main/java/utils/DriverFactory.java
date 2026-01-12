package utils;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.time.Duration;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver() {

        return driver;

    }

    public static void initDriver() {

        SafariOptions options = new SafariOptions();
        options.setCapability("safari:usePrivateBrowsing", true);
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    public static void quitDriver() {

        if (driver != null) {

            driver.quit();

            driver = null;

        }

    }

}