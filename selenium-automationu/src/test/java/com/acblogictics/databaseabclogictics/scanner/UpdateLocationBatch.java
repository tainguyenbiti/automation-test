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

public class UpdateLocationBatch {
    final String neoURL = Url.url;

    @Test(priority = 1, description = "update location batch")
    @Step("updateLocationBatch")
    public void updateLocationBatch() {
        String data = "{\n" +
                "  \"productId\": 45,\n" +
                "  \"containerNo\": 12345676543,\n" +
                "  \"actualMC\": 20.0,\n" +
                "  \"actualUC\": 0.0,\n" +
                "  \"totalUnit\": 0.0,\n" +
                "  \"locationBatches\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"batch\": {\n" +
                "        \"id\": null,\n" +
                "        \"batchNo\": null\n" +
                "      },\n" +
                "      \"location\": {\n" +
                "        \"id\": 1,\n" +
                "        \"locationNo\": \"LB1\",\n" +
                "        \"minCBM\": 0,\n" +
                "        \"maxCBM\": 0,\n" +
                "        \"status\": false,\n" +
                "        \"locationType\": null\n" +
                "      },\n" +
                "      \"actualQTY\": 20,\n" +
                "      \"palletCount\": 1\n" +
                "    }\n" +
                "  ]\n" +
                "}\n";
        try {
            Thread.sleep(1000);
            HttpResponse<String> response = Unirest.post(neoURL + "/api/scan/update-inbound-receiving-by-scan-product")
                    .header("Content-Type", "application/json")
                    .header("Accept", "*/*")
                    .body(data)
                    .asString();
            JSONObject jsonObject = new JSONObject(response.getBody());
            String status = jsonObject.optString("statusCode", "Unknown");
            Assert.assertEquals(status, "OK");
        } catch (UnirestException | JSONException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Test(priority = 2, description = "update location batch invalid")
    @Step("updateLocationBatchInvalidation")
    public void updateLocationBatchInvalidation() {
        String data = "{}";
        try {
            Thread.sleep(1000);
            HttpResponse<String> response = Unirest.post(neoURL + "/api/scan/update-inbound-receiving-by-scan-product")
                    .header("Content-Type", "application/json")
                    .header("Accept", "*/*")
                    .body(data)
                    .asString();
            JSONObject jsonObject = new JSONObject(response.getBody());
            String status = jsonObject.optString("statusCode", "Unknown");
            Assert.assertEquals(status, "INTERNAL_SERVER_ERROR");
        } catch (UnirestException | JSONException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
