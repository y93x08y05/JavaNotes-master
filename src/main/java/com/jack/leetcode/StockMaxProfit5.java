package com.jack.leetcode;

/**
 * Created by Jack on 8/18/2018 6:18 PM
 * LeetCode 309
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * 设计一个算法计算出最大利润。
 * 在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 例:
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 */
public class StockMaxProfit5 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 0, 2};
        System.out.println(findMaxProfit(arr));
    }
    private static int findMaxProfit(int[] arr) {
        int n = arr.length;
        if (n == 0)
            return 0;
        int buy = 0x80000000;
        int sell = 0;
        int preBuy;
        int preSell = 0;
        for (int i = 0; i < n; i++) {
            preBuy = buy;
            buy = Math.max(preBuy, preSell - arr[i]);
            preSell = sell;
            sell = Math.max(preSell, preBuy + arr[i]);
        }
        return sell;
    }
}
