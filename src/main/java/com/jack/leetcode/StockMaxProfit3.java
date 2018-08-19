package com.jack.leetcode;

/**
 * Created by Jack on 8/18/2018 2:45 PM
 * LeetCode 123
 * find stock buy or sell best time
 * only could buy twice and sell twice could buy again after sell
 */
public class StockMaxProfit3 {
    public static void main(String[] args) {
        int [] arr = {1,4,2};
        System.out.println(findMaxProfit1(arr));
        System.out.println(findMaxProfit2(arr));
        System.out.println(findMaxProfit3(arr));
    }

    /**
     * 假设手上最开始只有0元钱，那么如果买入股票的价格为price，手上的钱需要减去这个price
     * 如果卖出股票的价格为price，手上的钱需要加上这个price。
     * 定义四种状态
     * Buy1[i]表示前i天做第一笔交易买入股票后剩下的最多的钱
     * Sell1[i]表示前i天做第一笔交易卖出股票后剩下的最多的钱
     * Buy2[i]表示前i天做第二笔交易买入股票后剩下的最多的钱
     * Sell2[i]表示前i天做第二笔交易卖出股票后剩下的最多的钱
     * Sell2[i]=max{Sell2[i-1],Buy2[i-1]+prices[i]}
     * Buy2[i]=max{Buy2[i-1],Sell[i-1]-prices[i]}
     * Sell1[i]=max{Sell[i-1],Buy1[i-1]+prices[i]}
     * Buy1[i]=max{Buy[i-1],-prices[i]}
     * 四个状态都只与前一个状态相关
     * @param arr
     * @return
     */
    private static int findMaxProfit1(int [] arr) {
        if (arr.length==0||arr==null)
            return 0;
        int buy1=Integer.MIN_VALUE,buy2=Integer.MIN_VALUE;
        int sell1=0,sell2=0;
        for (int i=0;i<arr.length;i++) {
            sell2=Math.max(sell2,buy2+arr[i]);
            buy2=Math.max(buy2,sell1-arr[i]);
            sell1=Math.max(sell1,buy1+arr[i]);
            buy1=Math.max(buy1,-arr[i]);
        }
        return sell2;
    }
    private static int findMaxProfit2(int [] arr) {
        if (arr.length==0)
            return 0;
        int max = 0;
        int [] left = new int[arr.length];
        int [] right = new int[arr.length];
        process(arr,left,right);
        for (int i=0;i<arr.length;i++)
            max=Math.max(max,left[i]+right[i]);
        return max;
    }
    private static void process(int [] arr,int [] left,int [] right) {
        left[0] = 0;
        int min = arr[0];
        for (int i=1;i<left.length;i++) {
            left[i] = Math.max(left[i-1],arr[i]-min);
            min = Math.min(min,arr[i]);
        }
        right[right.length-1] = 0;
        int max = arr[right.length-1];
        for (int i=right.length-2;i>=0;i--) {
            right[i] = Math.max(right[i+1],max-arr[i]);
            max = Math.max(max,arr[i]);
        }
    }

    /**
     * use dynamic programming to promote to target transaction
     * @param arr
     * @return
     */
    private static int findMaxProfit3(int [] arr) {
        int target = 2;//number of transactions
        return findMaxProfit3(arr,target);
    }
    private static int findMaxProfit3(int [] arr,int target) {
        int len = arr.length;
        if (len==0)
            return 0;
        int [][] local = new int[len][target+1];
        int [][] global = new int[len][target+1];
        for (int i=1;i<len;i++) {
            int diff = arr[i]-arr[i-1];
            for (int j=1;j<=target;j++) {
                local[i][j] = Math.max(global[i-1][j-1]+Math.max(diff,0),local[i-1][j]+diff);
                global[i][j] = Math.max(global[i-1][j],local[i][j]);
            }
        }
        return global[len-1][target];
    }
}
