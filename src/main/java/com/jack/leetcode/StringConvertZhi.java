package com.jack.leetcode;

import java.util.Scanner;

/**
 * Created by Jack on 8/18/2018 9:26 AM
 * LeetCode 6
 * 将字符串 "PAYPALISHIRING" 以Z字形排列成给定的行数：
 * 之后从左往右，逐行读取字符："PAHNAPLSIIGYIR"
 * 例1:
 * 输入: s = "PAYPALISHIRING", numRows = 3
 * 输出: "PAHNAPLSIIGYIR"
 * 例2:
 * 输入: s = "PAYPALISHIRING", numRows = 4
 * 输出: "PINALSIGYAHRPI"
 * 解释:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */
public class StringConvertZhi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = sc.nextInt();
        System.out.println(stringConvert1(s, n));
        System.out.println(stringConvert2(s, n));
        System.out.println(stringConvert3(s, n));
    }
    private static String stringConvert1(String s, int n) {
        int j;
        if (n == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            j = i;
            while (j < s.length()) {
                sb.append(s.charAt(j));
                j += 2 * (n - i - 1);
                if (i != n - 1 && i  != 0 && j  <=  s.length() - 1) {
                    sb.append(s.charAt(j));
                }
                j += 2 * i;
            }
        }
        return sb.toString();
    }
    private static String stringConvert2(String s, int n) {
        char [] c = s.toCharArray();
        int len = c.length;
        StringBuilder[] sb = new StringBuilder[n];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder();
        }
        int i = 0;
        while (i < len) {
            for (int index = 0; index < n && i < len; index++)
                sb[index].append(c[i++]);
            for (int index = n - 2; index >= 1 && i < len; index--)
                sb[index].append(c[i++]);
        }
        for (int index = 1; index < sb.length; index++)
            sb[0].append(sb[index]);
        return sb[0].toString();
    }
    private static String stringConvert3(String s, int n) {
        int i, j = 0;
        if (n == 1) {
            return s;
        }
        StringBuilder[] sb = new StringBuilder[n];
        for (i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder();
        }
        i = 0;
        while (j < s.length() && i < n) {
            sb[i].append(s.charAt(j));
            j += 2 * (n - i - 1);
            if (i != n - 1 && i != 0 && j <= s.length() - 1) {
                sb[i].append(s.charAt(j));
            }
            j += 2 * i;
            if (s.length() <= j) {
                j = ++i;
            }
        }
        for (i = 1; i < sb.length; i++)
            sb[0].append(sb[i]);
        return sb[0].toString();
    }
}
