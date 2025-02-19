
package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.logging.Logger;

public class BasePage {
    protected WebDriver driver;
    private static Logger logger = Logger.getLogger("BasePage");

    // Constructor to initialize WebDriver
    public BasePage(WebDriver driver) {
        this.driver = driver;
        
        

    }

    // Explicit wait for element to be clickable and then click
    public void clickWhenReady(By locator, Integer timeout) {
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
            logger.info("Success to click on "+ String.valueOf(locator));
        }catch (Exception e){
            logger.warning("Failed to click when ready: "+e.getMessage());
            throw e;
        }    
        
    }

    // Wait for visibility of element
    public WebElement waitForElementVisibility(By locator, Integer timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Wait for an element to be present on the DOM
    public WebElement waitForElementPresence(By locator, Integer timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public List<WebElement> waitForPresenceOfAllElementsLocatedBy(By locator, Integer timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }
   
    /**
     * Sends keys to a specified element on the page.
     * 
     * @param locator The locator used to find the element.
     * @param keys The keys to send to the element.
     * @param timeout The timeout in seconds to wait for the element to be present. If null, defaults to 5 seconds.
     * @param clearField If true, clears the field before sending the keys. Defaults to true if null.
     */
    public void sendKeys(By locator,String keys, Integer timeout,Boolean clearField) {
        if(timeout == null){
            timeout = 5;
        }
        if (clearField == null){
            clearField = false;
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        if (clearField){
            element.clear();
        }
        element.sendKeys(keys);
    }




}
