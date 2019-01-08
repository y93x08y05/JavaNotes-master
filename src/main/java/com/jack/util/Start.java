package com.jack.util;

/**
 * @Author: Jack
 * @Date: 2018/12/24 22:20
 */
public class Start {
    public static StringBuilder sb = new StringBuilder();
    public static void begin(String str) {
        for (int i = 0; i < 5; i++) {
            sb.append("1000,");
            sb.append("def");
            sb.append("\n");
        }
        String path = str + ".txt";
        FileUtils.saveFile(sb.toString(), path);
    }
}