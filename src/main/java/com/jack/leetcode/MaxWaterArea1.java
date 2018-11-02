package com.jack.leetcode;

/**
 * Created by Jack on 8/26/2018 7:59 PM
 * LeetCode 11
 * 盛最多水的容器
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 你不能倾斜容器，且 n 的值至少为 2。
 * 例：
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 */
public class MaxWaterArea1 {
    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(findMaxWaterArea(arr));
    }
    private static int findMaxWaterArea(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (Math.min(arr[i], arr[j]) * (j - i) > max)
                    max = Math.min(arr[i], arr[j]) * (j - i);
            }
        }
        return max;
    }
}
