package com.acblogictics.databaseabclogictics.controller;
import com.acblogictics.databaseabclogictics.entity.Test;
import com.acblogictics.databaseabclogictics.result.TestResultDetail;
import com.acblogictics.databaseabclogictics.service.ExcelExportService;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/chart")
public class ChartController {
    private final ExcelExportService excelExportService;

    public ChartController(ExcelExportService excelExportService) {
        this.excelExportService = excelExportService;
    }

    @GetMapping("/timeline-chart")
    public Map<String, Map<String, TestResultDetail>> getDataTimelineChart() throws IOException {
        return excelExportService.testResults.getTestStatus();
    }

    @GetMapping(value = "chart-java" ,produces = MediaType.IMAGE_PNG_VALUE)
    public void drawTimeline(HttpServletResponse response) throws IOException {
        TaskSeriesCollection dataset = createDataset();
        if (dataset == null) {
            return;
        }
        JFreeChart chart = createChart(dataset);

        response.setContentType("image/png");
        OutputStream outputStream = response.getOutputStream();
        ChartUtils.writeChartAsPNG(outputStream, chart, 800, 600);
        outputStream.close();
    }

    private TaskSeriesCollection createDataset() throws IOException {
        if (excelExportService.testResults == null || excelExportService.testResults.getTestStatus().isEmpty()) {
            return null;
        }

        TaskSeriesCollection dataset = new TaskSeriesCollection();

        Map<String, Map<String, TestResultDetail>> tests = excelExportService.testResults.getTestStatus();

        TaskSeries series = new TaskSeries("Test Cases");

        for (Map.Entry<String, Map<String, TestResultDetail>> entry : tests.entrySet()) {
            String key = entry.getKey();
            Map<String, TestResultDetail> value = entry.getValue();
            for (Map.Entry<String, TestResultDetail> test : value.entrySet()) {
                // Add a new Task to the series with information from the test result
                series.add(new Task(test.getValue().getMethod(), new Date(test.getValue().getStart()), new Date(test.getValue().getEnd())));
            }
        }

        // Add the series with test results to the dataset
        dataset.add(series);

        // Return the completed dataset
        return dataset;
    }


    private JFreeChart createChart(TaskSeriesCollection dataset) {
        return ChartFactory.createGanttChart(
                "Test Execution Timeline",
                "Test Case",
                "Timeline",
                dataset,
                true,
                true,
                false
        );
    }
}