package com.acblogictics.databaseabclogictics.testcase.scanner;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelTestResultUpdater {

    private static final String FILE_PATH = "src/main/resources/ABC_Testcase_Scanner_Truong.xlsx";

    public static void updateTestResult(String functionName, boolean result, String comment) {
        try {
            FileInputStream file = new FileInputStream(new File(FILE_PATH));
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                Cell cell = row.getCell(1); // Assuming the Function name column is in the second column
                if (cell != null && cell.getStringCellValue().equals(functionName)) {
                    updateRow(row, result, comment);
                    break;
                }
            }

            file.close();

            try (FileOutputStream outFile = new FileOutputStream(new File(FILE_PATH))) {
                workbook.write(outFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void updateRow(Row row, boolean result, String comment) {
        Cell resultCell = row.createCell(6); // Assuming the Test result column is in the eighth column
        resultCell.setCellValue(result ? "TRUE" : "FALSE");

        Cell commentCell = row.createCell(7); // Assuming the Comment column is in the ninth column
        commentCell.setCellValue(comment);
    }
}
