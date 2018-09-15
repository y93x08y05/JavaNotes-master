package com.jack.nowcoder.autumn.weipinhui;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/15 18:58
 * 二进制字符串相加
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] str = sc.nextLine().split(" ");
        System.out.println(addTwoBinaryString(str[0], str[1]));
    }
    private static String addTwoBinaryString(String a, String b) {
        int maxLen = Math.max(a.length(),b.length());
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i=0;i<maxLen;i++) {
            int tmp1 = a.length() > i ? a.charAt(a.length() - i - 1) - '0' : 0;
            int tmp2 = b.length() > i ? b.charAt(b.length() - i - 1) - '0' : 0;
            sb.insert(0,(tmp1+tmp2+carry)%2);
            carry = tmp1 + tmp2 + carry > 1 ? 1 : 0;
        }
        if (carry == 1)
            sb.insert(0,1);
        return sb.toString();
    }
}