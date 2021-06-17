package com.techproed.tests;

import com.techproed.pages.Day11_DefaultPage;
import com.techproed.pages.Day11_LoginPage;
import com.techproed.pages.Day12_HotelRoomPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Day13_WebTables {

    //Create a class: WebTables
    //Create a method: BeforeMethod to log in the app and navigate to hotel rooms page
    //Log in  https://qa-environment.resortsline.com/Account/Logon
    //Click on Hotel Management
    //Click on Hotel Rooms

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
        Assert.assertTrue(defaultPage.userAddButton.isDisplayed()); //checking if the login is successful

        //Click on Hotel Management
        defaultPage.hotelManagement.click();

        //Click on Hotel Rooms
        defaultPage.hotelRooms.click();

        //Click on Add Hotel Room
        hotelRoomPage =new Day12_HotelRoomPage();

    }


         //Create a test method: entireTable() and Find the size of the entire table body and print all of headers
         //Create a test method: printRows() and Print all of the rows and print the elements on the 4th row
         //Create a test method: printCells() and a the total number of cells in the table body and print all of the cells
         //Create a test method: printColumns() and print Find the total number of columns and Print the elements of the 5th column
         //Create a test method: printData(int row, int column); This method should print the given cell. Example: printData(2,3); should print 2nd row,3rd column



    @Test
    public void entireTable() {
        //Create a test method: entireTable() and Find the size of the entire table body and print all of headers
        //Create a test method: entireTable()
        // Find the size of the entire table body
        System.out.println("====ENTIRE TABLE METHOD====");
        System.out.println("=====Table Body====");

        List<WebElement> tableBody = Driver.getDriver().findElements(By.xpath("//table//tbody"));

        System.out.println("Number of table " + tableBody.size());

        //and print entire table
        for (WebElement each : tableBody) {
            System.out.println(each.getText());
        }


        //and print all headers
        System.out.println("========print all headers=======");
        List<WebElement> allHeadings = Driver.getDriver().findElements(By.xpath("//th"));
        for (WebElement eachHeading : allHeadings) {
            System.out.println(eachHeading.getText());
        }

        //print number of heading
        System.out.println("Number of header :" + allHeadings.size());
    }



    @Test
    public void printRows(){
        //Create a test method: printRows() and Print all of the rows and print the elements on the 4th row
        System.out.println("*****PRINTS ROW METHOD *******");
        //Create a test method:
        // printRows() and Print all of the rows and print the elements on the 4th row
        List<WebElement>allRows =Driver.getDriver().findElements(By.xpath("//tbody//tr"));
        //Find the total number of rows
        System.out.println("Total number of rows:" + allRows.size());
        //Print all rows in the table
        for (WebElement eachRow:allRows){
            System.out.println(eachRow.getText());
        }

        WebElement fourthElement = Driver.getDriver().findElement(By.xpath("//tbody//tr[4]"));
        System.out.println("Fourth row is :" + fourthElement.getText());

    }



    @Test
    public void printCells(){
        //Create a test method: printCells() and a the total number of cells in the table body and print all of the cells
        System.out.println("******PRINT CELLS METHOD*****");
        List<WebElement>allCells = Driver.getDriver().findElements(By.xpath("//tbody//td"));
        //and total number of cells in the table body
        System.out.println("Number of all cells" + allCells.size());
        //print all of the cell data in the table body
        int count =1;
        for (WebElement eachCell: allCells){
            System.out.println(count+ "=>" + eachCell.getText());
            count++;
        }

    }



    @Test
    public void printColumns(){
        System.out.println("***********PRINT ALL COLUMNS***********");
        //Create a test method: printColumns() and print Find the total number of columns and Print the elements of the 6th column
        //th   ==> all the table heading which is same as total number of column***
        //ALTERNATIVE: //tr[1]//td ==> 1st row all cells   (tr[1]==> gives all entire column as 1 single block)

        List<WebElement>numOfCoulumns = Driver.getDriver().findElements(By.xpath("//th"));
        //total number of columns
        System.out.println("Number of column:" + numOfCoulumns.size());
        //print the elements of the 6th column --> ALL PRICES
        List<WebElement>row6 =Driver.getDriver().findElements(By.xpath("//tbody//tr//td[6]"));

        int rowNum=1;
        for (WebElement eachRowOf6thColumns: row6){
            System.out.println("ROW NUMBER " + rowNum+"=>"+eachRowOf6thColumns.getText());
            rowNum++;

        }

    }




    public void printData(int row,int column){
        //Create a test method: printData(int row, int column); This method should print the given cell. Example: printData(2,3); should print 2nd row,3rd column
        //   //tbody//tr[2]//td[3]    ===>row3  column 3
        //   //tbody//tr[6]//td[5]     ====?row6  column 4

        //        IN GENERAL:
        //                  tbody//tr[row]//td[column]
        //                 "//tbody//tr[" + row + "]//td[" +column+"]"

        String dynamicXpath="//tbody//tr["+row+"]//td["+column+"]";
        //        This xpath will change based on users number
        //        Example printData(2,3); =>"//tbody//tr[2]//td[3]";
        //        Example printData(4,6); =>"//tbody//tr[4]//td[6]";

        //WebElement data1 = Driver.getDriver().findElement(By.xpath("//tbody//tr["+row+"]//td["+column+"]"));
        WebElement data1 = Driver.getDriver().findElement(By.xpath(dynamicXpath));
        System.out.println(data1.getText());



    }
    @Test
    public void printDataTest(){
        printData(2,3);//"//tbody//tr[2]//td[3]";
        printData(4,6);//"//tbody//tr[4]//td[6]";
        printData(7,7);//"//tbody//tr[7]//td[7]";

        /*
        Triple room
        425.00
         Double-double
         */

    }











}
