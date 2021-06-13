package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homework1_HotelLoginPage {

    //Creating Constructor
    public Homework1_HotelLoginPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    //Locating Elements
    @FindBy(id="UserName")
    public WebElement username;

    @FindBy(id="Password")
    public WebElement password;

    @FindBy(id="btnSubmit")
    public WebElement login;

    @FindBy(xpath = "(//span[@class='title'])[1]")
    public WebElement SystemManagementButton;


}
