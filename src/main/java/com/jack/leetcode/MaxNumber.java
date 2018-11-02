package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/5 18:09
 * LeetCode 321
 * 给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，
 * 表示两个自然数各位上的数字。
 * 现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，
 * 要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
 * 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
 * 例1：
 * 输入:
 * nums1 = [3, 4, 6, 5]
 * nums2 = [9, 1, 2, 5, 8, 3]
 * k = 5
 * 输出:
 * [9, 8, 6, 5, 3]
 * 例2：
 * 输入:
 * nums1 = [6, 7]
 * nums2 = [6, 0, 4]
 * k = 5
 * 输出:
 * [6, 7, 6, 0, 4]
 * 例3：
 * 输入:
 * nums1 = [3, 9]
 * nums2 = [8, 9]
 * k = 3
 * 输出:
 * [9, 8, 9]
 */
public class MaxNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        findMaxNumber(arr1, arr2, k);
    }
    private static int [] findMaxNumber(int[] arr1, int[] arr2, int k) {
        int n = arr1.length;
        int m = arr2.length;
        int[] ans = new int[k];
        for (int i = Math.max(0, k - m); i <= k && i <= n; i++) {
            int[] candidate = merge(maxArray(arr1, i), maxArray(arr2, k - i), k);
            if (greater(candidate, 0, ans, 0))
                ans = candidate;
        }
        return ans;
    }
    private static int [] merge(int[] arr1, int[] arr2, int k) {
        int[] ans = new int[k];
        for (int i = 0, j = 0, r = 0; r < k; r++) {
            ans[r] = greater(arr1, i, arr2, j) ? arr1[i++] : arr2[j++];
        }
        return ans;
    }
    private static boolean greater(int[] arr1, int i, int[] arr2, int j) {
        while (i < arr1.length && j < arr2.length && arr1[i] == arr2[j]) {
            i++;
            j++;
        }
        return j == arr2.length || (i < arr1.length && arr1[i] > arr2[j]);
    }
    private static int [] maxArray(int[] arr, int k) {
        int n = arr.length;
        int[] ans = new int[k];
        for (int i = 0, j = 0; i < n; i++) {
            while (n - i > k - j && j > 0 && arr[i] > ans[j - 1])
                j--;
            if (j < k)
                ans[j++] = arr[i];
        }
        return ans;
    }
}