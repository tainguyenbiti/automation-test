package com.acblogictics.databaseabclogictics.service;

import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class FolderService {

    public boolean deleteFolder(String folderPath) {
        File folder = new File(folderPath);
        return deleteRecursive(folder);
    }

    private boolean deleteRecursive(File file) {
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
