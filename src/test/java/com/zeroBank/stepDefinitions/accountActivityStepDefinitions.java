package com.zeroBank.stepDefinitions;

import com.zeroBank.pages.AccountActivity;
import com.zeroBank.utilities.BrowserUtils;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
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
        //accountActivity.getAvailableOptions();
        System.out.println(accountActivity.getAvailableOptions());
        List<String> list = new ArrayList<>();
        //list.addAll(Arrays.asList(accountActivity.getAvailableOptions()));
        Assert.assertEquals(accountActivity.getAvailableOptions(),dataTable);
    }
}
