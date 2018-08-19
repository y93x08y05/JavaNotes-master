package com.jack.leetcode;

/**
 * Created by Jack on 8/18/2018 1:53 PM
 * LeetCode 121
 * find stock buy or sell best time
 * only could buy once and sell once
 */
public class StockMaxProfit1 {
    public static void main(String[] args) {
        int [] arr = {7,1,5,3,6,4};
        System.out.println(findMaxProfit(arr));
    }
    private static int findMaxProfit(int [] arr) {
        int sum = 0;
        for (int i=0;i<arr.length-1;i++) {
            for (int j=i+1;j<arr.length;j++) {
                if (arr[j]-arr[i]>sum)
                    sum=arr[j]-arr[i];
            }
        }
        return sum;
    }
}
