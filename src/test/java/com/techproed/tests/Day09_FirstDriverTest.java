package com.techproed.tests;

import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.annotations.Test;

public class Day09_FirstDriverTest {


    @Test
    public void firstDriverTest(){
        //        driver => Driver.getDriver()
        Driver.getDriver().get("https://www.amazon.com");//HARD CODE LINK

        //GET THE https://www.amazon.com from the configuration.properties
        //https://www.amazon.com ===> ConfigReader.getProperty("key")
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));



    }
}
