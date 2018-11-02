package com.jack.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/6 0:05
 * LeetCode 698
 * 给定一个整数数组nums和一个正整数k，
 * 找出是否有可能把这个数组分成k个非空子集，其总和都相等。
 * 例1：
 * 输入：num = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出：True
 * 有可能将其分成4个子集（5），1,4），（2,3），（2,3）等于总和。
 */
public class PartitionSubSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(ifPartitionSubSet(arr, k));
    }
    private static boolean ifPartitionSubSet(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);
        int sum = Arrays.stream(arr).sum();
        int target = sum / k;
        if (sum % k > 0 || arr[n - 1] > target)
            return false;
        boolean[] dp = new boolean[1 << n];
        dp[0] = true;
        int[] total = new int[1 << n];
        for (int state = 0; state < (1 << n); state++) {
            if (!dp[state])
                continue;
            for (int i = 0; i < n; i++) {
                int future = state | (1 << i);
                if (state != future && !dp[future]) {
                    if (arr[i] <= target - (total[state] % target)) {
                        dp[future] = true;
                        total[future] = total[state] + arr[i];
                    } else {
                        break;
                    }
                }
            }
        }
        return dp[(1 << n) - 1];
    }
 }