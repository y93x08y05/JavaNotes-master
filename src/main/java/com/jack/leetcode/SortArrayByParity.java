package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/10/6 21:04
 * LeetCode 905
 * 按奇偶校验排序数组
 * 给定一个非负整数数组A，返回一个由A的所有偶数元素组成的数组，
 * 后面跟A的所有奇数元素。
 * 你可以返回满足此条件的任何数组作为答案。
 * 例：
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 */
public class SortArrayByParity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        new SortArrayByParity().find(arr);
    }
    public int [] find(int[] arr) {
        int n = arr.length;
        if (n == 1)
            return arr;
        int i = 0;
        int j = n - 1;
        while (i < j) {
            if (arr[i] % 2 == 0) {
                i++;
                continue;
            }
            if (arr[j] % 2 == 1) {
                j--;
                continue;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return arr;
    }
}