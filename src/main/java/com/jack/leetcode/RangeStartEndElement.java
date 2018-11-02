package com.jack.leetcode;

import java.util.Scanner;

/**
 * Created by Jack on 8/12/2018 6:56 PM
 * LeetCode 34
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。
 * 找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * 例1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 例2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
public class RangeStartEndElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int [] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        findRange(arr,target);
    }
    private static int [] findRange(int[] arr, int target) {
        int start = 0;
        int end = arr.length;
        int mid = (start + end) / 2;
        int val = -1;
        while (start < end) {
            if (arr[mid] < target) {
                if (start == mid)
                    break;
                start = mid;
                mid = (start + end) / 2;
            } else if (arr[mid] > target){
                if (end == mid)
                    break;
                end = mid;
                mid = (start + end) / 2;
            } else {
                val = mid;
                break;
            }
        }
        if (val == -1)
            return new int[]{-1, -1};
        int a = val;
        int b = val;
        while (a > 0 && arr[a - 1] == target)
            a--;
        while (b < arr.length - 1 && arr[b + 1] == target)
            b++;
        return new int[]{a, b};
    }
}
