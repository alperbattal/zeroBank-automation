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
       //accountActivity.switchTabs(tab);
        BrowserUtils.switchTabs(tab);
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String start, String end) {
        accountActivity.inputDate(start,end);
    }

    @When("clicks search")
    public void clicks_search() {
        BrowserUtils.waitForClickablility(accountActivity.find,10);
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

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String date) {
        Assert.assertTrue(accountActivity.datesNotContained(date));
    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String desc) {
        BrowserUtils.waitForVisibility(accountActivity.descriptions,10);
        accountActivity.descriptions.clear();
        accountActivity.descriptions.sendKeys(desc);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String string) {
        Assert.assertTrue(accountActivity.verifyDescriptions(string));
    }


    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String string) {
        Assert.assertFalse(accountActivity.verifyDescriptions(string));
    }


    //------------

    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() {
        BrowserUtils.waitForPageToLoad(10);
        //BrowserUtils.waitForClickablility(accountActivity.find,10);
        System.out.println("-----------------");
        System.out.println("Deposit\tNumber of rows: "+accountActivity.depositRow.size());
        Assert.assertTrue(!accountActivity.depositRow.isEmpty());
        System.out.println("-----------------");
    }

    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() {
        System.out.println("-----------------");
        System.out.println("Withdrawal\tNumber of rows :"+accountActivity.withdrawalRow.size());
        Assert.assertTrue(!accountActivity.withdrawalRow.isEmpty());
        System.out.println("-----------------");
    }

    @When("user selects type {string}")
    public void user_selects_type(String value) {
        accountActivity.getDropdownValue(value);

    }

    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() {
        Assert.assertFalse(accountActivity.withdrawalRow.isEmpty());
    }

    @Then("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_Deposit() {
        Assert.assertFalse(accountActivity.depositRow.isEmpty());
    }






}
