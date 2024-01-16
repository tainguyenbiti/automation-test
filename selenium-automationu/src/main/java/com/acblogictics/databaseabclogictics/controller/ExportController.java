package com.acblogictics.databaseabclogictics.controller;

import com.acblogictics.databaseabclogictics.entity.Test;
import com.acblogictics.databaseabclogictics.result.TestResultDetail;
import com.acblogictics.databaseabclogictics.result.TestResults;
import com.acblogictics.databaseabclogictics.service.ExcelExportService;
import com.acblogictics.databaseabclogictics.service.FolderService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/export")
public class ExportController {
    private final ExcelExportService excelExportService;

    @Autowired
    public ExportController(ExcelExportService excelExportService) {
        this.excelExportService = excelExportService;
    }

    @GetMapping("/export-excel")
    public ResponseEntity<InputStreamResource> getTestResults() throws IOException {
        String fileName = "export-excel";
        return excelExportService.exportToExcel(excelExportService.testResults, "src/main/resources/result/", fileName);
    }




}

