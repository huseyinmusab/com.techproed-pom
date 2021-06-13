package com.techproed.tests;

import com.techproed.pages.Day11_DefaultPage;
import com.techproed.pages.Day11_LoginPage;
import com.techproed.pages.Day12_HotelRoomPage;
import com.techproed.pages.Homework_HotelReservationPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Homework_HotelReservationCreation {

//Test Case:
//Log in the application with admin id
//Click on Hotel Management
//Click on Room reservations
//Click on Add Room Reservation
//Enter All required fields
//Click Save
//Verify the message: RoomReservation was inserted successfully
//Click OK
    //NOTE: JUST DO HAPPY PATH
    ///OPTIONAL: AUTOMATE ONE NEGATIVE SCENARIO

    Homework_HotelReservationPage hotelReservationPage;
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
    public void HotelReservationCreation(){
        //Click on Hotel Management
        defaultPage.hotelManagement.click();

        //Click on Room reservations
        defaultPage.roomReservationButton.click();

        //Click on Add Room Reservation
        hotelReservationPage = new Homework_HotelReservationPage();
        hotelReservationPage.addRoomReservationButton.click();

        //Enter All required fields
        //dropdown
        Select select = new Select(hotelReservationPage.userDropDown);
        select.selectByIndex(1);                       //selecting admin on dropdown

        Select select1 = new Select(hotelReservationPage.userDropdown2);
        select1.selectByVisibleText("King room");      //selecting King room



        hotelReservationPage.price.sendKeys("500");
        hotelReservationPage.startDate.sendKeys("06/14/2021");
        hotelReservationPage.endDate.sendKeys("06/16/2021");
        hotelReservationPage.adultAmount.sendKeys("1");
        hotelReservationPage.childrenAmount.sendKeys("0");
        hotelReservationPage.contactNameSurname.sendKeys("Kocal");
        hotelReservationPage.contactPhone.sendKeys("(011) 222-2222");
        hotelReservationPage.contactEmail.sendKeys("abcd@gmail.com");
        hotelReservationPage.notes.sendKeys("I dont wanna add any notes");
        hotelReservationPage.checkBox.click();
        hotelReservationPage.isPaid.click();
        hotelReservationPage.saveButton.click();

        //Verify the message: RoomReservation was inserted successfully

        //I have to use wait here because there is Sychronazation issue
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        WebElement messageText= wait.until(ExpectedConditions.visibilityOf(hotelReservationPage.message));
        Assert.assertEquals(messageText.getText(),"RoomReservation was inserted successfully");


        //String messageText= hotelReservationPage.message.getText();
        //Assert.assertEquals(messageText,"RoomReservation was inserted successfully");

        //Click OK
        hotelReservationPage.okButton.click();


    }

}
