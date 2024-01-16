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


public class GetAllProductByContainerNo {
    final String neoURL = Url.url;

    @Test(priority = 1, description = "getAllProductByContainerNo")
    @Step("getAllProductByContainerNo")
    public void getAllProductByContainerNo() {
        int containerNo = 1234;
        try {
            Thread.sleep(1000);
            HttpResponse<String> response = Unirest.get(neoURL + "/api/scan/get-all-product-by-container-no/" + containerNo)
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
    @Test(priority = 2, description = "getAllProductByInvalidContainerNo")
    @Step("getAllProductByInvalidContainerNo")
    public void getAllProductByInvalidContainerNo() {
        String containerNo = "abc";
        try {
            Thread.sleep(1000);
            HttpResponse<String> response = Unirest.get(neoURL + "/api/scan/get-all-product-by-container-no/" + containerNo)
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
    @Test(priority = 3, description = "getAllProductByContainerNo")
    @Step("getAllProductByNoneContainerNo")
    public void getAllProductByNoneContainerNo() {
        try {
            Thread.sleep(1000);
            HttpResponse<String> response = Unirest.get(neoURL + "/api/scan/get-all-product-by-container-no/")
                    .header("Content-Type", "application/json")
                    .header("Accept", "*/*")
                    .asString();
            JSONObject jsonObject = new JSONObject(response.getBody());
            String status = jsonObject.optString("status", "Unknown");
            Assert.assertEquals("404", status);
        } catch (UnirestException | JSONException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
