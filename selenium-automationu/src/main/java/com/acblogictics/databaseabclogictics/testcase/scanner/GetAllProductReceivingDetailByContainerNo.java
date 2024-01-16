package com.acblogictics.databaseabclogictics.testcase.scanner;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.testng.Assert;
import org.testng.annotations.Test;



public class GetAllProductReceivingDetailByContainerNo {

    @Value("${production.path}")
    private String neoURL;

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
                    Assert.fail("ProductReceiving không có giá trị");
                } else {
                    Assert.assertTrue(true);
                }
            } else {
                Assert.fail("Yêu cầu thất bại với mã trạng thái " + statusCode + ". Kết quả mong muốn là 200 OK.");
            }
        } catch (JSONException e) {
            Assert.fail("Không tìm thấy Product Receiving");
        } catch (Exception e) {
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
                Assert.assertTrue(true);
            } else {
                Assert.fail("Yêu cầu thất bại với mã trạng thái " + statusCode + ". Kết quả mong muốn là 400 Bad Request.");
            }
        } catch (Exception e) {
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
                Assert.assertTrue(true);
            } else {
                Assert.fail("Yêu cầu thất bại với mã trạng thái " + statusCode + ". Kết quả mong muốn là 404 Not Found.");
            }
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

}
