package com.jack.leetcode;

/**
 * @Author: Jack
 * @Date: 2018/9/11 18:14
 * LeetCode 219
 * 存在重复元素2
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
 * 使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 * 例1:
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 例2:
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 例3:
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 */
public class ContainsNearbyDuplicate {
    public static void main(String[] args) {
        int [] arr = {1,0,1,1};
        int k = 2;
        System.out.println(ifRepeat(arr, k));
    }
    private static boolean ifRepeat(int [] arr,int k) {
        int min = Integer.MAX_VALUE;
        for (int i=0;i<arr.length-1;i++) {
            for (int j=i+1;j<arr.length;j++) {
                if (arr[i] == arr[j]) {
                    if (j - i < min) {
                        min = j-i;
                    }
                    if (min <= k)
                        return true;
                }
            }
        }
        return false;
    }
}