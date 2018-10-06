package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/10/6 19:25
 * LeetCode 724
 * 寻找数组的中心索引
 * 给定一个整数类型的数组，编写一个能够返回数组中心索引的方法
 * 数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和
 * 如果数组不存在中心索引，则返回-1
 * 如果数组存在多个中心索引，则返回最靠近左边的一个
 * 例1：
 * 输入:
 * nums = [1, 7, 3, 6, 5, 6]
 * 输出: 3
 * 解释:
 * 索引3 (nums[3] = 6) 的左侧数之和(1 + 7 + 3 = 11)，与右侧数之和(5 + 6 = 11)相等。
 * 同时, 3 也是第一个符合要求的中心索引。
 * 例2：
 * 输入:
 * nums = [1, 2, 3]
 * 输出: -1
 * 解释:
 * 数组中不存在满足此条件的中心索引。
 */
public class PivotIndex {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
        for (int i=0;i<n;i++) {
            arr[i]=sc.nextInt();
        }
        System.out.println(new PivotIndex().find(arr));
    }
    public int find(int []arr) {
        if (arr.length<3)
            return -1;
        for (int i=0;i<arr.length;i++) {
            int sum1=0;
            int sum2=0;
            for (int p=0;p<i;p++) {
                sum1+=arr[p];
            }
            for (int q=i+1;q<arr.length;q++) {
                sum2+=arr[q];
            }
            if (sum1==sum2)
                return i;
        }
        return -1;
    }
}