package com.jack.leetcode;

import java.util.Scanner;

/**
 * Created by Jack on 8/19/2018 10:06 PM
 * LeetCode 43
 * two String multiply and return a new String
 */
public class StringMultiply {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(computeStringMultiply(s1, s2));
    }
    private static String computeStringMultiply(String s1,String s2) {
        int len1=s1.length();
        int len2=s2.length();
        int d1,d2;
        int carry=0;
        int temp;
        int [] calculate=new int[len1+len2];
        StringBuilder sb = new StringBuilder();
        for (int i=len1-1;i>=0;i--) {
            d1=s1.charAt(i)-'0';
            for (int j=len2-1;j>=0;j--) {
                d2=s2.charAt(j)-'0';
                calculate[i+j+1]+=d1*d2;
            }
        }
        for (int i=calculate.length-1;i>=0;i--) {
            temp=(calculate[i]+carry)%10;
            carry=(calculate[i]+carry)/10;
            calculate[i]=temp;
        }
        for (int num:calculate)
            sb.append(num);
        while (sb.length()>1&&sb.charAt(0)=='0')
            sb.deleteCharAt(0);
        return sb.toString();
    }
}
