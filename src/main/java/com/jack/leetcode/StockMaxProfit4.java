package com.jack.leetcode;

/**
 * Created by Jack on 8/18/2018 4:31 PM
 * LeetCode 188
 * 买卖股票的最佳时机 IV
 * f给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 例1:
 * 输入: [2,4,1], k = 2
 * 输出: 2
 * 解释: 在第 1 天 (股票价格 = 2) 的时候买入，
 * 在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 * 例2:
 * 输入: [3,2,6,5,0,3], k = 2
 * 输出: 7
 * 解释: 在第 2 天 (股票价格 = 2) 的时候买入，
 * 在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 *      随后，在第 5 天 (股票价格 = 0) 的时候买入，
 *      在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 */
public class StockMaxProfit4 {
    public static void main(String[] args) {
        int[] arr = {3, 2, 6, 5, 0, 3};
        int k = 2;
        System.out.println(findMaxProfit1(arr, k));
        System.out.println(findMaxProfit2(arr, k));
    }

    /**
     * time complexity is O(nk) and space complexity is O(nk)
     * @param arr
     * @param target
     * @return
     */
    private static int findMaxProfit1(int[] arr, int target) {
        if (arr.length < 2)
            return 0;
        int days = arr.length;
        if (target > days)
            return findMaxProfit(arr);
        int[][] local = new int[days][target + 1];
        int[][] global = new int[days][target + 1];
        for (int i = 1; i < days; i++) {
            int diff = arr[i] - arr[i - 1];
            for (int j = 1; j <= target; j++) {
                local[i][j] = Math.max(global[i - 1][j - 1], local[i - 1][j] + diff);
                global[i][j] = Math.max(global[i - 1][j], local[i][j]);
            }
        }
        return global[days - 1][target];
    }

    /**
     * time complexity is O(nk) and space complexity is O(k)
     * @param arr
     * @param target
     * @return
     */
    private static int findMaxProfit2(int[] arr, int target) {
        if (arr.length < 2)
            return 0;
        if (target >= arr.length)
            return findMaxProfit(arr);
        int[] local = new int [target + 1];
        int[] global = new int [target + 1];
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];
            for (int j = target; j > 0; j--) {
                local[j] = Math.max(global[j - 1], local[j] + diff);
                global[j] = Math.max(global[j], local[j]);
            }
        }
        return global[target];
    }
    private static int findMaxProfit(int[] arr) {
        int maxProfit = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1])
                maxProfit += arr[i] -  arr[i - 1];
        }
        return maxProfit;
    }
}
