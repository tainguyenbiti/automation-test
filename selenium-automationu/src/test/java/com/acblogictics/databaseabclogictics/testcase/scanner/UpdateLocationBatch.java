package com.acblogictics.databaseabclogictics.testcase.scanner;


import com.acblogictics.databaseabclogictics.service.dto.LocationDto;
import com.acblogictics.databaseabclogictics.service.dto.request.BatchLocationDto;
import com.acblogictics.databaseabclogictics.service.dto.request.UpdateListReceivingByScanProductDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static com.acblogictics.databaseabclogictics.testcase.scanner.ExcelTestResultUpdater.updateTestResult;

@SpringBootTest
@AutoConfigureMockMvc
public class UpdateLocationBatch {
    String neoURL = "http://51.79.255.60:9280/api/scan";

    @Autowired
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testUpdateLocationBatch() {
        String functionName = "testUpdateLocationBatch";
        UpdateListReceivingByScanProductDto updateListReceivingByScanProductDto = new UpdateListReceivingByScanProductDto();
        updateListReceivingByScanProductDto.setActualMC(100d);
        updateListReceivingByScanProductDto.setActualUC(100d);
        updateListReceivingByScanProductDto.setContainerNo(56756899L);
        updateListReceivingByScanProductDto.setProductId(1L);
        updateListReceivingByScanProductDto.setTotalUnit(100d);

        List<BatchLocationDto> locationBatches = new ArrayList<>();
        BatchLocationDto batchLocationDto = new BatchLocationDto();
        batchLocationDto.setActualQTY(100);

        LocationDto locationDto = new LocationDto();
        locationDto.setId(0L);
        locationDto.setLocationNo("string");
        locationDto.setMaxCBM(0);
        locationDto.setMinCBM(0);
        locationDto.setStatus(true);

        batchLocationDto.setLocation(locationDto);
        batchLocationDto.setPalletCount(0);

        locationBatches.add(batchLocationDto);
        updateListReceivingByScanProductDto.setLocationBatches(locationBatches);

        try {
            HttpResponse<String> response = Unirest.post(neoURL + "/update-inbound-receiving-by-scan-product")
                    .header("Content-Type", "application/json")
                    .body(objectMapper.writeValueAsString(updateListReceivingByScanProductDto))
                    .asString();

            int statusCode = response.getStatus();
            if (statusCode == 200) {
                updateTestResult(functionName, true, "");
                Assert.assertTrue(true);
            } else {
                updateTestResult(functionName, false, "Request failed with status code: " + statusCode);
                Assert.fail("Request failed with status code: " + statusCode);
            }
        } catch (Exception e) {
            updateTestResult(functionName, false, e.getMessage());
            Assert.fail(e.getMessage());
        }
    }


    @Test
    public void testUpdateLocationBatchInvalidValue() {
        String functionName = "testUpdateLocationBatchInvalidValue";
        UpdateListReceivingByScanProductDto updateListReceivingByScanProductDto = new UpdateListReceivingByScanProductDto();
        updateListReceivingByScanProductDto.setActualMC(100d);
        updateListReceivingByScanProductDto.setActualUC(100d);
        updateListReceivingByScanProductDto.setContainerNo(56756899L);
        updateListReceivingByScanProductDto.setProductId(1L);
        updateListReceivingByScanProductDto.setTotalUnit(100d);

        List<BatchLocationDto> locationBatches = new ArrayList<>();
        BatchLocationDto batchLocationDto = new BatchLocationDto();
        batchLocationDto.setActualQTY(0);

        LocationDto locationDto = new LocationDto();
        locationDto.setId(0L);
        locationDto.setLocationNo("string");
        locationDto.setMaxCBM(0);
        locationDto.setMinCBM(0);
        locationDto.setStatus(true);

        batchLocationDto.setLocation(locationDto);
        batchLocationDto.setPalletCount(0);

        locationBatches.add(batchLocationDto);
        updateListReceivingByScanProductDto.setLocationBatches(locationBatches);

        try {
            HttpResponse<String> response = Unirest.post(neoURL + "/update-inbound-receiving-by-scan-product")
                    .header("Content-Type", "application/json")
                    .body(objectMapper.writeValueAsString(updateListReceivingByScanProductDto))
                    .asString();

            int statusCode = response.getStatus();
            if (statusCode == 400) {
                updateTestResult(functionName, true, "");
                Assert.assertTrue(true);
            } else {
                updateTestResult(functionName, false, "Request failed with status code: " + statusCode);
                Assert.fail("Request failed with status code: " + statusCode);
            }
        } catch (Exception e) {
            updateTestResult(functionName, false, e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

}
