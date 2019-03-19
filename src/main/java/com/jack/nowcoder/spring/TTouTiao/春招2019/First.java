package com.jack.nowcoder.spring.TTouTiao.春招2019;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2019/3/16 8:53
 */
public class First {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 1024 - sc.nextInt();
        int[] arr = {1, 4, 16, 64};
        System.out.println(find(arr, n));
    }
    private static int find(int[] arr, int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int a : arr) {
            for (int i = a; i <= n; i++) {
                dp[i] = Math.min(dp[i], dp[i - a] + 1);
            }
        }
        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }
}