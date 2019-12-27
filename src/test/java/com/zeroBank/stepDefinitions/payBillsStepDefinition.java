package com.zeroBank.stepDefinitions;

import com.zeroBank.pages.PayBills;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.concurrent.ExecutionException;

public class payBillsStepDefinition {

    PayBills payBills = new PayBills();

    @Given("user verifies the message {string} is displayed.")
    public void user_verifies_the_message_is_displayed(String message) {
        payBills.fillForm("Apple","Loan","100",",19/12/20","19/12/20");
        System.out.println(payBills.verifyMessage());
        Assert.assertEquals(payBills.verifyMessage(),message);

    }

    /*
    @Then("user verifies that the alert {string} is displayed.")
    public void user_verifies_that_the_alert_is_displayed(String alert) throws InterruptedException {
        //payBills.fillForm("Apple","Savings","","");
        //payBills.submit.click();
        //System.out.println(payBills.getAlert());
        //System.out.println(payBills.getAlertAmount("100"));
        Assert.assertEquals(alert,payBills.getAlertAmount("100"));
    }

     */

    @Then("user verifies that the alert {string} is displayed without entering the amount.")
    public void user_verifies_that_the_alert_is_displayed_without_entering_the_amount(String alert) {
        System.out.println("Message :"+payBills.getAlertAmount());
        Assert.assertEquals(alert,payBills.getAlertAmount());

    }

    @Then("user verifies that the alert {string} is displayed without entering the date.")
    public void user_verifies_that_the_alert_is_displayed_without_entering_the_date(String alert) {
        System.out.println("Message :"+payBills.getAlertDate());
        Assert.assertEquals(alert,payBills.getAlertDate());
    }


}
