package com.techproed.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day14_DataProviderIntro {

    @DataProvider
    public Object[][] getData(){


//                manager   Manager1!
//                manager2  Manager2!
//                manager3  Manager3!

        //1.LONG WAY STORING DATA
         /*
        Object [][] managerProfile = new Object[3][2];//3 rows 2 columns
        1st row
        managerProfile[0][0]="manager";
        managerProfile[0][1]="Manager1!";
        2nd row
        managerProfile[1][0]="manager2";
        managerProfile[1][1]="Manager2!";
        3rd row
        managerProfile[2][0]="manager3";
        managerProfile[2][1]="Manager3!";
 */

        //2. SHORT WAY
        String[][] managerProfile ={
                {"manager1","Manager1!!"},
                {"manager2","Manager2!"},
                {"manager3","Manager3!"}

        };
        return managerProfile;
    }

    //    @Test(dataProvider = "METHOD NAME)
    @Test(dataProvider = "getData")
    public void managerInfo(String username,String password){

        System.out.println("USER NAME :"+ username + "PASSWORD :"+ password);

    }
}
