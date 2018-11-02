package com.jack.leetcode;

/**
 * Created by Jack on 8/10/2018 10:34 AM
 * LeetCode 33
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，
 * 否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 例1:
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 例2:
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 * 你的算法时间复杂度必须是 O(log n) 级别。
 */
public class RotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(searchTarget(arr, target));
    }
    private static int searchTarget(int[] arr, int val) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == val)
                return i;
        return -1;
    }
}
