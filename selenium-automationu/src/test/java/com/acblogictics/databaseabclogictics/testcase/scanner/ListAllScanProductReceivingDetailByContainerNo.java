package com.acblogictics.databaseabclogictics.testcase.scanner;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.acblogictics.databaseabclogictics.testcase.scanner.ExcelTestResultUpdater.updateTestResult;


@SpringBootTest
public class ListAllScanProductReceivingDetailByContainerNo{
    String neoURL = "http://51.79.255.60:9280/api/scan";

    private String containerNo_id = "1234";

    @Test
    public void testAllScanProductReceivingDetailByContainerNo() {
        String functionName = "testAllScanProductReceivingDetailByContainerNo";
        try {
            HttpResponse<String> response = Unirest.get(neoURL + "/get-all-scan-receiving-product-by-container/{containerNo}")
                    .routeParam("containerNo", containerNo_id)
                    .asString();

            int statusCode = response.getStatus();
            if (statusCode == 200) {
                JSONObject jsonResponse = new JSONObject(response.getBody());

                JSONObject dataObject = jsonResponse.getJSONObject("data");

                JSONArray scanProductReceivingDetailByContainerNo = dataObject.getJSONArray("scanProductReceivingDetailByContainerNo");
                if (scanProductReceivingDetailByContainerNo.length() < 1) {
                    updateTestResult(functionName, false, "ProductReceiving không có giá trị");
                    Assert.fail("ProductReceiving không có giá trị");
                } else {
                    updateTestResult(functionName, true, "");
                    Assert.assertTrue(true);
                }
            } else {
                updateTestResult(functionName, false, "Request failed with status code: " + statusCode);
                Assert.fail("Request failed with status code: " + statusCode);
            }
        } catch (JSONException e) {
            updateTestResult(functionName, false, "Không tìm thấy ProductReceiving");
            Assert.fail(e.getMessage());
        } catch (Exception e) {
            updateTestResult(functionName, false, e.getMessage());
            Assert.fail(e.getMessage());
        }
    }


    @Test
    public void testAllScanProductReceivingDetailByContainerNoInvalid() {
        String functionName = "testAllScanProductReceivingDetailByContainerNoInvalid";
        try {
            HttpResponse<String> response = Unirest.get(neoURL + "/get-all-scan-receiving-product-by-container/{containerNo}")
                    .routeParam("containerNo", "98765")
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
    public void testAllScanProductReceivingDetailByContainerNoNull() {
        String functionName = "testAllScanProductReceivingDetailByContainerNoNull";
        try {
            HttpResponse<String> response = Unirest.get(neoURL + "/get-all-scan-receiving-product-by-container/{containerNo}")
                    .routeParam("containerNo", "")
                    .asString();

            int statusCode = response.getStatus();
            if (statusCode == 404) {
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
