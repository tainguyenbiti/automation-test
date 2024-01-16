package com.acblogictics.databaseabclogictics.config;

import org.testng.TestNG;

import java.util.Collections;
import java.util.List;

public class TestNGConfiguration {
    public static TestNG configure(String xmlFilePath) {
        TestNG testng = new TestNG();
        configureTestNG(testng, xmlFilePath);
        return testng;
    }

    private static void configureTestNG(TestNG testng, String xmlFilePath) {
        List<String> suiteFiles = Collections.singletonList(xmlFilePath);
        testng.setTestSuites(suiteFiles);
    }
}
