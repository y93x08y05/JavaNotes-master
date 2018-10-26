package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/10/26 20:50
 * LeetCode 171
 * Excel表列序号
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 * 例如，
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * 例1:
 * 输入: "A"
 * 输出: 1
 * 例2:
 * 输入: "AB"
 * 输出: 28
 * 例3:
 * 输入: "ZY"
 * 输出: 701
 */
public class TitleToNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(find(s));
    }
    public static int find(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int temp = s.charAt(i) - 'A' + 1;
            temp *= Math.pow(26,s.length() - 1 - i);
            sum += temp;
        }
        return sum;
    }
}