package com.acblogictics.databaseabclogictics.util;

import java.io.IOException;

public class RunCMD {

    public static String run() throws IOException, InterruptedException {
        String[] cmd = {"cmd", "/c", "allure", "generate", "allure-results", "--clean", "-o", "src/main/resources/allure-report"};
        Process process = Runtime.getRuntime().exec(cmd);

        int exitCode = process.waitFor(); // Wait for the process to complete

        if (exitCode == 0) {
            return "success";
        } else {
            return "error";
        }
    }
}
