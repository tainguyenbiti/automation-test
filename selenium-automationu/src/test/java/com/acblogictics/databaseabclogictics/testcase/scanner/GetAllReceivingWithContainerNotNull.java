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
public class GetAllReceivingWithContainerNotNull {
    String neoURL = "http://51.79.255.60:9280/api/scan";

    @Test
    public void testGetAllReceivingWithContainerNotNull() {
        String functionName = "testGetAllReceivingWithContainerNotNull";
        try {
            HttpResponse<String> response = Unirest.get(neoURL + "/get-all-receiving-with-container-not-null-by-container-no")
                    .queryString("searchKey", "1234")
                    .asString();

            int statusCode = response.getStatus();
            if (statusCode == 200) {
                JSONObject jsonResponse = new JSONObject(response.getBody());

                JSONObject dataObject = jsonResponse.getJSONObject("data");

                JSONArray inboundReceivings = dataObject.getJSONArray("inboundReceivings");
                if (inboundReceivings.length() < 1) {
                    updateTestResult(functionName, false, "Receivings không có giá trị");
                    Assert.fail("Receivings không có giá trị");
                } else {
                    updateTestResult(functionName, true, "");
                    Assert.assertTrue(true);
                }
            } else {
                updateTestResult(functionName, false, "Request failed with status code: " + statusCode);
                Assert.fail("Request failed with status code: " + statusCode);
            }
        } catch (JSONException e) {
            updateTestResult(functionName, false, "Không tìm thấy Receivings");
            Assert.fail(e.getMessage());
        } catch (Exception e) {
            updateTestResult(functionName, false, e.getMessage());
            Assert.fail(e.getMessage());
        }
    }


    @Test
    public void testGetAllReceivingWithContainerNotNullBySearchKeyNull() {
        String functionName = "testGetAllReceivingWithContainerNotNullBySearchKeyNull";
        try {
            HttpResponse<String> response = Unirest.get(neoURL + "/get-all-receiving-with-container-not-null-by-container-no")
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
    public void testGetAllReceivingWithContainerNotNullNotExist() {
        String functionName = "testGetAllReceivingWithContainerNotNullNotExist";
        try {
            HttpResponse<String> response = Unirest.get(neoURL + "/get-all-receiving-with-container-not-null-by-container-no")
                    .queryString("searchKey", "12346")
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
