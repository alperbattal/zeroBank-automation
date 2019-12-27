package com.zeroBank.pages;

import com.zeroBank.utilities.BrowserUtils;
import com.zeroBank.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends BasePage{

    @FindBy(id = "signin_button")
    public WebElement signInButton;

    @FindBy(id = "user_login")
    public WebElement userNameInput;

    @FindBy(id = "user_password")
    public WebElement passwordInput;

    @FindBy(id = "user_remember_me")
    public WebElement rememberMe;

    @FindBy(name = "submit")
    public WebElement submitButton;

    @FindBy(css = "a[tabindex='5']")
    public WebElement forgotButton;

    @FindBy(css = "div[class='alert alert-error']")
    public WebElement message;


    public LoginPage(){ PageFactory.initElements(Driver.get(), this); }



    public void login(String username, String password){

        BrowserUtils.waitForPageToLoad(10);
        WebDriverWait wait = new WebDriverWait(Driver.get(), 10);
        BrowserUtils.waitForClickablility(signInButton,10);
        signInButton.click();

        //username input
        wait.until(ExpectedConditions.visibilityOf(userNameInput));
        userNameInput.sendKeys(username);

        //password input
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.sendKeys(password, Keys.ENTER);

    }

}
