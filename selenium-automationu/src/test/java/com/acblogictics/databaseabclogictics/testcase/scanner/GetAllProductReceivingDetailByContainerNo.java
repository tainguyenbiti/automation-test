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
public class GetAllProductReceivingDetailByContainerNo {

    String neoURL = "http://51.79.255.60:9280/api/scan";


    @Test
    public void testGetAllProductReceivingDetailByContainerNo() {
        String functionName = "testGetAllProductReceivingDetailByContainerNo";
        try {
            HttpResponse<String> response = Unirest.get(neoURL + "/get-all-productreceivingdetail-by-container-no/{containerNo}")
                    .routeParam("containerNo", "1234")
                    .asString();

            int statusCode = response.getStatus();
            if (statusCode == 200) {
                JSONObject jsonResponse = new JSONObject(response.getBody());

                JSONObject dataObject = jsonResponse.getJSONObject("data");

                JSONArray productReceivingDetailByContainers = dataObject.getJSONArray("productReceivingDetailByContainers");
                if (productReceivingDetailByContainers.length() < 1) {
                    updateTestResult(functionName, false, "Không có giá trị");
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
            updateTestResult(functionName, false, "Không tìm thấy chi tiết sản phẩm Receiving");
            Assert.fail(e.getMessage());
        } catch (Exception e) {
            updateTestResult(functionName, false, e.getMessage());
            Assert.fail(e.getMessage());
        }
    }


    @Test
    public void testGetAllProductReceivingDetailByContainerNoNotExist() {
        String functionName = "testGetAllProductReceivingDetailByContainerNoNotExist";
        try {
            HttpResponse<String> response = Unirest.get(neoURL + "/get-all-productreceivingdetail-by-container-no/{containerNo}")
                    .routeParam("containerNo", "1234214")
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
    public void testGetAllProductReceivingDetailByContainerNoNull() {
        String functionName = "testGetAllProductReceivingDetailByContainerNoNull";
        try {
            HttpResponse<String> response = Unirest.get(neoURL + "/get-all-productreceivingdetail-by-container-no")
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
