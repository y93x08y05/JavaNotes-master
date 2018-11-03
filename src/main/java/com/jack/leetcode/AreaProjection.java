package com.jack.leetcode;

/**
 * Created by Jack on 9/2/2018 8:14 PM
 * LeetCode 883
 * 在 N * N 的网格中，我们放置了一些与 x，y，z 三轴对齐的 1 * 1 * 1 立方体。
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在单元格 (i, j) 上。
 * 现在，我们查看这些立方体在 xy、yz 和 zx 平面上的投影。
 * 投影就像影子，将三维形体映射到一个二维平面上。
 * 在这里，从顶部、前面和侧面看立方体时，我们会看到“影子”。
 * 返回所有三个投影的总面积。
 * 输入：[[2]]
 * 输出：5
 * 输入：[[1,2],[3,4]]
 * 输出：17
 * 输入：[[1,0],[0,2]]
 * 输出：8
 * 输入：[[1,1,1],[1,0,1],[1,1,1]]
 * 输出：14
 * 输入：[[2,2,2],[2,1,2],[2,2,2]]
 * 输出：21
 * 分别求出所有立方体的个数，各行的最大值之和，各列的最大值之和，相加即为答案。
 */
public class AreaProjection {
    public static void main(String[] args) {
        int[][] arr = {{2, 2, 2}, {2, 1, 2}, {2, 2, 2}};
        System.out.println(projectionArea(arr));
    }
    private static int projectionArea(int[][] grid) {
        int[] front = new int[grid.length];
        int[] side = new int[grid[0].length];
        int top = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0)
                    continue;
                top += 1;
                front[i] = Math.max(front[i], grid[i][j]);
                side[j] = Math.max(side[j], grid[i][j]);
            }
        }
        for (int i = 0; i < front.length; i++) {
            top += front[i];
        }
        for (int i = 0; i < side.length; i++) {
            top += side[i];
        }
        return top;
    }
}
