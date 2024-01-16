package com.acblogictics.databaseabclogictics.product;

import com.acblogictics.databaseabclogictics.Url;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.qameta.allure.Allure;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GetProductByUPC {
    final String neoURL = Url.url;
    @BeforeClass
    public void beforeClass() {
        // Thiết lập UID cho lớp kiểm tra
        Allure.getLifecycle().updateTestCase(tc -> tc.setUuid("unique-id-get-product-by-upc"));
    }
    @Test
    @Parameters({"productUPC", "containerNo"})
    public void getProductByUPC(String productUPC, String containerNo) {
        try {
            Thread.sleep(1000);
            HttpResponse<String> response = Unirest.get(neoURL + "/api/product/get-product-by-upc?upc=" + productUPC + "&containerNo=" + containerNo)
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
}
