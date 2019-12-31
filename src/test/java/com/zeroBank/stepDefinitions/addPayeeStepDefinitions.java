package com.zeroBank.stepDefinitions;

import com.zeroBank.pages.PayBills;
import com.zeroBank.utilities.BrowserUtils;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class addPayeeStepDefinitions {
    PayBills payBills = new PayBills();

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(List<Map<String,String>> dataTable) {
        payBills.addNewPayee(dataTable);

    }

    @Then("message {string} should be displayed.")
    public void message_should_be_displayed(String message) {
        BrowserUtils.waitForVisibility(payBills.newPayeeAddedMessage,10);
        System.out.println(payBills.newPayeeAddedMessage.getText());
        Assert.assertEquals(message, payBills.newPayeeAddedMessage.getText());
    }



}
