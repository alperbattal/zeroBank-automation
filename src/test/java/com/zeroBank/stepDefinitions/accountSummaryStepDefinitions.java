package com.zeroBank.stepDefinitions;

import com.zeroBank.pages.AccountSummary;
import com.zeroBank.utilities.BrowserUtils;
import com.zeroBank.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.List;

public class accountSummaryStepDefinitions {

    AccountSummary accountSummary = new AccountSummary();

    @Given("user verifies that the title is {string}")
    public void user_verifies_that_the_title_is(String title) {
        Assert.assertEquals( Driver.get().getTitle(), title);
    }

    @Given("user verifies that the column names are displayed")
    public void user_verifies_that_the_column_names_are_displayed(List<String> dataTable) {
        System.out.println(dataTable);
        BrowserUtils.wait(3);
        Assert.assertEquals(dataTable, accountSummary.getColumnNames());

    }

}
