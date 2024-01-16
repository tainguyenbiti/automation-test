package com.acblogictics.databaseabclogictics.testcase.scanner;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.testng.Assert;
import org.testng.annotations.Test;




public class ListAllScanProductReceivingDetailByContainerNo{

    @Value("${production.path}")
    private String neoURL;

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
                    Assert.fail("ProductReceiving không có giá trị");
                } else {
                    Assert.assertTrue(true);
                }
            } else {
                Assert.fail("Yêu cầu thất bại với mã trạng thái " + statusCode + ". Kết quả mong muốn là 200 OK.");
            }
        } catch (JSONException e) {
            Assert.fail("Không tìm thấy được Scan Product Receiving");
        } catch (Exception e) {
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
                Assert.assertTrue(true);
            } else {
                Assert.fail("Yêu cầu thất bại với mã trạng thái " + statusCode + ". Kết quả mong muốn là 400 Bad Request.");
            }
        } catch (Exception e) {
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
                Assert.assertTrue(true);
            } else {
                Assert.fail("Yêu cầu thất bại với mã trạng thái " + statusCode + ". Kết quả mong muốn là 404 Not Found.");
            }
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }


}
