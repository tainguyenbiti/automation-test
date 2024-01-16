package com.acblogictics.databaseabclogictics.util;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestNGXmlGeneratorMethod {


    public static void generateXmlForMethod(String testPackage, String methodName) throws ClassNotFoundException {
        List<String> classNames = getTestClassNames(testPackage);

        if (classNames.isEmpty()) {
            System.out.println("No test classes found in the specified package: " + testPackage);
            return;
        }

        generateXmlForMethod(classNames, methodName);
    }

    private static List<String> getTestClassNames(String packageName) throws ClassNotFoundException {
        String packagePath = packageName.replace(".", File.separator);
        File packageDirectory = new File("src/main/java/" + packagePath);

        return Stream.of(packageDirectory.listFiles())
                .filter(file -> file.isFile() && file.getName().endsWith(".java"))
                .map(file -> packageName + "." + file.getName().replace(".java", ""))
                .filter(TestNGXmlGeneratorMethod::isTestClass)
                .collect(Collectors.toList());
    }

    private static boolean isTestClass(String className) {
        try {
            Class<?> clazz = Class.forName(className);
            return Stream.of(clazz.getDeclaredMethods())
                    .anyMatch(method -> method.isAnnotationPresent(Test.class));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static List<String> getTestMethods(Class<?> testClass) {
        return Stream.of(testClass.getDeclaredMethods())
                .filter(method -> method.isAnnotationPresent(Test.class))
                .map(method -> method.getName())
                .collect(Collectors.toList());
    }

    private static void generateXmlForMethod(List<String> classNames, String methodName) {
        StringBuilder xmlContent = new StringBuilder();
        xmlContent.append("<!DOCTYPE suite SYSTEM \"http://testng.org/testng-1.0.dtd\">\n");
        xmlContent.append("<suite name=\"Test Api Detail\">\n");

        classNames.forEach(className -> {
            try {
                Class<?> clazz = Class.forName(className);
                List<String> methods = getTestMethods(clazz);
                if (methods.contains(methodName)) {
                    String simpleClassName = className.substring(className.lastIndexOf('.') + 1);
                    xmlContent.append(String.format("<test name=\"%s\">\n", simpleClassName));
                    xmlContent.append("<classes>\n");
                    xmlContent.append(String.format("<class name=\"%s\">\n", className));
                    xmlContent.append("<methods>\n");
                    xmlContent.append(String.format("<include name=\"%s\" />\n", methodName));
                    xmlContent.append("</methods>\n");
                    xmlContent.append("</class>\n");
                    xmlContent.append("</classes>\n");
                    xmlContent.append("</test>\n");
                }
            } catch (ClassNotFoundException e) {
                System.err.println("Class not found: " + e.getMessage());
            }
        });

        xmlContent.append("</suite>");

        // Lưu nội dung vào file XML
        String xmlFilePath = "testxml/test_api.xml";
        try {
            saveXmlContentToFile(xmlContent.toString(), xmlFilePath);
        } catch (IOException e) {
            System.err.println("Error saving XML content to file: " + e.getMessage());
        }
    }


    private static void saveXmlContentToFile(String xmlContent, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(xmlContent);
            System.out.println("XML content has been successfully saved to: " + filePath);
        }
    }
}
