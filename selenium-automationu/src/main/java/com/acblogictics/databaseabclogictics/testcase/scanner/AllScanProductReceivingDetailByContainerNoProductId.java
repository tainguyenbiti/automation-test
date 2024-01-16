package com.acblogictics.databaseabclogictics.testcase.scanner;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.apache.http.HttpStatus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AllScanProductReceivingDetailByContainerNoProductId{

    @Value("${production.path}")
    private String neoURL;

    private String containerNo_id = "1234";


    @Test
    public void testAllScanProductReceivingDetailByContainerNoProductId() {
        String functionName = "testAllScanProductReceivingDetailByContainerNoProductId";
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
                Assert.fail("Yêu cầu thất bại với mã trạng thái " + statusCode + ". Kết quả mong muốn là 200 OK.");
            }
        } catch (JSONException e) {
            Assert.fail("Không tìm thấy ProductReceiving");
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }


    @Test
    public void testAllScanProductReceivingDetailByContainerNoProductIdNull() {
        String functionName = "testAllScanProductReceivingDetailByContainerNoProductIdNull";
        try {
            HttpResponse<String> response = Unirest.get(neoURL + "/get-all-scan-receiving-product-by-container-no")
                    .asString();

            int statusCode = response.getStatus();
            if (statusCode == 400) {
                Assert.assertTrue(true);
            } else {
                Assert.fail("Yêu cầu thất bại với mã trạng thái " + statusCode + ". Kết quả mong muốn là 400 Bad Request." );
            }
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }


    @Test
    public void testAllScanProductReceivingDetailByContainerNoProductIdNotExistContainer() {
        String functionName = "testAllScanProductReceivingDetailByContainerNoProductIdNotExistContainer";
        try {
            HttpResponse<String> response = Unirest.get(neoURL + "/get-all-scan-receiving-product-by-container-no")
                    .queryString("containerNo", "0987654")
                    .queryString("productId", "15")
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
    public void testAllScanProductReceivingDetailByContainerNoProductIdNotExistProductId() {
        String functionName = "testAllScanProductReceivingDetailByContainerNoProductIdNotExistProductId";
        try {
            HttpResponse<String> response = Unirest.get(neoURL + "/get-all-scan-receiving-product-by-container-no")
                    .queryString("containerNo", containerNo_id)
                    .queryString("productId", "0987865")
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

}
