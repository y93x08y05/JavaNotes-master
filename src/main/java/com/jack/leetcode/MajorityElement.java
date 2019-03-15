package com.jack.leetcode;

import java.util.Arrays;

/**
 * @Author: Jack
 * @Date: 2018/9/11 16:45
 * LeetCode 169
 * 求众数
 * 给定一个大小为 n 的数组，找到其中的众数。
 * 众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * 例1:
 * 输入: [3,2,3]
 * 输出: 3
 * 例2:
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(arr));
    }
    private static int majorityElement(int[] arr) {
        Arrays.sort(arr);
        int middle = arr.length / 2;
        return arr[middle];
    }
}