package com.acblogictics.databaseabclogictics.receiving;

import com.acblogictics.databaseabclogictics.Url;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.qameta.allure.Step;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetListReceiving {
    final String neoURL = Url.url;

    @Test(priority = 1, description = "getListReceiving")
    public void getListReceiving() {
        try {
            Thread.sleep(1000);
            HttpResponse<String> response = Unirest.get(neoURL + "/api/inbound/receivings")
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
}
