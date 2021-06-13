package com.techproed.smoketest;

import com.techproed.pages.Day11_LoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day11_NegativeTest {


    Day11_LoginPage loginPage;

    @BeforeMethod
    public void setUp(){
        loginPage=new Day11_LoginPage();
        Driver.getDriver().get(ConfigReader.getProperty("application_url_login"));
        //Now we are on the login page

    }


    @Test
    public void invalidPassword(){

        //When user enters wrong password

        loginPage.username.sendKeys("admin");
        loginPage.password.sendKeys("Techproed123");
        loginPage.loginButton.click();

        //Then verify the error message includes “Wrong password”

        //POM model (Soft Coding)
        // Why we need to use pom here? Because i can use the same error Message again for another test, thats why i need
        //pom here to REUSABLE
        String errorMessageText = loginPage.errorMessage.getText();
        System.out.println(errorMessageText);
        Assert.assertTrue(errorMessageText.contains("Wrong password"));

        //TRADITIONAL(hard coding)
        //String errorMessageText = Driver.getDriver().findElement(By.id("divMessageResult")).getText();
        //System.out.println(errorMessageText);
        //Assert.assertTrue(errorMessageText.contains("Wrong password"));

    }

    @Test
    public void invalidId(){
        //invalidID()
        //When user enters wrong id but correct pass
        //Then verify the error message includes “Try again please”
        //Test Data:
        //Url:  https://qa-environment.resortsline.com/Account/Logon
        //user: manager
        //pw: Techproed123!

        loginPage.username.sendKeys("manager");       // id wrong
        loginPage.password.sendKeys("Techproed123!"); //password true
        loginPage.loginButton.click();

        String errorMessageText = loginPage.errorMessage.getText();
        System.out.println(errorMessageText);
        Assert.assertTrue(errorMessageText.contains("Try again please"));

    }

    @Test
    public void invalidIdAndPassword(){
        //invalidIDAndPassword()
        //When user enters wrong id and wrong password
        //Then verify the error message includes “Username or password is incorrect, please correct them and try again”
        //Test Data:
        //Url:  https://qa-environment.resortsline.com/Account/Logon
        //user: manager
        //pw: Manage!

        loginPage.username.sendKeys("manager");       // id wrong
        loginPage.password.sendKeys("Manage!"); //password true
        loginPage.loginButton.click();

        String errorMessageText = loginPage.errorMessage.getText();
        System.out.println(errorMessageText);
        Assert.assertTrue(errorMessageText.contains("Username or password is incorrect, please correct them and try again"));




    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }




}
