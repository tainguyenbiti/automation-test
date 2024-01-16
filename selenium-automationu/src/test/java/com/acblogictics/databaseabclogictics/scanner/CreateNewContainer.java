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

public class CreateNewContainer {
    final String neoURL = Url.url;

    @Test(priority = 1, description = "create new container")
    @Step("createNewContainer")
    public void createNewContainer() {
        String data = "{\n" +
                "  \"id\": null,\n" +
                "  \"customer\": {\n" +
                "    \"customerId\": 99,\n" +
                "    \"customerNo\": null,\n" +
                "    \"customerName\": null,\n" +
                "    \"billing\": null\n" +
                "  },\n" +
                "  \"containerNo\": 221223,\n" +
                "  \"vessel\": null,\n" +
                "  \"masterBillOfLading\": null,\n" +
                "  \"eta\": null,\n" +
                "  \"etd\": null,\n" +
                "  \"refNo\": null,\n" +
                "  \"shipmentStatus\": null,\n" +
                "  \"shipFromAddress\": null,\n" +
                "  \"shipToAddress\": {\n" +
                "    \"id\": null,\n" +
                "    \"address1\": \"320 Corey Way\",\n" +
                "    \"address2\": null,\n" +
                "    \"city\": \"South San Francisco\",\n" +
                "    \"state\": \"CA\",\n" +
                "    \"zipcode\": 94080,\n" +
                "    \"country\": \"USA\"\n" +
                "  },\n" +
                "  \"user\": {\n" +
                "    \"userId\": \"com.acblogictics.databaseabclogictics.service.dto.UserDto@45f9c4bd\"\n" +
                "  },\n" +
                "  \"lastUpdateBy\": null,\n" +
                "  \"note\": null,\n" +
                "  \"totalMc\": 0.0,\n" +
                "  \"totalMcWeight\": 0.0,\n" +
                "  \"totalMcCBM\": 0.0,\n" +
                "  \"totalUnit\": 0.0,\n" +
                "  \"inboundShipmentNo\": null,\n" +
                "  \"inboundReceivingNo\": null,\n" +
                "  \"inboundReceivingProductDetail\": null,\n" +
                "  \"createdDate\": null,\n" +
                "  \"lastModifiedDate\": null\n" +
                "}\n";
        try {
            Thread.sleep(1000);
            HttpResponse<String> response = Unirest.post(neoURL + "/api/scan/update-inbound-receiving-by-scan-product")
                    .header("Content-Type", "application/json")
                    .header("Accept", "*/*")
                    .body(data)
                    .asString();
            JSONObject jsonObject = new JSONObject(response.getBody());
            System.out.println(jsonObject.optString("status", "Unknown"));
            String status = jsonObject.optString("statusCode", "Unknown");
            Assert.assertEquals(status, "OK");
        } catch (UnirestException | JSONException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Test(priority = 2, description = "create new container invalid value")
    @Step("createNewContainerInvalidValue")
    public void createNewContainerInvalidValue() {
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
