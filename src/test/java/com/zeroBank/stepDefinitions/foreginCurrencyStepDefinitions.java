package com.zeroBank.stepDefinitions;

import com.zeroBank.pages.PayBills;
import com.zeroBank.utilities.BrowserUtils;
import com.zeroBank.utilities.Driver;
import io.cucumber.java.cs.Ale;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class foreginCurrencyStepDefinitions {

    PayBills payBills = new PayBills();
    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> dataTable) {
        System.out.println("Expected: "+dataTable);
        System.out.println("Actual: "+payBills.getCurrencyOptions());
        Assert.assertEquals(dataTable, payBills.getCurrencyOptions());
    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        BrowserUtils.waitForClickablility(payBills.foreignCurrencyCashButton,10);
        payBills.foreignCurrencyCashButton.click();
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed(String message) {
        WebDriverWait wait = new WebDriverWait(Driver.get(),10);
        Alert alert = Driver.get().switchTo().alert();
        wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(alert.getText(), message);
    }
}
