package com.acblogictics.databaseabclogictics.testcase.scanner;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.testng.Assert;
import org.testng.annotations.Test;




public class GetAllReceivingByDate{

    @Value("${production.path}")
    private String neoURL;
    @Test
    public void testGetAllReceivingByDate() {
        String functionName = "testGetAllReceivingByDate";
        try {
            HttpResponse<String> response = Unirest.get(neoURL + "/get-all-receiving-by-date")
                    .queryString("date", "2023")
                    .asString();

            int statusCode = response.getStatus();
            if (statusCode == 200) {
                JSONObject jsonResponse = new JSONObject(response.getBody());

                JSONObject dataObject = jsonResponse.getJSONObject("data");

                JSONArray inboundReceivings = dataObject.getJSONArray("inboundReceivings");
                if (inboundReceivings.length() < 1) {
                    Assert.fail("ProductReceiving không có giá trị");
                } else {
                    Assert.assertTrue(true);
                }
            } else {
                Assert.fail("Yêu cầu thất bại với mã trạng thái " + statusCode + ". Kết quả mong muốn là 200 OK.");
            }
        } catch (JSONException e) {
            Assert.fail("Không tìm thấy được Receiving");
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }


    @Test
    public void testGetAllReceivingByDateNotExist() {
        String functionName = "testGetAllReceivingByDateNotExist";
        try {
            HttpResponse<String> response = Unirest.get(neoURL + "/get-all-receiving-by-date")
                    .queryString("date", "2022")
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
    public void testGetAllReceivingByDateNull() {
        String functionName = "testGetAllReceivingByDateNull";
        try {
            HttpResponse<String> response = Unirest.get(neoURL + "/get-all-receiving-by-date")
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
