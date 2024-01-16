package com.acblogictics.databaseabclogictics.testcase.scanner;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.acblogictics.databaseabclogictics.testcase.scanner.ExcelTestResultUpdater.updateTestResult;


@SpringBootTest
public class CheckProductIsExistingInSystem {

    String neoURL = "http://51.79.255.60:9280/api/scan";

    @Test
    @Rollback(true)
    public void testCheckProductIsExistingInSystem() {
        String functionName = "testCheckProductIsExistingInSystem";
        try {
            HttpResponse<String> response = Unirest.post(neoURL + "/check-product-is-existing-in-system")
                    .queryString("customerId", "3")
                    .queryString("upc", "upc1111111")
                    .asString();

            int statusCode = response.getStatus();
            if (statusCode == 200) {
                JSONObject jsonResponse = new JSONObject(response.getBody());

                JSONObject dataObject = jsonResponse.getJSONObject("data");

                JSONObject product = dataObject.getJSONObject("product");
                updateTestResult(functionName, true, "");
                Assert.assertTrue(true);
            } else {
                updateTestResult(functionName, false, "Request failed with status code: " + statusCode);
                Assert.fail("Request failed with status code: " + statusCode);
            }
        } catch (JSONException e) {
            updateTestResult(functionName, false, "Không tìm thấy product");
            Assert.fail(e.getMessage());
        } catch (Exception e) {
            updateTestResult(functionName, false, e.getMessage());
            Assert.fail(e.getMessage());
        }
    }


    @Test
    @Rollback(true)
    public void testCheckProductIsExistingInSystemNotExistCustomerId() {
        String functionName = "testCheckProductIsExistingInSystemNotExistCustomerId";
        try {
            HttpResponse<String> response = Unirest.post(neoURL + "/check-product-is-existing-in-system")
                    .queryString("customerId", "37")
                    .queryString("upc", "upc1111111")
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
    @Rollback(true)
    public void testCheckProductIsExistingInSystemNullUPC() {
        String functionName = "testCheckProductIsExistingInSystemNullUPC";
        try {
            HttpResponse<String> response = Unirest.post(neoURL + "/check-product-is-existing-in-system")
                    .queryString("customerId", "3")
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
    @Rollback(true)
    public void testCheckProductIsExistingInSystemNullCustomerId() {
        String functionName = "testCheckProductIsExistingInSystemNullCustomerId";
        try {
            HttpResponse<String> response = Unirest.post(neoURL + "/check-product-is-existing-in-system")
                    .queryString("upc", "upc1111111")
                    .asString();

            int statusCode = response.getStatus();
            if (statusCode == 200) {
                JSONObject jsonResponse = new JSONObject(response.getBody());

                JSONObject dataObject = jsonResponse.getJSONObject("data");

                JSONObject product = dataObject.getJSONObject("product");
                updateTestResult(functionName, true, "");
                Assert.assertTrue(true);
            } else {
                updateTestResult(functionName, false, "Request failed with status code: " + statusCode);
                Assert.fail("Request failed with status code: " + statusCode);
            }
        } catch (JSONException e) {
            updateTestResult(functionName, false, "Không tìm thấy product");
            Assert.fail(e.getMessage());
        } catch (Exception e) {
            updateTestResult(functionName, false, e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

}
