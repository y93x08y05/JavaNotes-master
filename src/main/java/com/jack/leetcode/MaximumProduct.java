package com.jack.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/10/6 10:25
 * LeetCode 628
 * 三个数的最大乘积
 * 给定一个整形数组，在数组中找出由三个数组成的最大的乘积，并输出这个乘积
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 * 例1:
 * 输入: [1,2,3]
 * 输出: 6
 * 例2:
 * 输入: [1,2,3,4]
 * 输出: 24
 */
public class MaximumProduct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(new MaximumProduct().find(arr));
    }
    private int find(int[] arr) {
        if (arr == null || arr.length <= 2)
            return 0;
        Arrays.sort(arr);
        int n = arr.length;
        if (arr[0] * arr[1] < arr[n - 2] * arr[n - 3])
            return arr[n - 1] * arr[n - 2] * arr[n - 3];
        else
            return arr[0] * arr[1] * arr[n - 1];
    }
}