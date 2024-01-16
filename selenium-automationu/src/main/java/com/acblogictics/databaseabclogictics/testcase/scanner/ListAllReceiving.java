package com.acblogictics.databaseabclogictics.testcase.scanner;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import org.springframework.beans.factory.annotation.Value;
import org.testng.Assert;
import org.testng.annotations.Test;



public class ListAllReceiving {

    @Value("${production.path}")
    private String neoURL;


    @Test
    public void testGetAllReceivingWithContainerNotNull() {
        String functionName = "testGetAllReceivingWithContainerNotNull";
        try {
            HttpResponse<String> response = Unirest.get(neoURL + "/get-all-receiving-with-container-not-null")
                    .asString();

            int statusCode = response.getStatus();
            if (statusCode == 200) {
                JSONObject jsonResponse = new JSONObject(response.getBody());

                JSONObject dataObject = jsonResponse.getJSONObject("data");

                JSONArray inboundReceivings = dataObject.getJSONArray("inboundReceivings");
                if (inboundReceivings.length() < 1) {
                    Assert.fail("InboundReceivings không có giá trị");
                } else {
                    Assert.assertTrue(true);
                }
            } else {
                Assert.fail("Yêu cầu thất bại với mã trạng thái " + statusCode + ". Kết quả mong muốn là 200 OK.");
            }
        } catch (JSONException e) {
            Assert.fail("Không tìm thấy được Receving");
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }


}