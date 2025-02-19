package stepDefinitions;

import io.cucumber.java.en.*;
import models.Product;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.MainPage;
import pages.ProductInfoPage;
import utils.DriverManager;

import java.util.List;

public class MainSteps {
    private WebDriver driver = DriverManager.getDriver();
    private MainPage mainPage = new MainPage(driver);
    private ProductInfoPage productInfoPage = new ProductInfoPage(driver);
    private CartPage cartPage = new CartPage(driver);

    private List<Product> products;
    private Product selectedProduct;

    @Given("I navigate to main page")
    public void iOpenTheLoginPage() {
        driver.get("https://www.demoblaze.com/");
    }

    @Then("Validate Main page title")
    public void iValidateMainLabel() {
        assert mainPage.isTitleDisplayed();
    }

    @When("Get products")
    public void GetProductsTable() {
        products =  mainPage.getProductsTable();
        assert products != null;
    }
    @Then("Validate product table length")
    public void ValidateProductTableLength() {
        assert !products.isEmpty();
    }

    @When("I select category {string}")
    public void selectCategory(String category) {
        assert mainPage.clickOnCategory(category);
    }

    @Then("Validate products content \\(name,price,description)")
    public void validateProductTableLength() {
        for (Product product : products) {
            System.out.println("Validating product: " + product);

            assert !product.getName().isEmpty() : "Error: Product name is empty! Product details: " + product;
            assert !product.getPrice().isEmpty() : "Error: Product price is empty! Product details: " + product;
            assert product.getPriceNumber() > 0 : "Error: Product price number is not greater than 0! Product details: " + product;
            assert !product.getDescription().isEmpty() : "Error: Product description is empty! Product details: " + product;

        }
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    @When("Select random product")
    public void selectRandomProduct() {
        Product randomProduct = mainPage.clickOnRandomProduct(products);
        assert randomProduct != null;
        selectedProduct = randomProduct;
    }
    @Then("Validate product content after selecting")
    public void validateProductContent() {
        assert productInfoPage.validateProductContent(selectedProduct);

    }
    @When("Click 'Add to cart'")
    public void clickAddToCart() {
        assert productInfoPage.addToCart();
    }
    @When("Click 'OK' in popup message")
    public void clickOKInPopupMessage() {
        assert productInfoPage.clickOKAlert();
    }
    @When("Click 'Cart'")
    public void clickCart() {
        assert mainPage.clickCartButton();
    }
    @Then("Validate product added to cart")
    public void validateProductAddedToCart() {
        assert cartPage.validateProductAddedToCart(getSelectedProduct());
    }
}
 