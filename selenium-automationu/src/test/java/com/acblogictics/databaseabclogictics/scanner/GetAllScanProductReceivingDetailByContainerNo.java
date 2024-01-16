package com.acblogictics.databaseabclogictics.scanner;

import com.acblogictics.databaseabclogictics.Url;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.qameta.allure.Step;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetAllScanProductReceivingDetailByContainerNo {
    final String neoURL = Url.url;

    @Test(priority = 1, description = "get all scan receiving product by container")
    @Step("GetAllScanProductReceivingDetailByContainerNo")
    public void getAllScanProductReceivingDetailByContainerNo() {
        int containerNo = 1234;
        try {
            Thread.sleep(1000);
            HttpResponse<String> response = Unirest.get(neoURL + "/api/scan/get-all-scan-receiving-product-by-container/" + containerNo)
                    .header("Content-Type", "application/json")
                    .header("Accept", "*/*")
                    .asString();
            JSONObject jsonObject = new JSONObject(response.getBody());
            String status = jsonObject.optString("statusCode", "Unknown");
            Assert.assertEquals("OK", status);
        } catch (UnirestException | JSONException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Test(priority = 2, description = "get all scan receiving product by container invalid parameters")
    public void getAllScanProductReceivingDetailByContainerNoInvalidParam() {
        String containerNo = "123123123312";
        try {
            Thread.sleep(1000);
            HttpResponse<String> response = Unirest.get(neoURL + "/api/scan/get-all-scan-receiving-product-by-container/"  + containerNo)
                    .header("Content-Type", "application/json")
                    .header("Accept", "*/*")
                    .asString();
            JSONObject jsonObject = new JSONObject(response.getBody());
            String status = jsonObject.optString("statusCode", "Unknown");
            Assert.assertEquals("BAD_REQUEST", status);
        } catch (UnirestException | JSONException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
