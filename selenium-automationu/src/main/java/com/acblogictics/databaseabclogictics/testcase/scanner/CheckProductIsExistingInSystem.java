package com.acblogictics.databaseabclogictics.testcase.scanner;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.testng.Assert;
import org.testng.annotations.Test;




public class CheckProductIsExistingInSystem {

    @Value("${production.path}")
    private String neoURL;

    @Test
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
                Assert.assertTrue(true);
            } else {
                Assert.fail("Yêu cầu thất bại với mã trạng thái " + statusCode + ". Kết quả mong muốn là 200 OK.");
            }
        } catch (JSONException e) {
            Assert.fail("không tìm được giá trị product");
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }


    @Test
    public void testCheckProductIsExistingInSystemNotExistCustomerId() {
        String functionName = "testCheckProductIsExistingInSystemNotExistCustomerId";
        try {
            HttpResponse<String> response = Unirest.post(neoURL + "/check-product-is-existing-in-system")
                    .queryString("customerId", "37")
                    .queryString("upc", "upc1111111")
                    .asString();

            int statusCode = response.getStatus();
            if (statusCode == 400) {
                Assert.assertTrue(true);
            } else {
                Assert.fail("Yêu cầu thất bại với mã trạng thái " + statusCode + ". Kết quả mong muốn là 400 Bad Request.");
            }
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }


    @Test
    public void testCheckProductIsExistingInSystemNullUPC() {
        String functionName = "testCheckProductIsExistingInSystemNullUPC";
        try {
            HttpResponse<String> response = Unirest.post(neoURL + "/check-product-is-existing-in-system")
                    .queryString("customerId", "3")
                    .asString();

            int statusCode = response.getStatus();
            if (statusCode == 400) {
                Assert.assertTrue(true);
            } else {
                Assert.fail("Yêu cầu thất bại với mã trạng thái " + statusCode + ". Kết quả mong muốn là 400 Bad Request.");
            }
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }


    @Test
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
                Assert.assertTrue(true);
            } else {
                Assert.fail("Yêu cầu thất bại với mã trạng thái " + statusCode + ". Kết quả mong muốn là 200 OK.");
            }
        } catch (JSONException e) {
            Assert.fail("Không tìm thấy được product");
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

}
