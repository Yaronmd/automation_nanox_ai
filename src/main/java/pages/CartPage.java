package pages;

import models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {


    private By tablePath = By.id("tbodyid");
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean validateProductAddedToCart(Product product) {
        By namePath = By.xpath("//td[text()='"+product.getName()+"']");
        By pricePath = By.xpath("//td[text()='"+product.getPriceNumber()+"']");

        return this.waitForElementPresence(namePath,5).isDisplayed() && this.waitForElementPresence(pricePath,5).isDisplayed();
    }
}
