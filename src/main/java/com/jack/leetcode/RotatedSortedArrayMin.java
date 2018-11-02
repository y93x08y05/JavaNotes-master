package com.jack.leetcode;

import java.util.Arrays;

/**
 * Created by Jack on 8/10/2018 10:53 AM
 * LeetCode 153
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2]
 * 请找出其中最小的元素。
 * 你可以假设数组中不存在重复元素。
 * 例1:
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * 例2:
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 */
public class RotatedSortedArrayMin {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(findMinFromArray(arr));
    }
    private static int findMinFromArray(int[] arr) {
        Arrays.sort(arr);
        return arr[0];
    }
}
