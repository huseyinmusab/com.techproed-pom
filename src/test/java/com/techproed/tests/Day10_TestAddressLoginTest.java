package com.techproed.tests;

import com.techproed.pages.Day10_TestAddressLoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.annotations.Test;


public class Day10_TestAddressLoginTest {


    //Creating Page class
    Day10_TestAddressLoginPage day10_testAddressLoginPage = new Day10_TestAddressLoginPage();


    @Test
    public void testAddressLoginTest(){
        //TRADITIONAL AUTOMATION CLASS
        //Driver.getDriver().get("http://a.testaddressbook.com/sign_in");
        //Driver.getDriver().findElement(By.id("session_email")).sendKeys("testtechproed@gmail.com");
        //Driver.getDriver().findElement(By.id("session_password")).sendKeys("Test1234!");
        //Driver.getDriver().findElement(By.xpath("//input[@type='submit']")).click();



        //POM AUTOMATION CLASS
        Driver.getDriver().get(ConfigReader.getProperty("test_address_url"));

        day10_testAddressLoginPage.email.sendKeys(ConfigReader.getProperty("test_address_username"));
        day10_testAddressLoginPage.password.sendKeys(ConfigReader.getProperty("test_address_password"));
        day10_testAddressLoginPage.singInButton.click();






    }
}
