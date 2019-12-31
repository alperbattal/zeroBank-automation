package com.zeroBank.stepDefinitions;

import com.zeroBank.pages.*;
import io.cucumber.java.en.*;
import org.junit.Assert;


public class RedirectStepDefinitions extends BasePage {

    Redirect redirectElements = new Redirect();

    //Click on savings on Account Summary

    //verify default dropdown "Savings"
    @When("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String defaultOption) {
        System.out.println(redirectElements.getDefaultOption());
        Assert.assertEquals(redirectElements.getDefaultOption(),defaultOption);
    }


    @When("the user clicks on {string} link on the Account Summary page Then the Account Activity page should be displayed")
    public void the_user_clicks_on_link_on_the_Account_Summary_page_Then_the_Account_Activity_page_should_be_displayed(String button) {
        redirectElements.clickButton(button);
    }







}
