package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/30 21:31
 * LeetCode 322
 * 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 例1:
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 例2:
 * 输入: coins = [2], amount = 3
 * 输出: -1
 */
public class CoinChange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int mount = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(find0(arr, mount));
        System.out.println(find1(arr, mount));
    }
    /*
     * dp[i]表示当凑齐i时最少要多少个数字组成
     * 状态转移方程，dp[i]=Math.min(dp[i-k]+1,dp[i])
     */
    private static int find0(int[] coins, int mount) {
        int[] dp = new int[mount + 1];
        for (int i = 1; i <= mount; i++)
            dp[i] = Integer.MAX_VALUE;
        for (int coin : coins)
            for (int i = coin; i <= mount; i++)
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
        return dp[mount] == Integer.MAX_VALUE ? -1 : dp[mount];
    }
    private static int find1(int[] coins, int mount) {
        int[] dp = new int[mount + 1];
        for (int i = 1; i <= mount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i >= coin && dp[i - coin] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[mount] == Integer.MAX_VALUE ? -1 : dp[mount];
    }
}