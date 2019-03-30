package com.aqacourses.android.base;

import com.aqacourses.android.pages.HomePage;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Marina on 28.03.2019.
 */
public class BaseTest {

    // Instance of WebDriver
    private WebDriver driver;
    private WebDriverWait wait;

    // Logger
    private Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    // Rule
    @Rule
    public RunTestRule runTestRule = new RunTestRule(this);

    /**
     * Constructor
     */
    public BaseTest() {

    }

    /**
     * Open Application
     *
     * @return
     * @throws MalformedURLException
     */
    public HomePage openApplication() throws MalformedURLException {
        // Initialize application
        File app = new File("src/main/resources/Rozetka_v3.11.0_apkpure.com.apk");

        // Capabilities
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        // Set device type
        desiredCapabilities.setCapability("device", "Android");

        // Set browser type. Leave it empty if it's app
        desiredCapabilities.setCapability(CapabilityType.BROWSER_NAME, "");

        // Set path to app file
        desiredCapabilities.setCapability("app", app.getAbsolutePath());

        // Set name of the device
        desiredCapabilities.setCapability("deviceName", "MI 5");

        // Set platform name
        desiredCapabilities.setCapability("platformName", "Android");

        // Set package of the app
        desiredCapabilities.setCapability("appPackage", "ua.com.rozetka.shop");

        // Set activity of the app
        desiredCapabilities.setCapability("appActivity", "ua.com.rozetka.shop.ui.InitActivity");

        // Initialize driver
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

        wait = new WebDriverWait(driver, 10);

        // Initialize WebElements
        PageFactory.initElements(driver, this);

        return new HomePage(this);
    }


    /**
     * Return instance of Driver
     *
     * @return WebDriver
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Close application with driver.quit()
     */
    public void closeApplication() {
        driver.quit();
    }

    /**
     * Wait till element is visible
     *
     * @param element
     */
    public void waitTillElementIsVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Write down info message
     *
     * @param message
     */
    public void log(String message) {
        logger.info(message);
    }

    /**
     * Write down error message
     *
     * @param error
     */
    public void error(String error) {
        logger.error(error);
    }

    /**
     * Get current date and time
     *
     * @return current date and time
     */
    public String getDateTime() {
        return new SimpleDateFormat("YYYY-MM-dd_HH-mm-ss").format(Calendar.getInstance().getTime());
    }

}
