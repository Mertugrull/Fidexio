package com.cydeo.fidexio.pages;

import com.cydeo.fidexio.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){

        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(id = "login")
    public WebElement username;

    @FindBy(id="password")
    public WebElement password;

    @FindBy(xpath = "//button[.='Log in']")
    public WebElement loginButton;

    @FindBy(xpath = "//p[contains(@class,'alert-danger')]")
    public WebElement wrongMessage;

    @FindBy(xpath = "//input[@required='required']")
    public WebElement requiredMessage;

}
