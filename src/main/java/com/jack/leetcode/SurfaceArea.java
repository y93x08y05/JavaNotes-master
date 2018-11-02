package com.jack.leetcode;

/**
 * @Author: Jack
 * @Date: 2018/9/6 14:17
 * LeetCode 892
 * 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在单元格 (i, j) 上。
 * 返回结果形体的总表面积。
 * 例1：
 * 输入：[[2]]
 * 输出：10
 * 例2：
 * 输入：[[1,2],[3,4]]
 * 输出：34
 * 例3：
 * 输入：[[1,0],[0,2]]
 * 输出：16
 * 例4：
 * 输入：[[1,1,1],[1,0,1],[1,1,1]]
 * 输出：32
 * 例5：
 * 输入：[[2,2,2],[2,1,2],[2,2,2]]
 * 输出：46
 */
public class SurfaceArea {
    public static void main(String[] args) {
        int[][] grid = {{2, 2, 2}, {2, 1, 2}, {2, 2, 2}};
        System.out.println(findSurfaceArea0(grid));
        System.out.println(findSurfaceArea1(grid));
    }
    private static int findSurfaceArea0(int[][] grid) {
        int x = 0;
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0;j < grid[0].length; j++) {
                if (grid[i][j] != 0)
                    x += 1;
            }
        }
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                sum += (grid[i][j] * 4 - 2 * calculate0(grid, i, j));
        sum += 2 * x;
        return sum;
    }
    private static int findSurfaceArea1(int[][] grid) {
        int x = 0;
        int max = 0;
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0)
                    x += 1;
                if (grid[i][j] > max)
                    max = grid[i][j];
            }
        }
        for (int h = 0; h < max; h++) {
            int[][] currentLevel = new int[grid.length][grid[0].length];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] > 0) {
                        currentLevel[i][j] = 1;
                        grid[i][j]--;
                    } else {
                        currentLevel[i][j] = 0;
                    }
                }
            }
            sum += levelCalculate1(currentLevel);
        }
        sum += 2 * x;
        return sum;
    }
    private static int calculate0(int[][] grid, int i, int j) {
        if (i == 0 && j == 0)
            return 0;
        else if (i == 0)
            return Math.min(grid[i][j - 1],grid[i][j]);
        else if (i !=0 && j == 0)
            return Math.min(grid[i - 1][j], grid[i][j]);
        else
            return Math.min(grid[i][j - 1], grid[i][j]) + Math.min(grid[i - 1][j], grid[i][j]);
    }
    private static int levelCalculate1(int[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    sum += grid[i][j] * 4 - 2 * calculate1(grid, i, j);
            }
        }
        return sum;
    }
    private static int calculate1(int[][] grid, int i, int j) {
        if (i == 0 && j == 0)
            return 0;
        else if (i == 0)
            return grid[i][j - 1];
        else if (j == 0)
            return grid[i - 1][j];
        else
            return grid[i][j - 1] + grid[i - 1][j];
    }
}