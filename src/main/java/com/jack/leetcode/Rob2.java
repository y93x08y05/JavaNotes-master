package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/30 20:17
 * LeetCode 213
 * 打家劫舍2
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
 * 这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，
 * 计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * 例1:
 * 输入: [2,3,2]
 * 输出: 3
 * 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）,
 * 因为他们是相邻的。
 * 例2:
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 */
public class Rob2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
        for (int i=0;i<n;i++) {
            arr[i]=sc.nextInt();
        }
        System.out.println(find(arr));
    }
    public static int find(int []arr) {
        if (arr==null||arr.length==0)
            return 0;
        if (arr.length==1)
            return arr[0];
        if (arr.length==2)
            return Math.max(arr[0],arr[1]);
        return Math.max(find(arr,0,arr.length-2),find(arr,1,arr.length-1));
    }
    private static int find(int []arr,int s,int e) {
        int n=e-s+1;
        int []dp=new int[n];
        dp[0]=arr[s];
        dp[1]=Math.max(arr[s],arr[s+1]);
        for (int i=2;i<n;i++)
            dp[i]=Math.max(dp[i-2]+arr[s+i],dp[i-1]);
        return dp[n-1];
    }
}