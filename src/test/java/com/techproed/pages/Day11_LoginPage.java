package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Day11_LoginPage {

    public Day11_LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }


    @FindBy(id = "UserName")
    public WebElement username;

    @FindBy(id= "Password")
    public WebElement password;

    @FindBy(id = "btnSubmit")
    public WebElement loginButton;

    @FindBy(id = "divMessageResult")
    public WebElement errorMessage;






}
