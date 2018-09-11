package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/11 15:54
 * LeetCode 53
 * 最大子序和
 * 给定一个整数数组nums，找到一个具有最大和的连续子数组
 * (子数组最少包含一个元素)，返回其最大和。
 * 例：
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class MaxSubArray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
        for (int i=0;i<n;i++) {
            arr[i]=sc.nextInt();
        }
        System.out.println(findMaxSubArray(arr));
    }
    private static int findMaxSubArray(int []nums) {
        if (nums.length<=0)
            return 0;
        int max=Integer.MIN_VALUE;
        int current=0;
        for (int i=0;i<nums.length;i++) {
            if (current<0)
                current=nums[i];
            else
                current+=nums[i];
            if (current>max)
                max=current;
        }
        return max;
    }
}