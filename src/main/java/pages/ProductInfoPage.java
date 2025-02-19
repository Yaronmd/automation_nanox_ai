package pages;

import models.Product;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Objects;
import java.util.logging.Logger;

public class ProductInfoPage extends BasePage {
    private static Logger logger = Logger.getLogger("ProductInfoPage");

    private By addToCartButton = By.xpath("//*[@class='btn btn-success btn-lg']");
    private By okButton = By.xpath("//button[text()='OK']");
    public ProductInfoPage(WebDriver driver) {
        super(driver);
    }
    public boolean addToCart() {
        try{
            this.waitForElementPresence(addToCartButton,5).click();
        } catch (Exception e) {
           logger.warning("Failed to click add to cart"+e.getMessage());
           return false;
        }
            return true;
        }

    public boolean clickOKAlert(){
        try{
            Alert alert = this.waitForAlertPresent(5);
            alert.accept();
            return true;
        } catch (Exception e) {
            logger.warning("Failed to click OK Alert"+e.getMessage());
            return false;
        }
    }



    public boolean validateProductContent(Product product) {
        try {
            By titlePath = By.xpath("//*[@class='name' and text()='" + product.getName() + "']");
            By pricePath = By.xpath("//*[@class='price-container' and text()='" + product.getPrice() + "']");
            By descriptionPath = By.id("more-information");


            boolean isTitleDisplayed = this.waitForElementPresence(titlePath, 5).isDisplayed();
            boolean isPriceDisplayed = this.waitForElementPresence(pricePath, 5).isDisplayed();
            String DescriptionDisplayed = this.waitForElementPresence(descriptionPath, 5).getText();

            return isTitleDisplayed && isPriceDisplayed && DescriptionDisplayed.contains(product.getDescription());
        } catch (Exception e) {
            System.out.println("Validation failed for product: " + product);
            e.printStackTrace();
            return false;
        }
    }
}
