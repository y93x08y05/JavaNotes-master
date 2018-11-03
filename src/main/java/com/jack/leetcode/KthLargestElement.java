package com.jack.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/8 22:48
 * LeetCode 215
 * 在未排序的数组中找到第k个最大的元素。
 * 需要找的是数组排序后的第k个最大的元素，而不是第k个不同的元素
 * 例1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 例2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 */
public class KthLargestElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(findKthElement(arr, k));
    }
    private static int findKthElement(int[] arr, int k) {
        Arrays.sort(arr);
        return arr[arr.length - k];
    }
}