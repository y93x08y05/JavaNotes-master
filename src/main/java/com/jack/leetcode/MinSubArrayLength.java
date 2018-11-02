package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/5 11:19
 * LeetCode 209
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，
 * 找出该数组中满足其和 ≥ s 的长度最小的连续子数组。
 * 如果不存在符合条件的连续子数组，返回 0。
 * 例1：
 * 输入: s = 7, num = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 */
public class MinSubArrayLength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int s = sc.nextInt();
        System.out.println(findMinSubArrayLen(arr, s));
    }
    private static int findMinSubArrayLen(int[] arr, int s) {
        int res = Integer.MAX_VALUE;
        int sum;
        for (int i = 0; i < arr.length - 1; i++) {
            sum = arr[i];
            if (sum >= s)
                return 1;
            for (int j = i + 1; j < arr.length; j++) {
                sum += arr[j];
                if (sum >= s) {
                    if (res > j - i + 1)
                        res = j - i + 1;
                    break;
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}