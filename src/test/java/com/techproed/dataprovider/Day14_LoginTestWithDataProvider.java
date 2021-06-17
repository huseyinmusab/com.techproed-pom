package com.techproed.dataprovider;

import com.techproed.pages.Day11_DefaultPage;
import com.techproed.pages.Day11_LoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day14_LoginTestWithDataProvider {

    @DataProvider
    public Object[][]getData(){
        String[][] managerProfile ={
                {"manager","Manager1!"},
                {"manager2","Manager2!"},
                {"manager3","Manager3!"}
        };
        return managerProfile;
    }

    Day11_LoginPage loginPage;
    Day11_DefaultPage defaultPage;

    public void setUp(){
        loginPage=new Day11_LoginPage();
        defaultPage=new Day11_DefaultPage();
        Driver.getDriver().get(ConfigReader.getProperty("application_url_login"));
    }

    @Test(dataProvider = "getData")
    public void managerLoginTest(String userName,String password){
        setUp();
        loginPage.username.sendKeys(userName);
        loginPage.password.sendKeys(password);
        loginPage.loginButton.click();
        Assert.assertEquals(defaultPage.userID.getText(),userName);
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
    //I did not use any loop to get the data one by one because dataprovider does it for me already


}
