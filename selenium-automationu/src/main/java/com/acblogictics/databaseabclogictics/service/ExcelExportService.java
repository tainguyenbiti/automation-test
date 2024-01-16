package com.acblogictics.databaseabclogictics.service;

import com.acblogictics.databaseabclogictics.config.TestNGConfiguration;
import com.acblogictics.databaseabclogictics.result.TestNGResults;
import com.acblogictics.databaseabclogictics.result.TestResultDetail;
import com.acblogictics.databaseabclogictics.result.TestResults;
import com.acblogictics.databaseabclogictics.util.TestNGXmlGenerator;
import com.acblogictics.databaseabclogictics.util.TestNGXmlGeneratorMethod;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Service
public class ExcelExportService {
    public TestResults testResults;

    public ResponseEntity<InputStreamResource> exportToExcel(TestResults dataList, String directoryPath, String fileName) throws IOException {
        if (dataList == null) {
            return ResponseEntity.ok().build();
        }

        Path path = Paths.get(directoryPath);
        // create folder if it doesn't exist
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
        String folderName = fileName + "-" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")) + ".xlsx";
        String folderPath = Paths.get(directoryPath, folderName).toString();
        String excelFilePath = Paths.get(folderPath).toString();

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("TestCase");

        // set labels
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Parent name");
        headerRow.createCell(1).setCellValue("Test name");
        headerRow.createCell(2).setCellValue("Start time");
        headerRow.createCell(3).setCellValue("Stop time");
        headerRow.createCell(4).setCellValue("Duration");
        headerRow.createCell(5).setCellValue("Status");
        headerRow.createCell(6).setCellValue("Reason");

        //set values for labels
        int rowNum = 1;
        for (Map.Entry<String, Map<String, TestResultDetail>> entry : dataList.getTestStatus().entrySet()) {
            String parentName = entry.getKey();
            Map<String, TestResultDetail> testDataMap = entry.getValue();
            for (Map.Entry<String, TestResultDetail> testDataEntry : testDataMap.entrySet()) {
                TestResultDetail testData = testDataEntry.getValue();
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(parentName);
                row.createCell(1).setCellValue(testData.getMethod());
                row.createCell(2).setCellValue(convertTime(testData.getStart()));
                row.createCell(3).setCellValue(convertTime(testData.getEnd()));
                row.createCell(4).setCellValue(testData.getEnd() - testData.getStart());
                row.createCell(5).setCellValue(testData.getTestStatus());
                row.createCell(6).setCellValue(testData.getReason());
            }
        }
        try (FileOutputStream fileOut = new FileOutputStream(excelFilePath)) {
            workbook.write(fileOut);
        }
        File file = new File(excelFilePath);
        workbook.close();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
        headers.add("Content-Disposition", "attachment; filename=" + file.getName());
        headers.setContentLength(file.length());

        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }
    // convert from long to datetime
    public String convertTime(long time) {
        Instant instant = Instant.ofEpochMilli(time);
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.of("Asia/Ho_Chi_Minh"));
        return dateTime.toString();
    }

    public TestResults generateTest(String method_name) throws IOException, InterruptedException, ClassNotFoundException {
        if (method_name == null) {
            TestNGXmlGenerator.generateTestNGXml(
                    "com.acblogictics.databaseabclogictics.testcase.scanner"
            );
        }
        else {
            TestNGXmlGeneratorMethod.generateXmlForMethod(
                    "com.acblogictics.databaseabclogictics.testcase.scanner",
                    method_name
            );
        }
        TestNG testng = TestNGConfiguration.configure("testxml/test_api.xml");
        TestListenerAdapter tla = new TestListenerAdapter();
        testng.addListener(tla);
        testng.run();
        testResults = TestNGResults.create(tla);
        return testResults;
    }
}
