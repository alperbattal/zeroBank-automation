package com.zeroBank.pages;

import com.zeroBank.utilities.BrowserUtils;
import com.zeroBank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {

    // //div[@class='offset2 span8']/h2


    @FindBy(id = "account_summary_tab")
    public WebElement accountSummary;

    @FindBy(id = "account_activity_tab")
    public WebElement accountActivity;

    @FindBy(id = "transfer_funds_tab")
    public WebElement transferFunds;

    @FindBy(id = "pay_bills_tab")
    public WebElement payBills;

    @FindBy(id = "money_map_tab")
    public WebElement myMoneyMap;

    @FindBy(id = "online_statements_tab")
    public WebElement onlineStatements;

    @FindBy(id = "searchTerm")
    public WebElement search;

    @FindBy(xpath = "//*[@class='dropdown'][1]")
    public WebElement settings;

    @FindBy(xpath = "//*[@class='dropdown'][2]")
    public WebElement userprofile;


    public BasePage(){ PageFactory.initElements(Driver.get(), this); }


    public void navigateTo(String module){
        WebDriverWait wait = new WebDriverWait(Driver.get(),10);
        switch ( module ){
            case "Account Summary":
                wait.until(ExpectedConditions.elementToBeClickable(accountSummary));
                accountSummary.click();
                break;

            case "Account Activity":
                wait.until(ExpectedConditions.elementToBeClickable(accountActivity));
                accountActivity.click();
                break;

            case "Transfer Funds":
                wait.until(ExpectedConditions.elementToBeClickable(transferFunds));
                transferFunds.click();
                break;

            case "Pay Bills":
                wait.until(ExpectedConditions.elementToBeClickable(payBills));
                payBills.click();
                break;

            case "My Money Map":
                wait.until(ExpectedConditions.elementToBeClickable(myMoneyMap));
                myMoneyMap.click();
                break;

            case "Online Statements":
                wait.until(ExpectedConditions.elementToBeClickable(onlineStatements));
                onlineStatements.click();
                break;

            default:
                System.out.println("Invalid module name");

        }

    }


}

