package com.jack.leetcode;

/**
 * @Author: Jack
 * @Date: 2018/9/6 13:32
 * LeetCode 221
 * 在一个由0和1组成的二维矩阵内，找到只包含1的最大正方形，并返回其面积。
 * 输入:
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * 输出: 4
 * 动态规划，以当前点(x,y) = '1' 为右下角的最大正方形的边长
 * f(x,y) = min( f(x-1,y), f(x,y-1), f(x-1,y-1)) + 1.
 */
public class MaximalSquare {
    public static void main(String[] args) {
        char[][] chars = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println(findMaxSquare(chars));
    }
    private static int findMaxSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
                max = 1;
            }
        }
        for (int j = 0; j < m; j++) {
            if (matrix[0][j] == '1') {
                dp[0][j] = 1;
                max=1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == '0')
                    dp[i][j] = 0;
                else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}