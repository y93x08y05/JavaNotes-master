package com.jack.leetcode;

/**
 * @Author: Jack
 * @Date: 2018/9/6 14:03
 * LeetCode 812
 * 给定包含多个点的集合，从其中取三个点组成三角形，返回能组成的最大三角形的面积。
 * 例1:
 * 输入: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
 * 输出: 2
 * 解释:三角形最大面积为2。
 * 三角形的面积公式
 * S_abc=1/2(x_b-x_a)(y_c-y_b)+1/2(x_c-x_b)(y_a-y_c)+1/2(x_c-x_b)(y_c-y_b)
 * S_abc=1/2(x_a*y_b+x_b*y_c+x_c*y_a-x_a*y_c-x_c*y_b-x_b*y_a)
 */
public class LargestTriangleArea {
    public static void main(String[] args) {
        int [][]points={{0,0},{0,1},{1,0},{0,2},{2,0}};
        System.out.println(findLargestTriangleArea(points));
    }
    private static double findLargestTriangleArea(int [][]points) {
        double area=0;
        for (int []a:points)
            for (int []b:points)
                for (int []c:points)
                    area=Math.max(area,0.5*Math.abs(a[0]*b[1]+b[0]*c[1]+c[0]*a[1]-a[0]*c[1]-b[0]*a[1]-c[0]*b[1]));
        return area;
    }
}