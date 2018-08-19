package com.jack.leetcode;

/**
 * Created by Jack on 8/18/2018 6:18 PM
 * LeetCode 309
 * find best profit give array
 * cold one day means if you sell today you will be not allowed buy
 * tomorrow.
 */
public class StockMaxProfit5 {
    public static void main(String[] args) {
        int [] arr = {1,2,3,0,2};
        System.out.println(findMaxProfit(arr));
    }
    private static int findMaxProfit(int [] arr) {
        int n = arr.length;
        if (n==0)
            return 0;
        int buy = 0x80000000;
        int sell = 0;
        int preBuy;
        int preSell = 0;
        for (int i=0;i<n;i++) {
            preBuy = buy;
            buy = Math.max(preBuy,preSell-arr[i]);
            preSell = sell;
            sell = Math.max(preSell,preBuy+arr[i]);
        }
        return sell;
    }
}
