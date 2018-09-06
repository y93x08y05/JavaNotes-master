package com.jack.leetcode;

import java.util.LinkedList;

/**
 * @Author: Jack
 * @Date: 2018/9/6 11:49
 * LeetCode 85
 * 给定一个仅包含0和1的二维二进制矩阵，找出只包含1的最大矩形，
 * 并返回其面积。
 * 例1：
 * 输入:
 * ["1","0","1","0","0"],
 * ["1","0","1","1","1"],
 * ["1","1","1","1","1"],
 * ["1","0","0","1","0"]
 * 输出: 6
 */
public class MaximalRectangle {
    public static void main(String[] args) {
        char [][]chars={
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println(findMaxRectangle(chars));
    }
    private static int findMaxRectangle(char [][]matrix) {
        if (matrix==null||matrix.length==0||matrix[0].length==0)
            return 0;
        int maxArea=0;
        int []height=new int[matrix[0].length];
        for (int i=0;i<matrix.length;i++) {
            for (int j=0;j<matrix[0].length;j++) {
                height[j]=matrix[i][j]=='0'?0:height[j]+1;
            }
            maxArea=Math.max(largestRectangleArea(height),maxArea);
        }
        return maxArea;
    }
    private static int largestRectangleArea(int []height) {
        if (height==null||height.length==0)
            return 0;
        int maxArea=0;
        LinkedList<Integer> stack=new LinkedList<>();
        for (int i=0;i<height.length;i++) {
            while (!stack.isEmpty()&&height[i]<=height[stack.peek()]) {
                int index=stack.poll();
                int currentArea=stack.isEmpty()?i*height[index]:(i-stack.peek()-1)*height[index];
                maxArea=Math.max(maxArea,currentArea);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int index=stack.pop();
            int currentArea=stack.isEmpty()?height.length*height[index]:(height.length-stack.peek()-1)*height[index];
            maxArea=Math.max(maxArea,currentArea);
        }
        return maxArea;
    }
}