package com.jack.leetcode;

import java.util.Scanner;

/**
 * Created by Jack on 8/30/2018 4:42 PM
 * LeetCode 557
 */
public class ReverseStringArray3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(reverseString(s));
    }
    private static String reverseString(String s) {
        if (s==null||s.length()==0)
            return s;
        String []str=s.split(" ");
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<str.length;i++) {
            sb.append(new StringBuilder(str[i]).reverse());
            if (i!=str.length-1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
