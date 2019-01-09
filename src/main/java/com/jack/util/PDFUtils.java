package com.jack.util;

import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;

/**
 * @Author: Jack
 * @Date: 2019/1/9 12:53
 */
public class PDFUtils {
    public static void main(String[] args) {
        File file = new File("F:/123.pdf");
        PDDocument document = null;
        try {
            document = PDDocument.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (document != null) {
            document.removePage(8);
        }
        System.out.println("Page one removed");
        try {
            if (document != null) {
                document.save("F:/123.pdf");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (document != null) {
                document.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}