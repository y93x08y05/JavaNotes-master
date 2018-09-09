package com.jack.leetcode;

/**
 * Created by Jack on 8/26/2018 8:11 PM
 * Leetcode 42
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class MaxWaterArea2 {
    public static void main(String[] args) {
        int []arr={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(findMaxWaterArea(arr));
    }

    /**
     * method1
     * 只能遍历一遍，且不能存储所有的高度，一根柱子能接的水取决于两边较短的柱子高度
     * 从左到右遍历一遍记录该点左边的最大值，从右到左遍历一遍记录该点右边的最大值
     * space complexity O(n) and time complexity O(n)
     * method2
     * 利用单调递减栈实现
     * space complexity O(n) and time complexity O(n)
     * method3
     * 先找出中间最大点，左边部分相当于已经确定了右边最大值，左指针不断向右逼近
     * 右边部分相当于已经确定了左边最大值，右指针不断向左逼近
     * space complexity O(1) and time complexity O(n)
     * method4
     * 每次选择小的指针向中间靠拢，比method3少遍历一遍
     * space complexity O(1) and time complexity O(n)
     * @param arr
     * @return
     */
    private static int findMaxWaterArea(int []arr) {
        if (arr.length<3)
            return 0;
        int start=0;
        int end=arr.length-1;
        int leftMax=0;
        int rightMax=0;
        int max=0;
        while (start<end) {
            leftMax=Math.max(leftMax,arr[start]);
            rightMax=Math.max(rightMax,arr[end]);
            if (leftMax<rightMax) {
                max+=leftMax-arr[start];
                start++;
            } else {
                max+=rightMax-arr[end];
                end--;
            }
        }
        return max;
    }
}
