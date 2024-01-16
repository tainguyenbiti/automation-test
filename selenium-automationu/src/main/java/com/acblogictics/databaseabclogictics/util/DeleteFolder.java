package com.acblogictics.databaseabclogictics.util;

import com.acblogictics.databaseabclogictics.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;

public class DeleteFolder {

    public static boolean deleteFolder() {
        String[] folderPaths = {"src/main/resources/allure-report", "allure-results", "src/main/resources/result"};
        for (String folderPath : folderPaths){
            File folder = new File(folderPath);
            deleteRecursive(folder);
        }
        return true;
    }

    private static boolean deleteRecursive(File file) {
        if (!file.exists()) {
            return true;
        }

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File subFile : files) {
                    if (!deleteRecursive(subFile)) {
                        return false;
                    }
                }
            }
        }

        return file.delete();
    }
}
