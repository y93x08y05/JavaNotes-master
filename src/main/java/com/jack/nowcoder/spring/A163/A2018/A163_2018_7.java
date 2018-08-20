package com.jack.nowcoder.spring.A163.A2018;

import java.util.Scanner;

/**
 * Created by zhangta on 1/6/2018.
 * 动态规划，求全局最优解
 * 两人同唱一首由n个音调组成的歌，每个音调由一个正整数表示
 * 每个音调由A或B演唱，一系列音调演唱难度等于所有相邻音调变化幅度之和
 * 音调序列8,8,13,12，则|8-8|+|13-8|+|12-13|=6
 * n个音调分配给A或B使得演唱难度之和最小
 * 输入包括两行,
 * 第一行一个正整数n(1 ≤ n ≤ 2000)
 * 第二行n个整数v[i](1 ≤ v[i] ≤ 10^6), 表示每个音调。
 * 输出一个整数,表示A和B演唱最小的难度和是多少。
 * 输入
 * 5
 * 1 5 6 2 1
 * 输出
 * 3
 */
public class A163_2018_7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int len = in.nextInt();
            int[] arr = new int[len];
            for (int i = 0; i < len; ++i) {
                arr[i] = in.nextInt();
            }
            if (len < 3) {
                //即分给A和B不存在音调差
                System.out.println("0");
            } else {
                int[][] dp = new int[len][len];
                int[] acc = new int[len];
                dp[0][0] = 0 - Math.abs(arr[1] - arr[0]);
                for (int i = 1; i < len; ++i) {
                    acc[i] = acc[i - 1] + Math.abs(arr[i] - arr[i - 1]);
                    dp[i][i - 1] = acc[i - 1];
                    for (int j = 0; j < i - 1; ++j) {
                        dp[i][j] = dp[i - 1][j] + acc[i] - acc[i - 1];
                        dp[i][i - 1] = Math.min(dp[i][i - 1], dp[i - 1][j] + Math.abs(arr[i] - arr[j]));
                    }
                }
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < len - 1; ++j) {
                    min = Math.min(min, dp[len - 1][j]);
                }
                System.out.println(min);
            }
        }
    }
}
