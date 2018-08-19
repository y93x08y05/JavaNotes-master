package com.jack.leetcode;

/**
 * Created by Jack on 8/18/2018 2:40 PM
 * LeetCode 122
 * find stock buy or sell best time
 * could buy more time and sell more could buy again after sell
 */
public class StockMaxProfit2 {
    public static void main(String[] args) {
        int [] arr = {7,1,5,3,6,4};
        System.out.println(findMaxProfit(arr));
    }
    private static int findMaxProfit(int [] arr) {
        int sum = 0;
        int length = arr.length-1;
        for (int i=0;i<length;i++) {
            if (arr[i]<arr[i+1]) {
                sum+=arr[i+1]-arr[i];
            }
        }
        return sum;
    }
}
