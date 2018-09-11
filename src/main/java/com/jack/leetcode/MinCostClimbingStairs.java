package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/11 13:59
 * LeetCode 746
 * 使用最小花费爬楼梯
 * 数组的每个索引做为一个阶梯，
 * 第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，
 * 然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 * 您需要找到达到楼层顶部的最低花费。
 * 在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 * 例1:
 * 输入: cost = [10, 15, 20]
 * 输出: 15
 * 解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
 * 例2:
 * 输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出: 6
 * 解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
 */
public class MinCostClimbingStairs {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String []str=sc.nextLine().split(",");
        int []arr=new int[str.length];
        for (int i=0;i<arr.length;i++) {
            arr[i]=Integer.parseInt(str[i]);
        }
        System.out.println(findMinCost(arr));
    }
    private static int findMinCost(int []arr) {
        int len=arr.length;
        if (len==2)
            return Math.min(arr[0],arr[1]);
        int []dp=new int[len+1];
        dp[0]=arr[0];
        dp[1]=arr[1];
        for (int i=2;i<len;i++) {
            dp[i]=Math.min(dp[i-2],dp[i-1])+arr[i];
        }
        return Math.min(dp[len-1],dp[len-2]);
    }
}