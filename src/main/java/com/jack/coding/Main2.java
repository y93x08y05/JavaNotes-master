package com.jack.coding;

/**
 * Created by Jack on 7/30/2018 8:03 PM
 * replace String space as "%20"
 */
public class Main2 {
    public static String str = "We Are Happy";
    public static void main(String[] args) {
        System.out.println(replaceSpace(str));
    }
    public static String replaceSpace(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<str.length();i++) {
            if (str.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
