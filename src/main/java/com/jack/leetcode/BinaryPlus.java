package com.jack.leetcode;

import java.util.Scanner;

/**
 * Created by Jack on 8/7/2018 11:09 AM
 * LeetCode 67
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 输入为非空字符串且只包含数字 1 和 0。
 * 例1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 例2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
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
