package com.zeroBank.pages;

import com.zeroBank.utilities.BrowserUtils;
import com.zeroBank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AccountSummary extends BasePage{

    /*
    @FindBy(xpath = "//h2[@class='board-header'][1]")
    public WebElement cashAccountsTitle;

    @FindBy(xpath = "//h2[@class='board-header'][2]")
    public WebElement investmentAccountsTitle;

    @FindBy(xpath = "//h2[@class='board-header'][3]")
    public WebElement creditAccountsTitle;

    @FindBy(xpath = "//h2[@class='board-header'][4]")
    public WebElement loanAccountsTitle;
     */

    @FindBy(xpath = "//div[@class='board'][3]/div/table/thead/tr/th")
    public List<WebElement> columnNames;


    public static String getTitle(String num){
        String path = "//h2[@class='board-header']["+num+"]";
        WebDriverWait wait = new WebDriverWait(Driver.get(), 10);
        WebElement titleElement = Driver.get().findElement(By.xpath(path));
        wait.until(ExpectedConditions.visibilityOf(titleElement));
        return titleElement.getText();
    }

    public List<String> getColumnNames(){
        return BrowserUtils.getListOfString(columnNames);
    }








}
