package org.winner.automation.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcelData {

    public static String receiveCellData(int colNumber, int rowNumber) {
        String cellData = "";
        try {
            FileInputStream excelFile = new FileInputStream(new File("src/test/resources/Registration_Info.xlsx"));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet = workbook.getSheetAt(0);

            if (rowNumber > 0 && colNumber > 0 && colNumber < 7) {
                cellData = sheet.getRow(rowNumber).getCell(colNumber - 1).getStringCellValue();
                System.out.println(cellData);
            }
        } catch (IOException e) {
            e.printStackTrace();
                                }
        return cellData;
    }
}