package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/4 22:18
 * LeetCode 189
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 例子1
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 例子2
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 */
public class RotateArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = 3;
        rotate(arr, k);
        rotate0(arr, k);
        rotate1(arr, k);
        rotate2(arr, k);
    }
    private static void rotate(int[] arr, int k) {
        k %= arr.length;
        for (int i = 0; i < arr.length; i++) {
            if (i + k > arr.length - 1) {
                arr[i + k - arr.length - 1] = arr[i];
            } else {
                arr[i + k] = arr[i];
            }
        }
    }
    private static void rotate0(int[] arr, int k) {
        int[] ans = new int[arr.length];
        if (k >= arr.length) {
            k -= arr.length;
            rotate0(arr, k);
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (i < k) {
                    ans[i] = arr[ans.length + i - k];
                } else {
                    ans[i] = ans[i - k];
                }
            }
            for (int i = 0; i < arr.length; i++) {
                arr[i] = ans[i];
            }
        }
    }
    private static void rotate1(int[] arr, int k) {
        int temp;
        for (int i = 0; i < k; i++) {
            temp = arr[arr.length - 1];
            for (int j = arr.length - 1; j > 0; --j) {
                arr[i] = arr[i - 1];
            }
            arr[0] = temp;
        }
    }
    /**
     * 反转前半部分，反转后半部分，反转整个数组
     * @param arr
     * @param k
     */
    private static void rotate2(int[] arr, int k) {
        int temp = k % arr.length;
        reverse(arr, 0, arr.length - temp - 1);
        reverse(arr, arr.length-temp, arr.length-1);
        reverse(arr, 0, arr.length-1);
    }
    private static void reverse(int[] arr, int start, int end) {
        for (int i = start ,j = end; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}