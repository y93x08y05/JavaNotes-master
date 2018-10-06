package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/10/6 11:03
 * LeetCode 643
 * 子数组最大平均数1
 * 给定n个整数，找出平均数最大且长度为k的连续子数组，并输出该最大平均数
 * 例：
 * 输入: [1,12,-5,-6,50,3], k = 4
 * 输出: 12.75
 * 解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 * 1 <= k <= n <= 30,000。
 * 所给数据范围 [-10,000，10,000]。
 */
public class FindMaxAverage {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int len=sc.nextInt();
        int k=sc.nextInt();
        int []arr=new int[len];
        for (int i=0;i<len;i++) {
            arr[i]=sc.nextInt();
        }
        System.out.println(new FindMaxAverage().find(arr, k));
    }
    private double find(int []arr,int k) {
        double res=Integer.MIN_VALUE;
        for (int i=0;i<=arr.length-k;i++) {
            int sum=0;
            for (int j=i;j<k+i;j++) {
                sum+=arr[j];
            }
            res=Math.max(res,(double)sum/k);
        }
        return res;
    }
}