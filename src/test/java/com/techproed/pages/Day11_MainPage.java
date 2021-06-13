package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Day11_MainPage {

    //Creating constructor
    public Day11_MainPage(){

        PageFactory.initElements(Driver.getDriver(),this); // it will initialize this page object by using this constructor
                                                                // if we do not use this constructor we get NullPointException
    }

    @FindBy(linkText = "Log in")
    public WebElement mainPageLoginLink;







}
