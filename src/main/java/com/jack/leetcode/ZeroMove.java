package com.jack.leetcode;

/**
 * Created by Jack on 8/10/2018 10:03 AM
 * LeetCode 283
 * 给定一个数组 nums，
 * 编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */
public class ZeroMove {
    public static void main(String[] args) {
        int [] arr = {0, 1, 0, 3, 2};
        moveZero(arr);
    }
    private static void moveZero(int[] arr) {
        int len = arr.length;
        int count = 0;
        for (int i = 0; i < len - count; i++) {
            if (arr[i] == 0) {
                int j = i;
                while (j < len - 1) {
                    arr[j] = arr[j + 1];
                    j++;
                }
                arr[len - 1] = 0;
                count++;
                i--;
            }
        }
    }
}
