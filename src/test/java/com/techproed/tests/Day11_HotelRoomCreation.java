package com.techproed.tests;

import com.techproed.pages.Day11_DefaultPage;
import com.techproed.pages.Day11_LoginPage;
import com.techproed.pages.Day12_HotelRoomPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class Day11_HotelRoomCreation {

    Day12_HotelRoomPage hotelRoomPage;
    Day11_LoginPage loginPage;
    Day11_DefaultPage defaultPage;

    //Login the application
    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get(ConfigReader.getProperty("application_url_login"));
        loginPage=new Day11_LoginPage();
        loginPage.username.sendKeys(ConfigReader.getProperty("admin_username"));
        loginPage.password.sendKeys(ConfigReader.getProperty("admin_password"));
        loginPage.loginButton.click();

        defaultPage = new Day11_DefaultPage();
        Assert.assertTrue(defaultPage.userAddButton.isDisplayed()); //checking if the login is succesful

    }


        @Test
        public void HotelRoomCreation(){

        //Click on Hotel Management
        defaultPage.hotelManagement.click();

         //Click on Hotel Rooms
        defaultPage.hotelRooms.click();

        //Click on Add Hotel Room
        hotelRoomPage =new Day12_HotelRoomPage();
        hotelRoomPage.addHotelRoomButton.click();

        //Enter All required fields
            Select select = new Select(hotelRoomPage.hotelIdDropdown); //To handle  dropdown element
            select.selectByIndex(2);                               //select 2. option(Paradise Hotel)

            hotelRoomPage.code.sendKeys("discount code");
            hotelRoomPage.name.sendKeys("test name");
            hotelRoomPage.location.sendKeys("Dallas");
            hotelRoomPage.description.sendKeys("This is the best room for special guests");
            //To enter a price, we can send keys
            hotelRoomPage.price.sendKeys("1000");


            Select roomDropdown=new Select( hotelRoomPage.roomTypeDropdown);
            roomDropdown.selectByVisibleText("Studio");

            hotelRoomPage.maxAdultCount.sendKeys("2");
            hotelRoomPage.maxChildCount.sendKeys("5");
            hotelRoomPage.isApprovedCheckbox.click();
            //Click Save

            hotelRoomPage.saveButton.click();

            //Verify the message: HotelRoom was inserted successfully
            //HotelRoom was inserted successfully==> may be we consider this is a JS alert but iyt is not,
            //it is just a pop-up on HotelRoomPage  and we can locate easily, if we can not, we have to first switch to Alert and then try to
            //automate


            //1) HARD WAIT
            //Thread.sleep(2000);  //===> WE HAVE TO USE IT HERE OTHERWISE IT GIVES ERROR BECAUSE OF SYCHRONAZITION PROBLEM,
            // java.lang.AssertionError:
            //Expected :HotelRoom was inserted successfully
            //Actual   :

            //2)EXPLICIT WAIT
            WebDriverWait wait =new WebDriverWait(Driver.getDriver(),10);
            WebElement popUpElement = wait.until(ExpectedConditions.visibilityOf(hotelRoomPage.popUp));
            Assert.assertEquals(popUpElement.getText(),"HotelRoom was inserted successfully");


            //Click OK
            hotelRoomPage.OkButton.click();












    }



}
