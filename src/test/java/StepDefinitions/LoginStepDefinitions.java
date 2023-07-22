package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashboardPage;
import pages.LoginPage;
import setup.Setup;

public class LoginStepDefinitions extends Setup {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    @Given("user visits the websites")
    public void user_visits_the_websites() {
        driver.get("https://www.saucedemo.com");
    }

    @Then("user can view the product page")
    public void user_can_view_the_product_page() {
        dashboardPage = new DashboardPage(driver);
        dashboardPage.userInDashboard();
    }

    @And("browser closes")
    public void browserCloses() {
        driver.quit();
    }

    @When("user enter username {string} and password {string}")
    public void userEnterUsernameAndPassword(String username, String password) {
        loginPage = new LoginPage(driver);
        loginPage.doLogin(username,password);
    }

    @Then("user can't view the product page")
    public void userCanTViewTheProductPage() {
        loginPage = new LoginPage(driver);
        loginPage.assertingErrorMessage();
    }
}
