package com.techproed.smoketest;

import com.techproed.pages.Homework1_HotelLoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework1_PositiveTest {
    //Go to the application URL
    //Go to the login page
    //Send username password
    //click on login  button
    //find a core object in the default login page
    //and verify if login successful

    //MAKE SURE TO USE PAGE OBJECT MODEL (POM)
    //Page class : LoginPage
    //test class : PositiveTest
        /*
        Test Case:
Create a package: smoketest
Create a class: PositiveTest
Method: positiveLoginTest
When user goes to https://qa-environment.resortsline.com
And click on Log in
And send the username and password
admin
Techproed123!
         */


    //Creating Object
    Homework1_HotelLoginPage hotelLoginPage =new Homework1_HotelLoginPage();

    @Test
    public void positiveTest(){

        //POM AUTOMATION CLASS
        //Go to the application URL
        Driver.getDriver().get(ConfigReader.getProperty("hotel_url"));

        //Go to the login page
        //Send username password
        hotelLoginPage.username.sendKeys(ConfigReader.getProperty("admin_username"));
        hotelLoginPage.password.sendKeys(ConfigReader.getProperty("admin_password"));

        //click on login  button
        hotelLoginPage.login.click();

        //Assertion
        Assert.assertTrue(hotelLoginPage.SystemManagementButton.isDisplayed());


    }

}
