package com.jack.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Jack on 9/2/2018 3:46 PM
 * LeetCode 31
 * 实现获取下一个排列的函数，
 * 算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列
 * （即升序排列）。
 * 必须原地修改，只允许使用额外常数空间。
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 数学中的排列组合
 * 6 5 4 8 7 5 1
 * 排序后的结果
 * 6 5 5 8 7 4 1
 */
public class NextPermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        findNextPermutation(arr);
    }
    private static void findNextPermutation(int[] arr) {
        int index = arr.length - 1;
        while (index > 0 && arr[index] <= arr[index - 1]) {
            --index;
        }
        if (index == 0) {
            Arrays.sort(arr);
            return;
        }
        int second = Integer.MAX_VALUE;
        int secondIndex = Integer.MAX_VALUE;
        for (int i = arr.length - 1; i >= index - 1; --i) {
            if (arr[i] > arr[index - 1] && arr[i] < second) {
                second = arr[i];
                secondIndex = i;
            }
        }
        int temp = arr[index - 1];
        arr[index - 1] = arr[secondIndex];
        arr[secondIndex] = temp;
        Arrays.sort(arr, index, arr.length);
    }
}
