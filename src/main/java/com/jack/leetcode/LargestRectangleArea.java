package com.jack.leetcode;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author: Jack
 * @Date: 2018/9/22 9:53
 * LeetCode 84
 * 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。
 * 每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * 例1：
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 */
public class LargestRectangleArea {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
        for (int i=0;i<n;i++) {
            arr[i]=sc.nextInt();
        }
        System.out.println(find(arr));
    }
    private static int find(int []arr) {
        Stack<Integer> stack=new Stack<>();
        int n=arr.length;
        int maxArea=0;
        int i=0;
        int temp;
        int tempTop;
        while (i<=n) {
            temp=(i==n)?0:arr[i];
            if (stack.isEmpty()||arr[stack.peek()]<=temp) {
                stack.push(i);
                i++;
            } else {
                tempTop=arr[stack.pop()];
                maxArea=Math.max(maxArea,tempTop*(stack.isEmpty()?i:i-1-stack.peek()));
            }
        }
        return maxArea;
    }
}