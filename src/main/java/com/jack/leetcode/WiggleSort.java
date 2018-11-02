package com.jack.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/20 10:43
 * LeetCode 324
 * 摆动排序 II
 * 给定一个无序的数组nums，将它重新排列成nums[0]<nums[1]>nums[2]<nums[3]
 * 例1:
 * 输入: nums = [1, 5, 1, 1, 6, 4]
 * 输出: 一个可能的答案是 [1, 4, 1, 5, 1, 6]
 * 例2:
 * 输入: nums = [1, 3, 2, 2, 3, 1]
 * 输出: 一个可能的答案是 [2, 3, 1, 3, 1, 2]
 */
public class WiggleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        method1(arr);
    }

    /**
     * 赋值当前数组并排序来找到中位数，以中位数为分界线将数组
     * 分为大小两部分，交替填入原始数组即可。
     * 交替填入也必须降序交替，否则相同的数有可能左右相邻
     * [4 5 5 6]升序交替为[4 5 5 6]降序交替为[5 6 4 5]
     * @param arr
     */
    private static void method1(int[] arr) {
        if (arr.length <= 1)
            return;
        int[] temp = Arrays.copyOfRange(arr, 0, arr.length);
        Arrays.sort(temp);
        int large = temp.length / 2 + (temp.length % 2 == 0 ? -1 : 0);
        int small = temp.length - 1;
        for (int i = 0, j = 1; i < temp.length; i += 2, j += 2) {
            if (j < temp.length)
                arr[j] = temp[small--];
            arr[i] = temp[large--];
        }
    }
}