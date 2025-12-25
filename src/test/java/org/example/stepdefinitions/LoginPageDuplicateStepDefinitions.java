package org.example.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.base.BaseTest;
import org.example.pages.LoginPage;
import org.example.pages.LoginPageDuplicate;
import org.testng.Assert;

public class LoginPageDuplicateStepDefinitions extends BaseTest {

    private static final Logger logger = LogManager.getLogger(LoginStepDefinitions.class);
    private LoginPageDuplicate loginPageDuplicate;

    @Given("I navigate to the demoblaze login page")
    public void iNavigateToTheLoginPage() {
        logger.info("Navigating to application page");
        navigateToUrl(configReader.get().getUrl());
        loginPageDuplicate = new LoginPageDuplicate(getDriver());
    }

    @When("I enter the demoblaze username {string}")
    public void iEnterUsername(String username) {
        logger.info("Entering username: {}", username);
        loginPageDuplicate.enterUsername(username);
    }

    @And("I enter the demoblaze password {string}")
    public void iEnterPassword(String password) {
        logger.info("Entering password");
        loginPageDuplicate.enterPassword(password);
    }

    @And("I click on the demoblaze login button")
    public void iClickOnLoginButton() {
        logger.info("Clicking login button");
        loginPageDuplicate.clickLoginButton();
    }

    @Then("I should see demoblaze logout button")
    public void iShouldSeeTheWelcomeMessage() throws InterruptedException {
        logger.info("Verifying welcome message is displayed");
        loginPageDuplicate.verifyLogout();
    }

}
