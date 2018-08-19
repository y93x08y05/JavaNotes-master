package com.jack.leetcode;

/**
 * Created by Jack on 8/18/2018 4:31 PM
 * LeetCode 188
 * find best profit give a array and most target transaction
 */
public class StockMaxProfit4 {
    public static void main(String[] args) {
        int [] arr = {3,2,6,5,0,3};
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
    private static int findMaxProfit1(int [] arr,int target) {
        if (arr.length<2)
            return 0;
        int days = arr.length;
        if (target>days)
            return findMaxProfit(arr);
        int [][] local = new int[days][target+1];
        int [][] global = new int[days][target+1];
        for (int i=1;i<days;i++) {
            int diff = arr[i] - arr[i-1];
            for (int j=1;j<=target;j++) {
                local[i][j]=Math.max(global[i-1][j-1],local[i-1][j]+diff);
                global[i][j]=Math.max(global[i-1][j],local[i][j]);
            }
        }
        return global[days-1][target];
    }

    /**
     * time complexity is O(nk) and space complexity is O(k)
     * @param arr
     * @param target
     * @return
     */
    private static int findMaxProfit2(int [] arr,int target) {
        if (arr.length<2)
            return 0;
        if (target>=arr.length)
            return findMaxProfit(arr);
        int [] local = new int [target+1];
        int [] global = new int [target+1];
        for (int i=1;i<arr.length;i++) {
            int diff = arr[i] - arr[i-1];
            for (int j=target;j>0;j--) {
                local[j]=Math.max(global[j-1],local[j]+diff);
                global[j]=Math.max(global[j],local[j]);
            }
        }
        return global[target];
    }
    private static int findMaxProfit(int [] arr) {
        int maxProfit = 0;
        for (int i=1;i<arr.length;i++) {
            if (arr[i]>arr[i-1])
                maxProfit+=arr[i]-arr[i-1];
        }
        return maxProfit;
    }
}
