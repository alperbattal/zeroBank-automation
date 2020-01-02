package com.zeroBank.pages;

import com.zeroBank.utilities.BrowserUtils;
import com.zeroBank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class PayBills {

    public PayBills() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "sp_payee")
    public WebElement payee;

    @FindBy(id = "sp_account")
    public WebElement account;

    @FindBy(id = "sp_amount")
    public WebElement amount;

    @FindBy(id = "sp_date")
    public WebElement dateInput;

    @FindBy(id = "sp_description")
    public WebElement desc;

    @FindBy(id = "alert_content")
    public WebElement message;

    @FindBy(id = "pay_saved_payees")
    public WebElement submit;

    @FindBy(id = "np_new_payee_name")
    public WebElement newPayeeName;

    @FindBy(id = "np_new_payee_address")
    public WebElement newPayeeAddress;

    @FindBy(id = "np_new_payee_account")
    public WebElement newPayeeAccount;

    @FindBy(id = "np_new_payee_details")
    public WebElement newPayeeDetails;

    @FindBy(id = "add_new_payee")
    public WebElement addNewPayeeButton;

    @FindBy(id = "alert_content")
    public WebElement newPayeeAddedMessage;

    @FindBy(id = "pc_currency")
    public WebElement currency;

    @FindBy(id = "purchase_cash")
    public WebElement foreignCurrencyCashButton;


    Select select;

    public void setPayee(String payeeSelected) {
        BrowserUtils.waitForClickablility(payee, 10);
        select = new Select(payee);
        select.selectByVisibleText(payeeSelected);
    }

    public void setAccount(String accountSelected) {
        BrowserUtils.waitForClickablility(account, 10);
        select = new Select(account);
        select.selectByVisibleText(accountSelected);
    }

    public void setAmount(String amountWanted) {
        BrowserUtils.waitForVisibility(amount, 10);
        amount.sendKeys(amountWanted);
    }

    public void setDate(String date) {
       /* Format f = new SimpleDateFormat("yy/MM/dd");
        String strDate = f.format(new Date());
        //System.out.println("Current Date = "+strDate);

        */
        dateInput.sendKeys(date);
    }

    public void setDesc(String description) {
        BrowserUtils.waitForVisibility(desc, 10);
        desc.sendKeys(description);
    }

    public String verifyMessage() {
        return message.getText();
    }

    public void fillForm(String setPayee, String setAccount, String setAmount, String date, String setDescription) {
        setPayee(setPayee);
        setAccount(setAccount);
        setAmount(setAmount);
        setDate(date);
        setDesc(setDescription);
        BrowserUtils.waitForClickablility(submit, 10);
        submit.click();
    }


    JavascriptExecutor js = (JavascriptExecutor) Driver.get();

    public String getAlertAmount() {
        BrowserUtils.waitForVisibility(amount, 3);
        return (String) js.executeScript("return arguments[0].validationMessage;", amount);
    }

    public String getAlertDate() {
        BrowserUtils.waitForVisibility(dateInput, 3);
        return (String) js.executeScript("return arguments[0].validationMessage;", dateInput);
    }

    /*
    public void user_adds_new_car_information(List<Map<String, String>> dataTable) {
        //as many rows of data you have, it will create cars
        //wait
        createCarPage.waitUntilLoaderMaskDisappear();
        System.out.println(dataTable);
        int row = 1;
        for (Map<String, String> map : dataTable) {
            createCarPage.licensePlateElement.sendKeys(map.get("License Plate"));
            createCarPage.driverElement.sendKeys(map.get("Driver"));
            createCarPage.locationElement.sendKeys(map.get("Location"));
            createCarPage.modelYearElement.sendKeys(map.get("Model Year"));
            createCarPage.colorElement.sendKeys(map.get("Color"));
            BrowserUtils.wait(2);//for demo

            if (row == dataTable.size()) {
                //if it's a last row - click save and close
                createCarPage.clickSaveAndClose();
            } else {
                //if it's not the last row - click save and add new
                createCarPage.clickSaveAndAddNew();
            }

            BrowserUtils.wait(2);//for demo
            row++;
        }
    }
     */

    public void addNewPayee(List<Map<String, String>> dataTable) {
        System.out.println(dataTable);
        int row = 1;

        for (Map<String,String > map : dataTable){
            BrowserUtils.waitForVisibility(newPayeeName,10);
            newPayeeName.sendKeys(map.get("Payee Name"));
            newPayeeAddress.sendKeys(map.get("Payee Address"));
            newPayeeAccount.sendKeys(map.get("Account"));
            newPayeeDetails.sendKeys(map.get("Payee Details"));
            addNewPayeeButton.click();
        }
    }

    public List<String> getCurrencyOptions(){
        BrowserUtils.waitForClickablility(currency,10);
        select = new Select(currency);
        return BrowserUtils.getListOfString(select.getOptions().subList(1,select.getOptions().size()));
    }

}



