package com.zeroBank.stepDefinitions;

import com.zeroBank.pages.AccountSummary;
import com.zeroBank.pages.LoginPage;
import com.zeroBank.utilities.ConfigurationReader;
import com.zeroBank.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class loginStepDefinitions {
    LoginPage loginPage = new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.getProperty("url"));
        System.out.println("I am on the login page");
    }

    @Then("user is able to login with valid credentials")
    public void user_is_able_to_login_with_valid_credentials() {
      loginPage.login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
    }

    @Given("user is not able to login with {string} and {string}")
    public void user_is_not_able_to_login_with_and(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("error message {string} should be displayed")
    public void error_message_should_be_displayed(String expectedMessage) {
        Assert.assertEquals(expectedMessage, "Login and/or password are wrong.");
    }

    @Then("user verifies that the number {string} title is {string}")
    public void user_verifies_that_the_number_title_is(String number, String title) {
        Assert.assertEquals(AccountSummary.getTitle(number), title);
        System.out.println(AccountSummary.getTitle(number));

    }


    @Given("user navigates to the {string} page")
    public void user_navigates_to_the_page(String module) {
        loginPage.navigateTo(module);
        System.out.println("Page : "+ module);
    }

}
