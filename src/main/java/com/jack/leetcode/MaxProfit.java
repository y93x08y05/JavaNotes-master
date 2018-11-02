package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/10/1 13:45
 * LeetCode 714
 * 买卖股票的最佳时机含手续费
 * 给定一个整数数组prices，其中第i个元素代表了第i天的股票价格
 * 非负整数 fee 代表了交易股票的手续费用
 * 你可以无限次地完成交易，但是你每次交易都需要付手续费。
 * 如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * 返回获得利润的最大值。
 * 例1：
 * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出: 8
 * 解释: 能够达到的最大利润:
 * 在此处买入 prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * 0 < prices.length <= 50000.
 * 0 < prices[i] < 50000.
 * 0 <= fee < 50000.
 */
public class MaxProfit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int fee = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(find(arr, fee));
    }
    private static int find(int[] arr, int fee) {
        int res = 0;
        int n = arr.length;
        if (n < 2)
            return res;
        int hold = -arr[0];
        for (int i = 1; i < arr.length; i++) {
            int temp = res;
            res = Math.max(temp, hold + arr[i] - fee);
            hold = Math.max(hold, temp - arr[i]);
        }
        return res;
    }
}