package com.jack.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author: Jack
 * @Date: 2018/12/24 22:23
 */
public class FileUtils {
    public static void main(String[] args) {
        FileUtils fileUtils = new FileUtils();
        fileUtils.deleteZip("C:/Users/10648/Downloads/");
    }
    private void deleteZip(String path) {
        File file = new File(path);
        File temp;
        File[] fileList = file.listFiles();
        for (File aFileList : fileList != null ? fileList : new File[0]) {
            temp = aFileList;
            if (temp.getName().endsWith("zip")) {
                System.out.println(temp.getName());
                temp.delete();
            }
        }
    }
    public static StringBuilder sb = new StringBuilder();
    public static void saveFile(String str, String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileWriter writer;
        try {
            writer = new FileWriter(file);
            writer.write(str);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}