package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import main.java.pages.BasePage;
import models.Product;


import java.util.List;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Arrays;


public class MainPage extends BasePage {
    private static Logger logger = Logger.getLogger("MainPage");
    private By titleLabel = By.id("nava");

    private By productsTable = By.xpath("//div//*[contains(@class,'card-block')]");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTitleDisplayed(){
        return this.waitForElementPresence(titleLabel,10).isDisplayed();
        
    }

    public List<Product> getProductsTable() {
        List<Product> products = new ArrayList<>();

        List<WebElement>  list_of_product = this.waitForPresenceOfAllElementsLocatedBy(productsTable, 10);
        for (WebElement product : list_of_product) {
            String text = product.getText();
            List<String> temp = Arrays.asList(text.split("\n"));
            if (temp.size() == 3){
                products.add(new Product(temp.get(0),temp.get(1),temp.get(2)));
            }
            else {
                logger.warning("missing details for product: "+ temp);
                return  null;
            }
        }
        
        logger.info(String.valueOf(products));
        return products;

    }
}
