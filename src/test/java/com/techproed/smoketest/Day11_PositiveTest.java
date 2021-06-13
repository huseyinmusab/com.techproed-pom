package com.techproed.smoketest;

import com.techproed.pages.Day11_DefaultPage;
import com.techproed.pages.Day11_LoginPage;
import com.techproed.pages.Day11_MainPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day11_PositiveTest {

    //Day11_MainPage day11_mainPage;=new Day11_MainPage();===> this style is also OK!
    Day11_MainPage mainPage; //to use it in class level as class instance is useful,whenw=ever i need i use this object everywhere

    Day11_LoginPage loginPage; //to use it in class level as class instance is useful,whenw=ever i need i use this object everywhere

    Day11_DefaultPage defaultPage; //to use it in class level as class instance is useful,whenw=ever i need i use this object everywhere



    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get(ConfigReader.getProperty("application_url"));
    }


    @Test
    public void positiveTest(){

        //Go to the login page
        mainPage =new Day11_MainPage();
        mainPage.mainPageLoginLink.click();

        //Send username and password
        loginPage =new Day11_LoginPage();
        loginPage.username.sendKeys(ConfigReader.getProperty("admin_username"));
        loginPage.password.sendKeys(ConfigReader.getProperty("admin_password"));
        loginPage.loginButton.click();


        //find a core object in the default login page and verify if the log in successful or not

        //WebElement addUserButton = Driver.getDriver().findElement(By.xpath("//span[@class='hidden-480']"));
        //Assert.assertTrue(addUserButton.isDisplayed());
        defaultPage = new Day11_DefaultPage();
        Assert.assertTrue(defaultPage.userAddButton.isDisplayed());





    }


}
