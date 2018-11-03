package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/10/6 10:18
 * LeetCode 485
 * 最大连续1的个数
 * 给定一个二进制数组，计算其中最大连续1的个数
 * 例：
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * 输入的数组只包含 0 和1。
 * 输入数组的长度是正整数，且不超过 10,000。
 */
public class FindMaxConsecutiveOnes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(new FindMaxConsecutiveOnes().find(arr));
    }
    private int find(int[] arr) {
        int max = Integer.MIN_VALUE;
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                temp++;
                if (i == arr.length - 1)
                    max = max > temp ? max : temp;
            } else {
                max = max > temp ? max : temp;
                temp = 0;
            }
        }
        return max;
    }
}