package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/8 0:18
 * LeetCode 162
 * 峰值元素是指其值大于左右相邻值的元素。
 * 给定一个输入数组nums，其中nums[i]≠nums[i+1]，找到峰值元素并返回其索引。
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 * 你可以假设nums[-1]=nums[n]=-∞。
 * 例1:
 * 输入: nums = [1,2,3,1]
 * 输出: 2
 * 解释: 3是峰值元素，你的函数应该返回其索引2。
 * 例2:
 * 输入: nums=[1,2,1,3,5,6,4]
 * 输出: 1或5
 * 解释:你的函数可以返回索引1，其峰值元素为2；或者返回索引5，其峰值元素为6。
 */
public class FindPeekElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(findPeekElement1(arr));
        System.out.println(findPeekElement2(arr));
    }
    private static int findPeekElement1(int[] arr) {
        int pre = Integer.MIN_VALUE;
        int index = 0;
        while (index < arr.length) {
            int v = arr[index];
            if (v > pre) {
            } else if (v < pre) {
                return index - 1;
            }
            pre = v;
            index++;
        }
        return arr.length - 1;
    }
    private static int findPeekElement2(int[] arr) {
        if (arr.length == 1)
            return 0;
        int p1 = 0;
        int p2 = arr.length - 1;
        int mid;
        while (p1 < p2) {
            mid = (p1 + p2) >> 1;
            if (arr[mid] < arr[mid + 1]) {
                p1 = mid + 1;
            } else {
                p2 = mid;
            }
        }
        return p1;
    }
}