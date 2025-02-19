package stepDefinitions;

import io.cucumber.java.en.*;
import models.Product;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import utils.DriverManager;

import java.util.List;

public class MainSteps {
    private WebDriver driver = DriverManager.getDriver();
    private MainPage mainPage = new MainPage(driver);

    private List<Product> products;


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
    
}
 