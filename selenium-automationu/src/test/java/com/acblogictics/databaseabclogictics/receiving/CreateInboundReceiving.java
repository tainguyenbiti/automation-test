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

public class CreateInboundReceiving {
    final String neoURL = Url.url;

    @Test(priority = 1, description = "createInboundReceiving")
    public void createInboundReceiving() {
        String data = "{\n" +
                "   \"id\":null,\n" +
                "   \"customer\":{\n" +
                "      \"customerId\":1,\n" +
                "      \"customerNo\":\"A12312\",\n" +
                "      \"customerName\":\"Rose\",\n" +
                "      \"billing\":null\n" +
                "   },\n" +
                "   \"containerNo\":null,\n" +
                "   \"vessel\":null,\n" +
                "   \"masterBillOfLading\":\"\",\n" +
                "   \"eta\":null,\n" +
                "   \"etd\":null,\n" +
                "   \"refNo\":null,\n" +
                "   \"shipmentStatus\":\"Received\",\n" +
                "   \"shipFromAddress\":{\n" +
                "      \"id\":null,\n" +
                "      \"address1\":\"Viet nam\",\n" +
                "      \"address2\":\"\",\n" +
                "      \"city\":\"Đà Nẵng\",\n" +
                "      \"state\":\"Cẩm lệ`\",\n" +
                "      \"zipcode\":\"55500\",\n" +
                "      \"country\":\"VN\"\n" +
                "   },\n" +
                "   \"shipToAddress\":{\n" +
                "      \"id\":null,\n" +
                "      \"address1\":\"320 Corey Way\",\n" +
                "      \"address2\":\"\",\n" +
                "      \"city\":\"South San Francisco\",\n" +
                "      \"state\":\"CA\",\n" +
                "      \"zipcode\":\"94080\",\n" +
                "      \"country\":\"USA\"\n" +
                "   },\n" +
                "   \"user\":{\n" +
                "      \"userId\":null,\n" +
                "      \"username\":null,\n" +
                "      \"email\":null,\n" +
                "      \"firstName\":null,\n" +
                "      \"lastName\":null\n" +
                "   },\n" +
                "   \"lastUpdateBy\":\"admin\",\n" +
                "   \"note\":\"\",\n" +
                "   \"totalMc\":2.0,\n" +
                "   \"totalMcWeight\":0.0,\n" +
                "   \"totalMcCBM\":0.0,\n" +
                "   \"totalUnit\":2.0,\n" +
                "   \"inboundShipmentNo\":\"\",\n" +
                "   \"inboundReceivingNo\":\"\",\n" +
                "   \"inboundReceivingProductDetail\":[\n" +
                "      {\n" +
                "         \"id\":null,\n" +
                "         \"actualMC\":1.0,\n" +
                "         \"actualUc\":1.0,\n" +
                "         \"totalUnit\":1.0,\n" +
                "         \"totalMcWeight\":0.0,\n" +
                "         \"product\":{\n" +
                "            \"id\":42,\n" +
                "            \"productNo\":123,\n" +
                "            \"customer\":{\n" +
                "               \"customerId\":1,\n" +
                "               \"customerNo\":\"A12312\",\n" +
                "               \"customerName\":\"Rose\",\n" +
                "               \"billing\":{\n" +
                "                  \"billingId\":32,\n" +
                "                  \"name\":\"Rose\",\n" +
                "                  \"addressOne\":\"Viet nam\",\n" +
                "                  \"addressTwo\":\"\",\n" +
                "                  \"city\":\"Đà Nẵng\",\n" +
                "                  \"state\":\"Cẩm lệ`\",\n" +
                "                  \"zipCode\":\"55500\",\n" +
                "                  \"country\":\"VN\"\n" +
                "               }\n" +
                "            },\n" +
                "            \"name\":\"<script>   while (true) {     console.log(1);   } </script>\",\n" +
                "            \"upc\":123,\n" +

                "            \"skus\":[\n" +
                "               {\n" +
                "                  \"id\":46,\n" +
                "                  \"name\":123\n" +
                "               }\n" +
                "            ],\n" +
                "            \"status\":true,\n" +
                "            \"stockStatus\":true,\n" +
                "            \"color\":null,\n" +
                "            \"description\":null,\n" +
                "            \"note\":null,\n" +
                "            \"productPackaging\":{\n" +
                "               \"id\":58,\n" +
                "               \"size\":1,\n" +
                "               \"mcVolume\":null,\n" +
                "               \"mcNetWeight\":0,\n" +
                "               \"mcShipment\":0,\n" +
                "               \"mcLength\":0,\n" +
                "               \"mcWidth\":0,\n" +
                "               \"mcHeight\":0,\n" +
                "               \"uVolume\":0,\n" +
                "               \"uNetWeight\":0,\n" +
                "               \"uShipment\":0,\n" +
                "               \"uLength\":0,\n" +
                "               \"uWidth\":0,\n" +
                "               \"uHeight\":0\n" +
                "            },\n" +
                "            \"images\":[\n" +
                "\n" +
                "            ],\n" +
                "            \"inventory\":{\n" +
                "               \"id\":43,\n" +
                "               \"receivedMcQty\":2.0,\n" +
                "               \"onHandMcQty\":2.0,\n" +
                "               \"preFulfilledMcQty\":0.0,\n" +
                "               \"fulfilledMcQty\":0.0,\n" +
                "               \"receivedUnitQty\":2.0,\n" +
                "               \"onHandUnitQty\":2.0,\n" +
                "               \"preFulfilledUnitQty\":0.0,\n" +
                "               \"fulfilledUnitQty\":0.0\n" +
                "            }\n" +
                "         },\n" +
                "         \"tiXHi\":0.0,\n" +
                "         \"locationBatches\":[\n" +
                "            {\n" +
                "               \"id\":null,\n" +
                "               \"batch\":{\n" +
                "                  \"id\":null,\n" +
                "                  \"batchNo\":\"\"\n" +
                "               },\n" +
                "               \"location\":{\n" +
                "                  \"id\":1,\n" +
                "                  \"locationNo\":null,\n" +
                "                  \"minCBM\":0,\n" +
                "                  \"maxCBM\":0,\n" +
                "                  \"status\":false,\n" +
                "                  \"locationType\":null\n" +
                "               },\n" +
                "               \"actualQTY\":1,\n" +
                "               \"palletCount\":1\n" +
                "            }\n" +
                "         ],\n" +
                "         \"inboundReceiving\":null,\n" +
                "         \"expectedMC\":1.0,\n" +
                "         \"expectedUc\":1.0\n" +
                "      },\n" +
                "      {\n" +
                "         \"id\":null,\n" +
                "         \"actualMC\":1.0,\n" +
                "         \"actualUc\":1.0,\n" +
                "         \"totalUnit\":1.0,\n" +
                "         \"totalMcWeight\":0.0,\n" +
                "         \"product\":{\n" +
                "            \"id\":40,\n" +
                "            \"productNo\":\"No191234\",\n" +
                "            \"customer\":{\n" +
                "               \"customerId\":1,\n" +
                "               \"customerNo\":\"A12312\",\n" +
                "               \"customerName\":\"Rose\",\n" +
                "               \"billing\":{\n" +
                "                  \"billingId\":32,\n" +
                "                  \"name\":\"Rose\",\n" +
                "                  \"addressOne\":\"Viet nam\",\n" +
                "                  \"addressTwo\":\"\",\n" +
                "                  \"city\":\"Đà Nẵng\",\n" +
                "                  \"state\":\"Cẩm lệ`\",\n" +
                "                  \"zipCode\":\"55500\",\n" +
                "                  \"country\":\"VN\"\n" +
                "               }\n" +
                "            },\n" +
                "            \"name\":\"Name191234\",\n" +
                "            \"upc\":191234,\n" +

                "            \"skus\":[\n" +
                "               {\n" +
                "                  \"id\":44,\n" +
                "                  \"name\":191234\n" +
                "               }\n" +
                "            ],\n" +
                "            \"status\":true,\n" +
                "            \"stockStatus\":true,\n" +
                "            \"color\":null,\n" +
                "            \"description\":null,\n" +
                "            \"note\":null,\n" +
                "            \"productPackaging\":{\n" +
                "               \"id\":56,\n" +
                "               \"size\":1,\n" +
                "               \"mcVolume\":null,\n" +
                "               \"mcNetWeight\":0,\n" +
                "               \"mcShipment\":0,\n" +
                "               \"mcLength\":0,\n" +
                "               \"mcWidth\":0,\n" +
                "               \"mcHeight\":0,\n" +
                "               \"uVolume\":null,\n" +
                "               \"uNetWeight\":null,\n" +
                "               \"uShipment\":null,\n" +
                "               \"uLength\":null,\n" +
                "               \"uWidth\":null,\n" +
                "               \"uHeight\":null\n" +
                "            },\n" +
                "            \"images\":[\n" +
                "\n" +
                "            ],\n" +
                "            \"inventory\":{\n" +
                "               \"id\":41,\n" +
                "               \"receivedMcQty\":2.0,\n" +
                "               \"onHandMcQty\":2.0,\n" +
                "               \"preFulfilledMcQty\":0.0,\n" +
                "               \"fulfilledMcQty\":0.0,\n" +
                "               \"receivedUnitQty\":2.0,\n" +
                "               \"onHandUnitQty\":2.0,\n" +
                "               \"preFulfilledUnitQty\":0.0,\n" +
                "               \"fulfilledUnitQty\":0.0\n" +
                "            }\n" +
                "         },\n" +
                "         \"tiXHi\":0.0,\n" +
                "         \"locationBatches\":[\n" +
                "            {\n" +
                "               \"id\":null,\n" +
                "               \"batch\":{\n" +
                "                  \"id\":null,\n" +
                "                  \"batchNo\":\"\"\n" +
                "               },\n" +
                "               \"location\":{\n" +
                "                  \"id\":1,\n" +
                "                  \"locationNo\":null,\n" +
                "                  \"minCBM\":0,\n" +
                "                  \"maxCBM\":0,\n" +
                "                  \"status\":false,\n" +
                "                  \"locationType\":null\n" +
                "               },\n" +
                "               \"actualQTY\":1,\n" +
                "               \"palletCount\":1\n" +
                "            }\n" +
                "         ],\n" +
                "         \"inboundReceiving\":null,\n" +
                "         \"expectedMC\":1.0,\n" +
                "         \"expectedUc\":1.0\n" +
                "      }\n" +
                "   ],\n" +
                "   \"createdDate\":null,\n" +
                "   \"lastModifiedDate\":null\n" +
                "}\n";
        try {
            Thread.sleep(1000);
            HttpResponse<String> response = Unirest.post(neoURL + "/api/inbound/receiving/create")
                    .header("Content-Type", "application/json")
                    .body(data)
                    .asString();
            JSONObject jsonObject = new JSONObject(response.getBody());
            String status = jsonObject.optString("statusCode", "Unknown");
            System.out.println(jsonObject.optString("errorMessage"));

            Assert.assertEquals(status,"OK");
        } catch (UnirestException | JSONException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Test(priority = 2, description = "create inbound receiving invalid value")
    public void createInboundReceivingInvalidValue() {
        String data = "{}";
        try {
            Thread.sleep(1000);
            HttpResponse<String> response = Unirest.post(neoURL + "/api/inbound/receiving/create")
                    .header("Content-Type", "application/json")
                    .body(data)
                    .asString();
            JSONObject jsonObject = new JSONObject(response.getBody());
            String status = jsonObject.optString("statusCode", "Unknown");
            System.out.println(jsonObject.optString("errorMessage"));

            Assert.assertEquals(status,"INTERNAL_SERVER_ERROR");
        } catch (UnirestException | JSONException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
