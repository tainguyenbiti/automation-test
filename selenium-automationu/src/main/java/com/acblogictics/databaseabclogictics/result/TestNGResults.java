package com.acblogictics.databaseabclogictics.result;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestNGResults {
    public static TestResults create(TestListenerAdapter tla) {
        TestResults results = new TestResults();
        addTestStatus(tla.getPassedTests(), results, "passed");
        addTestStatus(tla.getFailedTests(), results, "failed");
        addTestStatus(tla.getSkippedTests(), results, "skipped");
        return results;
    }

    private static void addTestStatus(List<ITestResult> testResults, TestResults results, String status) {
        for (ITestResult testResult : testResults) {
            String testName = getTestName(testResult);
            String className = getClassName(testResult);
            TestResultDetail resultDetail = new TestResultDetail();

            String simpleClassName = className.substring(className.lastIndexOf('.') + 1);

            // Get or create a map for the test class
            Map<String, TestResultDetail> classTestStatus = results.getTestStatus().computeIfAbsent(simpleClassName, k -> new HashMap<>());

            resultDetail.setMethod(testResult.getMethod().getConstructorOrMethod().getMethod().getName());
            if(testResult.getThrowable() != null){
                resultDetail.setReason(testResult.getThrowable().getMessage());
            }
            resultDetail.setTestStatus(status);
            resultDetail.setStart(testResult.getStartMillis());
            resultDetail.setEnd(testResult.getEndMillis());

            resultDetail.setParentName(simpleClassName);
            classTestStatus.put(testName, resultDetail);

            // Update the overall counts
            results.updateCount(status);
        }
    }

    private static String getTestName(ITestResult testResult) {
        return testResult.getMethod().getMethodName();
    }

    private static String getClassName(ITestResult testResult) {
        return testResult.getTestClass().getName();
    }
}