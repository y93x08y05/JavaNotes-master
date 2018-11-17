package com.jack.nowcoder.autumn.wangyi.WY20181117;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/11/17 13:46
 * 网易游戏2019校园招聘-产品开发工程师笔试题目
 * 随着游戏的不断发展，技能系统变的越发复杂化，不同的技能分支可以
 * 形成千变万化的技能搭配。作为一名“游戏爱好者”，你决定开发
 * 一款名为“技能加点大师”的小工具，快速地计算出将所有可用
 * 技能点全部消耗掉的情况下，一共可以有多少种可行的加点方式。
 * 千里之行始于足下，第一款目标游戏XXX有着比较简单的技能系统，
 * 和明确的技能加点要求：
 * 每个技能每次加点均需要消耗一定的技能点，当可用技能点少于某个
 * 技能单次加点需要消耗的技能点时，不可以对该技能加点，
 * 每个技能被加点的次数不限。
 * 假设该技能系统有N个技能，每个技能每次加点需要消耗P个技能点，
 * 玩家当前有M个技能点。请你计算出当M个技能点刚好完全消耗时，
 * 可以有多少种加点方式。例如：假设一共有2个技能和5个技能点，
 * 每个技能每次加点分别消耗1和2个技能点，可以有三种方式加点；
 * （1）给技能1加点5次，（2）给技能1加点3次，给技能2加点1次，
 * （3）给技能1加点1次，给技能2加点2次。
 * 输入描述：
 * 第1行为2个整数N和M，分别表示技能个数和可用的技能点数目。
 * 第2行为N个整数P，表示每个技能每次加点需要消耗的技能点数。
 * 输出描述：
 * 只输出1个整数，为可行的技能加点方式种数。
 * 输入
 * 2 5
 * 1 2
 * 输出
 * 3
 */
public class Main2 {
    private static int [][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(method(arr, target));
    }
    private static int method(int [] arr, int target) {
        dp = new int[arr.length][target+1];
        for (int i=0;i<arr.length;i++)
            dp[i][0] = 1;
        for (int i=0;i<target+1;i++) {
            if (i % arr[0] == 0)
                dp[0][i] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < target + 1; j++) {
                process(arr, i, j);
            }
        }
        return dp[arr.length - 1][target];
    }
    private static void process(int[] arr, int i, int j) {
        if (j - arr[i] >= 0) {
            dp[i][j] = dp[i - 1][j] + dp[i][j - arr[i]];
        }
        int dpValue = 0;
        for (int m = 0; j - m * arr[i] >= 0; m++) {
            dpValue += dp[i - 1][j - m * arr[i]];
        }
        dp[i][j] = dpValue;
    }
}