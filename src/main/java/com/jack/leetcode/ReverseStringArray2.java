package com.jack.leetcode;

import java.util.Scanner;

/**
 * Created by Jack on 8/30/2018 2:09 PM
 * LeetCode 541
 * abcdefg 2
 */
public class ReverseStringArray2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int k=sc.nextInt();
        System.out.println(reverseString(s, k));
        System.out.println(reverseString("abcd"));
    }
    private static String reverseString(String s,int k) {
        int len=s.length();
        String result="";
        for (int i=0;i<len;i+=2*k) {
            if (len-i<k) {
                String temp=new StringBuilder(s.substring(i,len)).reverse().toString();
                result+=temp;
            } else if (len-i<2*k&&len-i>=k) {
                String temp=new StringBuilder(s.substring(i,i+k)).reverse().toString();
                result+=temp+s.substring(i+k,len);
            } else {
                String temp=new StringBuilder(s.substring(i,i+k)).reverse().toString();
                result+=temp+s.substring(i+k,i+2*k);
            }
        }
        return result;
    }
    private static String reverseString(String s) {
        String result = "";
        int len = s.length();
        for (int i = 0; i < len; i++)
            result = s.charAt(i) + result;
        return result;
    }
}
