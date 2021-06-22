package com.techproed.extentreports;

import com.techproed.utilities.Driver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TakeScreenShotTest {

    @Test
    public void takeScreenshot() throws IOException {

        //        1. TakesScreenshot object is used to take screenshot in selenium
        TakesScreenshot ts=(TakesScreenshot) Driver.getDriver();
//        2. Calling  getScreenshotAs method creates an image file. Storing in File object
        File image=ts.getScreenshotAs(OutputType.FILE);

//        getting the current data to use it in the image name to have unique image name
        String currentDate = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//        Full path of the image file where the image will be stored/Folder Name: test-output. File Name:  Screenshots/"+currentDate+".png". File Format : png
        String path = System.getProperty("user.dir")+                 "/test-output/Screenshots/"+currentDate+".png";
//        Final path of the image file
        File finalPath = new File(path);

//        Saving the image to the final path
        FileUtils.copyFile(image,finalPath);

    }

     
}
