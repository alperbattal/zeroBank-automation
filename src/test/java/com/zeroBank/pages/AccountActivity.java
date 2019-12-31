package com.zeroBank.pages;

import com.zeroBank.utilities.BrowserUtils;
import com.zeroBank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class AccountActivity extends BasePage{

    @FindBy(id = "aa_accountId")
    public WebElement dropdown;

    @FindBy(xpath = "//table/thead/tr/th")
    public List<WebElement> columnNames;

    @FindBy(xpath = "//select/option")
    public List<WebElement> dropdownOptions;

    //WebElement dropdown = Driver.get().findElement(By.id("aa_accountId"));
    Select select;

    @FindBy(linkText = "Find Transactions")
    public WebElement findTransTab;

    @FindBy(id = "aa_fromDate")
    public WebElement startDate;

    @FindBy(id = "aa_toDate")
    public WebElement endDate;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement find;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']/table/tbody/tr/td[1]")
    public List<WebElement> dateRows;


    public String setDropdown() {
        BrowserUtils.waitForClickablility(dropdown,10);
        select = new Select(dropdown);
        return select.getFirstSelectedOption().getText();
    }

    public List<String> getColumnNames() {
        return BrowserUtils.getListOfString(columnNames);
    }

    public List<String> getAvailableOptions() {
        List<WebElement> list = Driver.get().findElements(By.tagName("option"));
        return BrowserUtils.getListOfString(list);
    }


    public void switchTabs(String tab){
        BrowserUtils.waitForClickablility(Driver.get().findElement(By.linkText(tab)),10);
        Driver.get().findElement(By.linkText(tab)).click();
    }

    public void inputDate(String start, String end){
        BrowserUtils.waitForVisibility(startDate,10);
        startDate.sendKeys(start);
        BrowserUtils.waitForVisibility(endDate,10);
        endDate.sendKeys(end);
    }

    public boolean verifyDateIsValid(String from, String till) {
        boolean valid = true;
        BrowserUtils.wait(4);
        List<WebElement> dates = Driver.get().findElements(By.xpath("//div[@id='filtered_transactions_for_account']/table/tbody/tr/td[1]"));
       // BrowserUtils.getListOfString(dates);
        LocalDate fromDateObj = LocalDate.from(DateTimeFormatter.ofPattern("yyyy-MM-dd").parse(from));
        LocalDate tillDateObj = LocalDate.from(DateTimeFormatter.ofPattern("yyyy-MM-dd").parse(till));

        for (WebElement each : dates){
            LocalDate dateToCheckObj = LocalDate.from(DateTimeFormatter.ofPattern("yyyy-MM-dd").parse(each.getText()));
            System.out.println(each.getText());
            if (!dateToCheckObj.isAfter(fromDateObj) && dateToCheckObj.isBefore(tillDateObj)){
                valid=false;
            }
            System.out.println(dateToCheckObj.isAfter(fromDateObj) && dateToCheckObj.isBefore(tillDateObj));
        }
        return valid;
    }

    public boolean verifyDateIsSorted(){
        boolean sorted=false;
        BrowserUtils.wait(6);
        List<WebElement> dates = Driver.get().findElements(By.xpath("//div[@id='filtered_transactions_for_account']/table/tbody/tr/td[1]"));
        for (WebElement each : dates){
            System.out.println(each.getText());
            LocalDate first = LocalDate.from(DateTimeFormatter.ofPattern("yyyy-MM-dd").parse(each.getText()));
            for (WebElement eacht : dates){
                LocalDate second = LocalDate.from(DateTimeFormatter.ofPattern("yyyy-MM-dd").parse(each.getText()));
                if (first.isBefore(second) || first.equals(second)){
                    sorted = true;
                }
            }

        }
        return sorted;
    }

}
