package com.jack.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Jack on 8/12/2018 6:20 PM
 * LeetCode 35
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 * 例1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 例2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 例3:
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 例4:
 * 输入: [1,3,5,6], 0
 * 输出: 0
 */
public class SearchInsertPosition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(findPosition(arr, target));
    }
    private static int findPosition(int[] arr, int target) {
        int m = Arrays.binarySearch(arr, target);
        if (m < 0)
            return Math.abs(m + 1);
        else
            return m;
    }
}
