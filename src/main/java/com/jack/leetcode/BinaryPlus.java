package com.jack.leetcode;

import java.util.Scanner;

/**
 * Created by Jack on 8/7/2018 11:09 AM
 * LeetCode 67
 * give two binary string and add two string and return
 * string only include 0 and 1
 */
public class BinaryPlus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] str = sc.nextLine().split(" ");
        System.out.println(addBinary(str[0], str[1]));
    }
    private static String addBinary(String a,String b) {
        int maxLen = Math.max(a.length(),b.length());
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i=0;i<maxLen;i++) {
            int temp1 = a.length() > i ? a.charAt(a.length() - i - 1) - '0' : 0;
            int temp2 = b.length() > i ? b.charAt(b.length() - i - 1) - '0' : 0;
            sb.insert(0,(temp1+temp2+carry)%2);
            carry = temp1 + temp2 + carry > 1 ? 1 : 0;
        }
        if (carry == 1)
            sb.insert(0,1);
        return sb.toString();
    }
}
