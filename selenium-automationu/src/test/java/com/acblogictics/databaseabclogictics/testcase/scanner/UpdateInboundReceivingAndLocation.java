package com.acblogictics.databaseabclogictics.testcase.scanner;


import com.acblogictics.databaseabclogictics.service.dto.request.UpdateLocationBatchScanReq;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.acblogictics.databaseabclogictics.testcase.scanner.ExcelTestResultUpdater.updateTestResult;


@SpringBootTest
public class UpdateInboundReceivingAndLocation{

    String neoURL = "http://51.79.255.60:9280/api/scan";

    @Autowired
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testUpdateInboundReceivingAndLocation() {
        String functionName = "testUpdateInboundReceivingAndLocation";
        UpdateLocationBatchScanReq updateLocationBatchScanReq = new UpdateLocationBatchScanReq();
        updateLocationBatchScanReq.setId(1L);
        updateLocationBatchScanReq.setActualMC(2d);
        updateLocationBatchScanReq.setActualUC(2d);
        updateLocationBatchScanReq.setTotalUnit(10d);
        try {

            String requestBody = objectMapper.writeValueAsString(updateLocationBatchScanReq);

            HttpResponse<String> response = Unirest.post(neoURL + "/location-batch/update")
                    .header("Content-Type", "application/json")
                    .body(requestBody)
                    .asString();

            int statusCode = response.getStatus();
            if (statusCode == 200) {
                JSONObject jsonResponse = new JSONObject(response.getBody());
                JSONObject dataObject = jsonResponse.getJSONObject("data");
                JSONObject inboundReceivingProductDetail = dataObject.getJSONObject("inboundReceivingProductDetail");
                Double actualMC = inboundReceivingProductDetail.getDouble("actualMC");
                if (!actualMC.equals(updateLocationBatchScanReq.getActualMC())) {
                    updateTestResult(functionName, false, "Giá trị chưa được cập nhật");
                    Assert.fail("Giá trị chưa được cập nhật");
                } else {
                    updateTestResult(functionName, true, "");
                    Assert.assertTrue(true);
                }
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
    public void testUpdateInboundReceivingAndLocationInvalid() {
        String functionName = "testUpdateInboundReceivingAndLocationInvalid";
        UpdateLocationBatchScanReq updateLocationBatchScanReq = new UpdateLocationBatchScanReq();
        updateLocationBatchScanReq.setId(18977L);
        updateLocationBatchScanReq.setActualMC(2d);
        updateLocationBatchScanReq.setActualUC(2d);
        updateLocationBatchScanReq.setTotalUnit(10d);
        try {
            String requestBody = objectMapper.writeValueAsString(updateLocationBatchScanReq);

            HttpResponse<String> response = Unirest.post(neoURL + "/location-batch/update")
                    .header("Content-Type", "application/json")
                    .body(requestBody)
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


    @Test
    public void testUpdateInboundReceivingAndLocationInvalidValue() {
        String functionName = "testUpdateInboundReceivingAndLocationInvalidValue";
        UpdateLocationBatchScanReq updateLocationBatchScanReq = new UpdateLocationBatchScanReq();
        updateLocationBatchScanReq.setId(18977L);
        try {
            String requestBody = objectMapper.writeValueAsString(updateLocationBatchScanReq);

            HttpResponse<String> response = Unirest.post(neoURL + "/location-batch/update")
                    .header("Content-Type", "application/json")
                    .body(requestBody)
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
