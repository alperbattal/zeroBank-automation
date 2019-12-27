package com.zeroBank.pages;

import com.zeroBank.utilities.BrowserUtils;
import com.zeroBank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PayBills {

    @FindBy(id = "sp_payee")
    public WebElement payee;

    @FindBy(id = "sp_account")
    public WebElement account;

    @FindBy(id="sp_amount")
    public WebElement amount;

    @FindBy(id = "sp_date")
    public WebElement dateInput;

    @FindBy(id = "sp_description")
    public WebElement desc;

    Select select;

    public PayBills(){ PageFactory.initElements(Driver.get(),this);}
    PayBills payBills = new PayBills();


    public void setPayee(String payeeSelected){
        BrowserUtils.waitForClickablility(payee,10);
        select = new Select(payee);
        select.selectByValue(payeeSelected);
    }

    public void setAccount(String accountSelected){
        BrowserUtils.waitForClickablility(account,10);
        select = new Select(account);
        select.selectByValue(accountSelected);
    }

    public void setAmount(String amountWanted){
        BrowserUtils.waitForVisibility(amount,10);
        amount.sendKeys(amountWanted);
    }

    public  void setDate(){
        Format f = new SimpleDateFormat("yy/MM/dd");
        String strDate = f.format(new Date());
        //System.out.println("Current Date = "+strDate);
        dateInput.sendKeys(strDate);
    }

    public void setDesc(String description){
        BrowserUtils.waitForVisibility(desc,10);
        desc.sendKeys(description);
    }

    public void fillForm(String setPayee, String setAccount, String setAmount, String setDescription){
        payBills.setPayee(setPayee);
        payBills.setAccount(setAccount);
        payBills.setAmount(setAmount);
        payBills.setDate();
        payBills.setDesc(setDescription);
    }

}
