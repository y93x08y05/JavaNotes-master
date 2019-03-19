package com.jack.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Jack
 * @Date: 2019/3/15 18:21
 * LeetCode 594
 * 最长和谐子序列
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。
 * 现在，给定一个整数数组，
 * 你需要在所有可能的子序列中找到最长的和谐子序列的长度。
 * 输入: [1,3,2,2,5,2,3,7]
 * 输出: 5
 * 原因: 最长的和谐数组是：[3,2,2,2,3].
 */
public class LongestHarmoniousSubsequence {
    public static void main(String[] args) {
        int[] arr = {1,3,2,2,5,2,3,7};
        System.out.println(new LongestHarmoniousSubsequence().findLHS(arr));
    }
    private int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int max = 0;
        for (int num : map.keySet()) {
            if (map.containsKey(num + 1)) {
                int tmp = map.get(num) + map.get(num + 1);
                max = Math.max(max, tmp);
            }
        }
        return max;
    }
}