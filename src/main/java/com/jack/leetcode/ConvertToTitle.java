package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/10/26 21:04
 * LeetCode 168
 * Excel表列名称
 * 例如，
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 * 例1:
 * 输入: 1
 * 输出: "A"
 * 例2:
 * 输入: 28
 * 输出: "AB"
 * 例3:
 * 输入: 701
 * 输出: "ZY"
 */
public class ConvertToTitle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(find(n));
    }
    public static String find(int n) {
        if (n <= 0)
            return null;
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.insert(0,(char) ('A' + n % 26));
            n = n / 26;
        }
        return sb.toString();
    }
}