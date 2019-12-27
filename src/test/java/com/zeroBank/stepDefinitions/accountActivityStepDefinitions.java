package com.zeroBank.stepDefinitions;

import com.zeroBank.pages.AccountActivity;
import com.zeroBank.utilities.BrowserUtils;
import io.cucumber.java.en.*;
import org.junit.Assert;
import java.util.List;

public class accountActivityStepDefinitions {
    AccountActivity accountActivity = new AccountActivity();

    @Given("user verifies that the default option in the dropdown is {string}")
    public void user_verifies_that_the_default_option_in_the_dropdown_is(String option) {
        Assert.assertEquals(accountActivity.setDropdown(),option);
        System.out.println(accountActivity.setDropdown());
    }

    @Then("user verifies that the dropdown has following options")
    public void user_verifies_that_the_dropdown_has_following_options(List<String> dataTable) {
        System.out.println(accountActivity.getAvailableOptions());
        Assert.assertEquals(dataTable, accountActivity.getAvailableOptions());
    }

    @Given("user verifies that the column names are displayed on Acc Act Page")
    public void user_verifies_that_the_column_names_are_displayed_on_Acc_Act_Page(List<String> dataTable) {
        System.out.println(accountActivity.getColumnNames());
        Assert.assertEquals(accountActivity.getColumnNames(),dataTable);
    }
}
