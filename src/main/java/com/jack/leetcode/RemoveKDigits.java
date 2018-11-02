package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/5 21:37
 * LeetCode 402
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 例1：
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 例2：
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 例3：
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 */
public class RemoveKDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = sc.nextInt();
        System.out.println(removeDigit(s, k));
    }
    private static String removeDigit(String num, int k) {
        int n;
        while (true) {
            n = num.length();
            if (n <= k || n == 0)
                return "0";
            if (k-- == 0)
                return num;
            if (num.charAt(1) == '0') {
                int firstNotZero = 1;
                while (firstNotZero < num.length() && num.charAt(firstNotZero) == '0')
                    firstNotZero++;
                num = num.substring(firstNotZero);
            } else {
                int startIndex = 0;
                while (startIndex < num.length() - 1 && num.charAt(startIndex) <= num.charAt(startIndex + 1))
                    startIndex++;
                num = num.substring(0, startIndex) + num.substring(startIndex + 1);
            }
        }
    }
}