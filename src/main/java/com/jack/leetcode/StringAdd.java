package com.jack.leetcode;

import java.util.Scanner;

/**
 * Created by Jack on 8/19/2018 10:20 PM
 * LeetCode 415
 * two String add and return a new String
 */
public class StringAdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(computeStringAdd(s1, s2));
    }
    private static String computeStringAdd(String s1, String s2) {
        int i=s1.length()-1;
        int j=s2.length()-1;
        int carry=0;
        String res="";
        while (i>=0||j>=0) {
            if (i>=0)
                carry+=s1.charAt(i--)-'0';
            if (j>=0)
                carry+=s2.charAt(j--)-'0';
            res=Integer.toString(carry%10)+res;
            carry/=10;
        }
        return carry!=0?"1"+res:res;
    }
}
