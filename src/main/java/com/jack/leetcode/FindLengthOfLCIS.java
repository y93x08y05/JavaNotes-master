package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/10/6 16:25
 * LeetCode 674
 * 最长连续递增序列
 * 给定一个没有排序的整数数组，找出最长且连续的递增序列
 * 例1:
 * 输入: [1,3,5,4,7]
 * 输出: 3
 * 例2:
 * 输入: [2,2,2,2,2]
 * 输出: 1
 */
public class FindLengthOfLCIS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(new FindLengthOfLCIS().find(arr));
    }
    public int find(int []arr) {
        if (arr.length == 0 || arr.length == 1)
            return arr.length;
        int max = 1;
        int count = 1;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] < arr[i+1]) {
                count++;
                max = Math.max(max,count);
            } else {
                count = 1;
            }
        }
        return max;
    }
}