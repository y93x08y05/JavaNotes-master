package com.jack.leetcode;

/**
 * Created by Jack on 8/28/2018 10:19 PM
 * LeetCode 334
 */
public class ReverseStringArray {
    public static void main(String[] args) {
        String s="A man, a plan, a canal: Panama";
        System.out.println(reverseString(s));
    }
    private static String reverseString(String s) {
        if (s==" ")
            return " ";
        String []str=s.split(" ");
        StringBuilder sb=new StringBuilder();
        for (int i=str.length-1;i>=0;i--) {
            for (int j=str[i].length()-1;j>=0;j--) {
                sb.append(str[i].charAt(j));
            }
            if (i!=0)
                sb.append(" ");
        }
        return sb.toString();
    }
}
