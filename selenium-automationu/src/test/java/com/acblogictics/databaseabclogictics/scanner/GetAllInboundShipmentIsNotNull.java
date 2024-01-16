package com.acblogictics.databaseabclogictics.scanner;

import com.acblogictics.databaseabclogictics.Url;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetAllInboundShipmentIsNotNull {
    final String neoURL = Url.url;
    @BeforeClass
    public void beforeClass() {
        // Thiết lập UID cho lớp kiểm tra
        Allure.getLifecycle().updateTestCase(tc -> tc.setUuid("unique-id-get-all-inbound-shipment-is-not-null"));
    }

    @Test(priority = 1, description = "update inbound receiving by scan product")
    @Step
    public void getAllInboundShipmentIsNotNull() {
        try {
            Thread.sleep(1000);
            HttpResponse<String> response = Unirest.get(neoURL + "/api/scan/get-all-inbound-shipment-is-not-null")
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
    @Test(priority = 2, description = "update inbound receiving by scan product wrong method")
    @Step
    public void getAllInboundShipmentIsNotNullWrongMethod() {
        try {
            Thread.sleep(1000);
            HttpResponse<String> response = Unirest.post(neoURL + "/api/scan/get-all-inbound-shipment-is-not-null")
                    .header("Content-Type", "application/json")
                    .header("Accept", "*/*")
                    .asString();
            JSONObject jsonObject = new JSONObject(response.getBody());
            String status = jsonObject.optString("statusCode", "Unknown");
            Assert.assertEquals("METHOD_NOT_ALLOWED", status);
        } catch (UnirestException | JSONException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

