package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.LoginActions;

public class LoginSteps {
    private LoginActions login;

    @Given("the user enters username {string} and password {string}")
    public void the_user_enters_username_and_password(String username, String password) {
        login = new LoginActions(Hooks.driver);
        login.openSigninPanel();
        login.chooseUsername(username);
        login.choosePassword(password);
    }

    @When("the user logs in")
    public void the_user_logs_in() {
        login.submitLogin();
    }

    @Then("the user should be logged in successfully")
    public void the_user_should_be_logged_in_successfully() {
        Assert.assertTrue(login.verifyOrdersDisplayed(), "Login failed for valid user!");
    }

    @Then("the user should not be logged in")
    public void the_user_should_not_be_logged_in() {
        Assert.assertFalse(login.verifyOrdersDisplayed(), "Invalid user should not log in!");
    }
}
