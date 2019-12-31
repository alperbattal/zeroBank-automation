package com.zeroBank.stepDefinitions;

import com.zeroBank.pages.AccountActivity;
import com.zeroBank.utilities.BrowserUtils;
import com.zeroBank.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

public class findTransactionsStepDef {

    public findTransactionsStepDef(){ PageFactory.initElements(Driver.get(),this); }

    AccountActivity accountActivity = new AccountActivity();

    @Given("the user accesses the {string} tab")
    public void the_user_accesses_the_tab(String tab) {
       accountActivity.switchTabs(tab);
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String start, String end) {
        accountActivity.inputDate(start,end);
    }

    @When("clicks search")
    public void clicks_search() {
        accountActivity.find.click();
    }


    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String startDate, String endDate) {
        Assert.assertTrue(accountActivity.verifyDateIsValid(startDate,endDate));
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        Assert.assertTrue(accountActivity.verifyDateIsSorted());
    }


}
