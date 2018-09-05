package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/5 21:50
 * LeetCode 738
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，
 * 同时这个整数需要满足其各个位数上的数字是单调递增。
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 * 例1:
 * 输入: N = 10
 * 输出: 9
 * 例2:
 * 输入: N = 1234
 * 输出: 1234
 * 例3:
 * 输入: N = 332
 * 输出: 299
 * N 是在 [0, 10^9] 范围内的一个整数。
 */
public class MonotoneIncreasingDigit {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(findMonotoneIncreasing(n));
    }
    private static int findMonotoneIncreasing(int n) {
        char []s=(n+"").toCharArray();
        int begin=s.length;
        for (int i=s.length-1;i>=1;i--) {
            if (s[i]>=s[i-1])
                continue;
            else {
                s[i-1]--;
                begin=i;
            }
        }
        for (int i=begin;i<s.length;i++) {
            s[i]='9';
        }
        return Integer.parseInt(String.valueOf(s));
    }
}