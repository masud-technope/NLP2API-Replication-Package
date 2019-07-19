package org.kodejava.example.poi;

import org.apache.poi.hssf.usermodel.*;

import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;

public class CreateExcelDemo {
    public static void main(String[] args) {
        //
        // Creating an instance of HSSFWorkbook.
        //
        HSSFWorkbook workbook = new HSSFWorkbook();

        //
        // Create two sheets in the excel document and name it First Sheet and
        // Second Sheet.
        //
        HSSFSheet firstSheet = workbook.createSheet("FIRST SHEET");
        HSSFSheet secondSheet = workbook.createSheet("SECOND SHEET");

        //
        // Manipulate the firs sheet by creating an HSSFRow wich represent a
        // single row in excel sheet, the first row started from 0 index. After
        // the row is created we create a HSSFCell in this first cell of the row
        // and set the cell value with an instance of HSSFRichTextString
        // containing the words FIRST SHEET.
        //
        HSSFRow rowA = firstSheet.createRow(0);
        HSSFCell cellA = rowA.createCell(0);
        cellA.setCellValue(new HSSFRichTextString("FIRST SHEET"));

        HSSFRow rowB = secondSheet.createRow(0);
        HSSFCell cellB = rowB.createCell(0);
        cellB.setCellValue(new HSSFRichTextString("SECOND SHEET"));

        //
        // To write out the workbook into a file we need to create an output
        // stream where the workbook content will be written to.
        //
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(new File("CreateExcelDemo.xls"));
            workbook.write(fos);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.flush();
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}