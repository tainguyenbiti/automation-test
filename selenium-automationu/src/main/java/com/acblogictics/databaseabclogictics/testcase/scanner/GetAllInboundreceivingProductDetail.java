package com.acblogictics.databaseabclogictics.testcase.scanner;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.testng.Assert;
import org.testng.annotations.Test;


public class GetAllInboundreceivingProductDetail {
    @Value("${production.path}")
    private String neoURL;


    @Test(priority = 1)
    public void testGetAllInboundreceivingProductDetail() {
        String functionName = "testGetAllInboundreceivingProductDetail";
        try {
            HttpResponse<String> response = Unirest.get(neoURL + "/get-all-inboundreceivingproductdetail-by-container-no/{containerNo}")
                    .routeParam("containerNo", "1234")
                    .asString();

            int statusCode = response.getStatus();
            if (statusCode == 200) {
                JSONObject jsonResponse = new JSONObject(response.getBody());

                JSONObject dataObject = jsonResponse.getJSONObject("data");

                JSONArray inboundReceivingProductDetails = dataObject.getJSONArray("inboundReceivingProductDetails");
                if (inboundReceivingProductDetails.length() < 1) {
                    Assert.fail("ProductReceiving không có giá trị");
                } else {
                    Assert.assertTrue(true);
                }
            } else {
                Assert.fail("Yêu cầu thất bại với mã trạng thái " + statusCode + ". Kết quả mong muốn là 200 OK.");
            }
        } catch (JSONException e) {
            Assert.fail("Không tìm thấy được Product Receiving");
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }


    @Test(priority = 2)
    public void testGetAllInboundreceivingProductDetailNotExist() {
        String functionName = "testGetAllInboundreceivingProductDetailNotExist";
        try {
            HttpResponse<String> response = Unirest.get(neoURL + "/get-all-inboundreceivingproductdetail-by-container-no/{containerNo}")
                    .routeParam("containerNo", "1234214")
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


    @Test(priority = 3)
    public void testGetAllInboundreceivingProductDetailNull() {
        String functionName = "testGetAllInboundreceivingProductDetailNull";
        try {
            HttpResponse<String> response = Unirest.get(neoURL + "/get-all-inboundreceivingproductdetail-by-container-no")
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
