package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class DriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {

            // option to use local chromedriver
//            System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
//            driver = new ChromeDriver();
//            driver.manage().window().maximize();


            // selenium hub option
            try {
                // Set up the WebDriver for the remote Selenium Grid
                String hubURL = "http://localhost:4444/wd/hub"; // Replace with your Hub's IP

                // ChromeOptions (Instead of DesiredCapabilities)
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless"); // Optional: Run in headless mode

                // Create the Remote WebDriver
                driver = new RemoteWebDriver(new URL(hubURL), options);
                driver.manage().window().maximize(); // Maximize the browser window
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
