package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/30 19:41
 * LeetCode 198
 * 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。
 * 每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，
 * 计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * 例1:
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 例2:
 * 输入: [2,7,9,3,1]
 * 改变之后的两次结果为：
 * 2 7 11 10 1
 * 2 7 11 10 12
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，
 * 接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 */
public class Rob {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
        for (int i=0;i<n;i++) {
            arr[i]=sc.nextInt();
        }
        System.out.println(find(arr));
    }
    /**
     * 状态转移方程
     * dp[i]=Math.max(dp[i-2],dp[i-3])+arr[i]
     * dp[i]表示打劫到第i间房屋时累计取得的金钱最大值
     * @param arr
     * @return
     */
    private static int find(int []arr) {
        if (arr.length==0||arr==null)
            return 0;
        if (arr.length>2)
            arr[2]+=arr[0];
        int i=3;
        for (;i<arr.length;i++)
            arr[i]+=Math.max(arr[i-2],arr[i-3]);
        if (arr.length==1)
            return arr[0];
        else if (arr.length==2)
            return Math.max(arr[0],arr[1]);
        else
            return Math.max(arr[i-1],arr[i-2]);
    }
}