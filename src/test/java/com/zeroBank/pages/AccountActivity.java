package com.zeroBank.pages;

import com.zeroBank.utilities.BrowserUtils;
import com.zeroBank.utilities.Driver;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccountActivity {


    /*
    @FindBy(id = "aa_accountId")
    public WebElement dropdown;
     */

    @FindBy(xpath = "//table/thead/tr/th")
    public List<WebElement> columnNames;

    @FindBy(xpath = "//select/option")
    public List<WebElement> dropdownOptions;

    WebElement dropdown = Driver.get().findElement(By.id("aa_accountId"));
    Select select = new Select(dropdown);

    public String setDropdown(){
        return select.getFirstSelectedOption().getText();
    }
    public List<String> getColumnNames(){
        return BrowserUtils.getListOfString(columnNames);
    }

    public List<String> getAvailableOptions(){
        List<WebElement> list = Driver.get().findElements(By.id("aa_accountId"));
       /* List<String> actualList = new ArrayList<>();
        actualList = BrowserUtils.getListOfString(list);

        */
        return BrowserUtils.getListOfString(list);

    }





}
