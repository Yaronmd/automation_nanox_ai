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


}
 