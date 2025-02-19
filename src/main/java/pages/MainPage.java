package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import models.Product;


import java.util.List;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Arrays;


public class MainPage extends BasePage {
    private static Logger logger = Logger.getLogger("MainPage");
    private By titleLabel = By.id("nava");
    private By productsTable = By.xpath("//div//*[contains(@class,'card-block')]");

    private By phoneCategoryButton = By.xpath("//a[text()='Phones']");
    private By laptopCategoryButton = By.xpath("//a[text()='Laptops']");
    private By monitorsCategoryButton =  By.xpath("//a[text()='Monitors']");


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTitleDisplayed(){
        return this.waitForElementPresence(titleLabel,10).isDisplayed();
        
    }

    public boolean clickOnCategory(String category){

            By selectedCategory;

            switch (category) {
                case "Laptops":
                    selectedCategory = laptopCategoryButton;
                    break;
                case "Phones":
                    selectedCategory = phoneCategoryButton;
                    break;
                case "Monitors":
                    selectedCategory = monitorsCategoryButton;
                    break;
                default:
                    return false;
            }

            this.clickWhenReady(selectedCategory,10);
            return true;
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
                return null;
            }
        }
        
        logger.info(String.valueOf(products));
        return products;

    }

}
