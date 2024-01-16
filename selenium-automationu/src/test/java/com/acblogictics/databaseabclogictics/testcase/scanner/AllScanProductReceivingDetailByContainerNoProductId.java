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
public class AllScanProductReceivingDetailByContainerNoProductId{

    String neoURL = "http://51.79.255.60:9280/api/scan";

    private String containerNo_id = "1234";


    @Test
    public void testAllScanProductReceivingDetailByContainerNoProductId() {
        try {
            HttpResponse<String> response = Unirest.get(neoURL + "/get-all-scan-receiving-product-by-container-no")
                    .queryString("containerNo", containerNo_id)
                    .queryString("productId", "15")
                    .asString();

            int statusCode = response.getStatus();
            if (statusCode == 200) {
                JSONObject jsonResponse = new JSONObject(response.getBody());

                JSONObject dataObject = jsonResponse.getJSONObject("data");

                JSONArray scanProductReceivingDetailByContainerNo = dataObject.getJSONArray("scanProductReceivingDetailByContainerNo");
                if (scanProductReceivingDetailByContainerNo.length() < 1) {
                    Assert.fail("ProductReceiving không có giá trị");
                } else {
                    Assert.assertTrue(true);
                }
            } else {
                Assert.fail("Request failed with status code: " + statusCode);
            }
        } catch (JSONException e) {
            Assert.fail(e.getMessage());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }


    @Test
    public void testAllScanProductReceivingDetailByContainerNoProductIdNull() {
        try {
            HttpResponse<String> response = Unirest.get(neoURL + "/get-all-scan-receiving-product-by-container-no")
                    .asString();

            int statusCode = response.getStatus();
            if (statusCode == 400) {
                Assert.assertTrue(true);
            } else {
                Assert.fail("Request failed with status code: " + statusCode);
            }
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }


    @Test
    public void testAllScanProductReceivingDetailByContainerNoProductIdNotExistContainer() {
        try {
            HttpResponse<String> response = Unirest.get(neoURL + "/get-all-scan-receiving-product-by-container-no")
                    .queryString("containerNo", "0987654")
                    .queryString("productId", "15")
                    .asString();

            int statusCode = response.getStatus();
            if (statusCode == 400) {
                Assert.assertTrue(true);
            } else {
                Assert.fail("Request failed with status code: " + statusCode);
            }
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }


    @Test
    public void testAllScanProductReceivingDetailByContainerNoProductIdNotExistProductId() {
        try {
            HttpResponse<String> response = Unirest.get(neoURL + "/get-all-scan-receiving-product-by-container-no")
                    .queryString("containerNo", containerNo_id)
                    .queryString("productId", "0987865")
                    .asString();

            int statusCode = response.getStatus();
            if (statusCode == 400) {
                Assert.assertTrue(true);
            } else {
                Assert.fail("Request failed with status code: " + statusCode);
            }
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

}
