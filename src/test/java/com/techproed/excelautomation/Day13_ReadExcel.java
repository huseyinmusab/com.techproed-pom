package com.techproed.excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Day13_ReadExcel {

    @Test
    public void readExcel() throws IOException {
//        Store the path of the  file in a string
        String filePath = ".\\src\\test\\java\\resources\\Capitals (1).xlsx";
//        Open the file
        FileInputStream fileInputStream = new FileInputStream(filePath);
//        Open the workbook using fileinputstream
        Workbook workbook = WorkbookFactory.create(fileInputStream);
//        Open the first worksheet
        Sheet sheet = workbook.getSheetAt(0);
//        Go to first row
        Row firstRow = sheet.getRow(0);
//        Go to first cell on that first row and print
        Cell cell1 = firstRow.getCell(0);
        System.out.println(cell1);
//        Go to second cell on that first row and print-CAPITAL
        Cell capitalCell = firstRow.getCell(1);
        System.out.println(capitalCell);
//        Go to 2nd row first cell R1C0. WE CAN CHAIN THE METHODS
        Cell usaCell = sheet.getRow(1).getCell(0);
//      Data type usaCell Cell. I can convert this to a string to using string manupilation, lowercase, substring,charAt,...
        String usaCellString = usaCell.toString();
        System.out.println(usaCellString);
        Assert.assertEquals(usaCellString.toUpperCase(), "USA");
//        Go to 3rd row 2nd cell-chain the row and cell.r2c1.Verify the data is equal to Paris
        String parisCell = sheet.getRow(2).getCell(1).toString();
        Assert.assertEquals(parisCell.toUpperCase(), "PARIS");
//        Find the number of row.
//        We need to know how many rows are there in the SHEET
        int lastRowNum = sheet.getLastRowNum() + 1;//index starts at 0.
        System.out.println(lastRowNum);
//        Find the number of used row
        int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();//Index starts at 1
        // returns the rows numbers that are USED.
        // If there is a row that is EMPTY Then it will be skipped
        System.out.println(physicalNumberOfRows);
//        Print country, capitol key value pairs as map object
//        Creating a map object
//         country, capitol
        Map<String, String> worldCapitals = new HashMap<>();

        int countryColumn = 0;
        int capitolColumn = 1;

//        Getting the rows without 1st row because they have title
        for (int rowNumber = 1; rowNumber < lastRowNum; rowNumber++) {
//            System.out.println("COUNTRY : "+sheet.getRow(rowNumber).getCell(countryColumn));//counrty
//            System.out.println("CAPITOL : "+sheet.getRow(rowNumber).getCell(capitolColumn));//capitol

            String countries = sheet.getRow(rowNumber).getCell(countryColumn).toString();
            String capitols = sheet.getRow(rowNumber).getCell(capitolColumn).toString();
            worldCapitals.put(countries, capitols);
        }
        System.out.println(worldCapitals);
////        COUNTRY COLUMN PATTERN
//        System.out.println(sheet.getRow(rowNumber).getCell(countryColumn));//counrty
//        System.out.println(sheet.getRow(rowNumber).getCell(countryColumn));//usa
//        System.out.println(sheet.getRow(rowNumber).getCell(countryColumn));//France
//        System.out.println(sheet.getRow(rowNumber).getCell(countryColumn));//England
//        System.out.println(sheet.getRow(rowNumber).getCell(countryColumn));//Germany
//
////        CAPITOL COLUMN PATTERN
//        System.out.println(sheet.getRow(rowNumber).getCell(capitolColumn));//capitol
//        System.out.println(sheet.getRow(rowNumber).getCell(capitolColumn));//D.C
//        System.out.println(sheet.getRow(rowNumber).getCell(capitolColumn));//Paris
//        System.out.println(sheet.getRow(rowNumber).getCell(capitolColumn));//London
//        System.out.println(sheet.getRow(rowNumber).getCell(capitolColumn));//Berlin

    }

}
