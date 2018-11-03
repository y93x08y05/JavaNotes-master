package com.jack.leetcode;

import java.util.TreeSet;

/**
 * @Author: Jack
 * @Date: 2018/9/11 18:22
 * LeetCode 220
 * 存在重复元素 III
 * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，
 * 使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
 * 例1:
 * 输入: nums = [1,2,3,1], k = 3, t = 0
 * 输出: true
 * 例2:
 * 输入: nums = [1,0,1,1], k = 1, t = 2
 * 输出: true
 * 例3:
 * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出: false
 */
public class ContainsNearbyAlmostDuplicate {
    public static void main(String[] args) {
        int[] arr = {1, 5, 9, 1, 5, 9};
        int k = 2;
        int t = 3;
        System.out.println(containsNearbyAlmost(arr, k, t));
    }
    private static boolean containsNearbyAlmost(int[] arr, int k, int t) {
        if (arr == null || arr.length == 0 || k <= 0)
            return false;
        TreeSet<Long> ts = new TreeSet<>();
        for (int i = 0; i < arr.length; ++i) {
            Long right = ts.floor((long) arr[i] + t);
            Long left = ts.ceiling((long) arr[i] - t);
            if (right != null && left != null && right >= left)
                return true;
            ts.add((long) arr[i]);
            if (i >= k)
                ts.remove((long) arr[i - k]);
        }
        return false;
    }
}