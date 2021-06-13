package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homework_HotelReservationPage {

    //LOCATE HOTEL RESERVATION PAGE OBJECTS

    public Homework_HotelReservationPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//span[@class='hidden-480']")
    public WebElement addRoomReservationButton;

    @FindBy(id = "IDUser")
    public WebElement userDropDown;

    @FindBy(id = "IDHotelRoom")
    public WebElement userDropdown2;

    @FindBy(id="Price")
    public WebElement price;

    @FindBy(id = "DateStart")
    public WebElement startDate;

    @FindBy(id = "DateEnd")
    public WebElement endDate;

    @FindBy(id = "AdultAmount")
    public WebElement adultAmount;

    @FindBy(id = "ChildrenAmount")
    public WebElement childrenAmount;

    @FindBy(id = "ContactNameSurname")
    public WebElement contactNameSurname;

    @FindBy(id = "ContactPhone")
    public WebElement contactPhone;

    @FindBy(id = "ContactEmail")
    public WebElement contactEmail;

    @FindBy(id = "Notes")
    public WebElement notes;

    @FindBy(id = "Approved")
    public WebElement checkBox;

    @FindBy(id = "IsPaid")
    public WebElement isPaid;

    @FindBy(id = "btnSubmit")
    public WebElement saveButton;

    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement message;

    @FindBy(xpath = "(//button[@type='button'])[8]")
    public WebElement okButton;

}
