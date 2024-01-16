package com.acblogictics.databaseabclogictics.controller;


import com.acblogictics.databaseabclogictics.config.TestNGConfiguration;
import com.acblogictics.databaseabclogictics.result.TestNGResults;
import com.acblogictics.databaseabclogictics.result.TestResultDetail;
import com.acblogictics.databaseabclogictics.result.TestResults;
import com.acblogictics.databaseabclogictics.service.ExcelExportService;
import com.acblogictics.databaseabclogictics.service.FolderService;
import com.acblogictics.databaseabclogictics.util.DeleteFolder;
import com.acblogictics.databaseabclogictics.util.RunCMD;
import com.acblogictics.databaseabclogictics.util.TestNGXmlGenerator;
import com.acblogictics.databaseabclogictics.util.TestNGXmlGeneratorMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;

import java.io.IOException;

@RestController
@RequestMapping("/selenium-api")
@CrossOrigin("*")
public class SeleniumApiController {
    private final ExcelExportService excelExportService;

    @Autowired
    public SeleniumApiController(ExcelExportService excelExportService) {
        this.excelExportService = excelExportService;
    }

    @GetMapping("/test")
    public TestResults test(@RequestParam (required = false) String method_name) throws IOException, InterruptedException, ClassNotFoundException {
        return excelExportService.generateTest(method_name);
    }
}

