package com.acblogictics.databaseabclogictics.testcase.scanner;

import com.github.javafaker.Faker;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.json.JSONObject;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.testng.Assert;
import org.testng.annotations.Test;

@SpringBootTest
@Rollback
public class CreateProductByUpcAndCustomerId  {

    String neoURL = "http://51.79.255.60:9280/api/scan";

    @Test
    public void testCreateProductByUpcAndCustomerId() {

        // Tạo một đối tượng Faker
        Faker faker = new Faker();

        // Sử dụng Faker để tạo dữ liệu giả mạo
        String productName = faker.food().ingredient();
        String customerId = "3";
        String upc = "upc" + faker.number().digits(9);

        try {
            HttpResponse<String> response = Unirest.post(neoURL + "/create-product-by-upc-and-customer-id")
                    .queryString("productName", productName)
                    .queryString("customerId", customerId)
                    .queryString("upc", upc)
                    .asString();

            int statusCode = response.getStatus();
            if (statusCode == 200) {
                JSONObject jsonResponse = new JSONObject(response.getBody());
                JSONObject dataObject = jsonResponse.getJSONObject("data");
                JSONObject product = dataObject.getJSONObject("product");
                Assert.assertTrue(true);

            } else {
                Assert.fail("Request failed with status code: " + statusCode);
            }
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }




//    @Test
//    public void testCreateProductByUpcAndCustomerIdNotExistCustomerId() {
//        String functionName = "testCreateProductByUpcAndCustomerIdNotExistCustomerId";
//        int length = 5;
//        String randomString = generateRandomString(length);
//        try {
//            HttpResponse<String> response = Unirest.post(neoURL + "/create-product-by-upc-and-customer-id")
//                    .queryString("productName", "sản phẩm")
//                    .queryString("customerId", "37")
//                    .queryString("upc", randomString)
//                    .asString();
//
//            int statusCode = response.getStatus();
//            if (statusCode == 400) {
//                updateTestResult(functionName, true, "");
//                Assert.assertTrue(true);
//            } else {
//                updateTestResult(functionName, false, "Request failed with status code: " + statusCode);
//                Assert.fail("Request failed with status code: " + statusCode);
//            }
//        } catch (Exception e) {
//            updateTestResult(functionName, false, e.getMessage());
//            Assert.fail(e.getMessage());
//        }
//    }
//
//
//    @Test
//    public void testCreateProductByUpcAndCustomerIdNull() {
//        String functionName = "testCreateProductByUpcAndCustomerIdNull";
//        int length = 5;
//        String randomString = generateRandomString(length);
//        try {
//            HttpResponse<String> response = Unirest.post(neoURL + "/create-product-by-upc-and-customer-id")
//                    .queryString("productName", "sản phẩm")
//                    .queryString("customerId", "3")
//                    .asString();
//
//            int statusCode = response.getStatus();
//            if (statusCode == 400) {
//                updateTestResult(functionName, true, "");
//                Assert.assertTrue(true);
//            } else {
//                updateTestResult(functionName, false, "Request failed with status code: " + statusCode);
//                Assert.fail("Request failed with status code: " + statusCode);
//            }
//        } catch (Exception e) {
//            updateTestResult(functionName, false, e.getMessage());
//            Assert.fail(e.getMessage());
//        }
//    }
//
//
//    @Test
//    public void testCreateProductByUpcAndCustomerIdExist() {
//        String functionName = "testCreateProductByUpcAndCustomerIdExist";
//        int length = 5;
//        String randomString = generateRandomString(length);
//        try {
//            HttpResponse<String> response = Unirest.post(neoURL + "/create-product-by-upc-and-customer-id")
//                    .queryString("productName", "sản phẩm")
//                    .queryString("customerId", "3")
//                    .queryString("upc", "upc1111111")
//                    .asString();
//
//            int statusCode = response.getStatus();
//            if (statusCode == 400) {
//                updateTestResult(functionName, true, "");
//                Assert.assertTrue(true);
//            } else {
//                updateTestResult(functionName, false, "Request failed with status code: " + statusCode);
//                Assert.fail("Request failed with status code: " + statusCode);
//            }
//        } catch (Exception e) {
//            updateTestResult(functionName, false, e.getMessage());
//            Assert.fail(e.getMessage());
//        }
//    }

}
