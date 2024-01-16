package com.acblogictics.databaseabclogictics.receiving;

import com.acblogictics.databaseabclogictics.Url;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.qameta.allure.Step;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GetInboundReceivingById {
    final String neoURL = Url.url;
    @Test(priority = 1, description = "get inbound receiving by id")
    @Parameters({"containerNo"})
    public void GetInboundReceivingById(String containerNo) {
        try {
            Thread.sleep(1000);
            HttpResponse<String> response = Unirest.get(neoURL + "/api/inbound/receiving/" + containerNo)
                    .header("Content-Type", "application/json")
                    .header("Accept", "*/*")
                    .asString();
            System.out.println(response);
            JSONObject jsonObject = new JSONObject(response.getBody());
            String status = jsonObject.optString("statusCode", "Unknown");
            Assert.assertEquals("OK", status);
        } catch (UnirestException | JSONException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Test(priority = 2, description = "get inbound receiving by invalid id")
    public void getInboundReceivingByInvalidId() {
        String id = "1123123";
        try {
            Thread.sleep(1000);
            HttpResponse<String> response = Unirest.get(neoURL + "/api/inbound/receiving/" + id)
                    .header("Content-Type", "application/json")
                    .header("Accept", "*/*")
                    .asString();
            JSONObject jsonObject = new JSONObject(response.getBody());
            String status = jsonObject.optString("statusCode", "Unknown");
            Assert.assertEquals(status, "NOT_FOUND");
        } catch (UnirestException | JSONException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
//    @Test(priority = 3, description = "get inbound shipment by none id")
//    public void GetInboundShipmentByNoneId() {
//        String id = "";
//        try {
//            Thread.sleep(1000);
//            HttpResponse<String> response = Unirest.get(neoURL + "/api/inbound/shipment/" + id)
//                    .header("Content-Type", "application/json")
//                    .header("Accept", "*/*")
//                    .asString();
//            JSONObject jsonObject = new JSONObject(response.getBody());
//            String status = jsonObject.optString("statusCode", "Unknown");
//            Assert.assertEquals("INTERNAL_SERVER_ERROR","OK");
//        } catch (UnirestException | JSONException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
