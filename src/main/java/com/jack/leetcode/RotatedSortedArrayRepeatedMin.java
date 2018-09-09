package com.jack.leetcode;

import java.util.Arrays;

/**
 * Created by Jack on 8/10/2018 11:05 AM
 * LeetCode 154
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。
 * 请找出其中最小的元素。
 * 注意数组中可能存在重复的元素。
 * 例1：
 * 输入: [1,3,5]
 * 输出: 1
 * 例2：
 * 输入: [2,2,2,0,1]
 * 输出: 0
 */
public class RotatedSortedArrayRepeatedMin {
    public static void main(String[] args) {
        int [] arr = {2,2,2,0,1};
        System.out.println(findMinFromRepeatedSortedRotated(arr));
    }
    private static int findMinFromRepeatedSortedRotated(int [] arr) {
        Arrays.sort(arr);
        return arr[0];
    }
}
