package com.techproed.excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Day14_WriteExcel {


    //EXCEL IS NOT MANDATORY TO GET THE TEST DATA
    //BUT IT IS EASY WAY TO GET THE LARGE AMOUNT OF TEST DATA

    @Test
    public void writeExcel() throws IOException {

        //Create a new class: WriteExcel
        //Create a new method: writeExcel()
        //Store the path of the file as string and open the file
        //Open the workbook
        //Open the first worksheet
        //Go to the first row
        //Create a cell on the 3rd index on the first row
        //Write “POPULATION” on that cell
        //Create a cell on the 2nd row 4th cell(index3), and write 150000
        //Create a cell on the 3rd row 4th cell(index3), and write 250000
        //Create a cell on the 4th row 4th cell(index3), and write 54000
        //Write and save the workbook
        //Close the file
        //Close the workbook


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
        //SO FAR READ EXCEL AND WRITE EXCEL STEPS ARE THE SAME



        //Create a cell on the 2nd index on the first row
        Cell populationCell = firstRow.createCell(2);
        //Write population on the cell -->ROC2
        populationCell.setCellValue("POPULATION");


        //Create a cell on the 2nd row 3rd cell(index2), and write 150000
        sheet.getRow(1).createCell(2).setCellValue("150000");


        //Create a cell on the 3rd row 3rd cell, and write 250000
        sheet.getRow(2).createCell(2).setCellValue("250000");


        //Create a cell on the 4th row 3rd cell, and write 54000
        sheet.getRow(3).createCell(2).setCellValue("54000");
        sheet.getRow(4).createCell(2).setCellValue("1000000");



        //Write and save the workbook
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        workbook.write(fileOutputStream);


        //Close the file
        fileInputStream.close();
        fileOutputStream.close();

        //Close the workbook
        workbook.close();


    }


}
