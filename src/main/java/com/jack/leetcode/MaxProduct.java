package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/30 18:14
 * LeetCode 152
 * 乘积最大子序列
 * 给定一个整数数组nums，找出一个序列中乘积最大的连续子序列
 * 例1：
 * 输入 2 3 -1 4
 * 输出 6
 * 例2：
 * 输入 -2 0 -1
 * 输出 0
 */
public class MaxProduct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int[] arr = new int[str.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        System.out.println(find(arr));
    }
    private static int find(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        int maxPositive = arr[0];
        int minNegative = arr[0];
        int dp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int localMax = arr[i] * maxPositive;
            int localMin = arr[i] * minNegative;
            maxPositive = Math.max(arr[i], Math.max(localMax, localMin));
            minNegative = Math.min(arr[i], Math.min(localMax, localMin));
            dp = Math.max(dp, maxPositive);
        }
        return dp;
    }
}