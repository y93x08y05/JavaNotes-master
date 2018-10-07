package com.jack.leetcode;

/**
 * @Author: Jack
 * @Date: 2018/10/7 10:44
 * LeetCode 840
 * 矩阵中的幻方
 * 3 x 3 的幻方是一个填充有从 1 到 9 的不同数字的 3 x 3 矩阵，其中每行，每列以及两条对角线上的各数之和都相等。
 * 给定一个由整数组成的 N × N 矩阵，其中有多少个 3 × 3 的 “幻方” 子矩阵？（每个子矩阵都是连续的）。
 * 例：
 * 输入: [[4,3,8,4],
 *       [9,5,1,9],
 *       [2,7,6,2]]
 * 输出: 1
 * 解释:
 * 下面的子矩阵是一个 3 x 3 的幻方：
 * 438
 * 951
 * 276
 * 而这一个不是：
 * 384
 * 519
 * 762
 */
public class NumMagicSquaresInside {
    public static void main(String[] args) {
        int [][]arr = {{4,3,8,4},{9,5,1,9},{2,7,6,2}};
        System.out.println(new NumMagicSquaresInside().find(arr));
    }
    public int find(int [][]arr) {
        int n = arr.length;
        int m = arr[0].length;
        int res = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 2; j++) {
                res += judge(i,j,arr);
            }
        }
        return res;
    }
    private int judge(int x,int y,int [][]g) {
        int []a = new int[10];
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (g[i][j] >= 10 || g[i][j] <= 0)
                    return 0;
                a[g[i][j]]++;
                if (a[g[i][j]] > 1)
                    return 0;
            }
        }
        int sum = -1;
        int temp;
        for (int i = x;i < x + 3; i++) {
            temp = 0;
            for (int j = y; j < y + 3; j++) {
                temp += g[i][j];
            }
            if (sum == -1)
                sum = temp;
            else if (sum != temp)
                return 0;
        }
        for (int j = y; j < y + 3; j++) {
            temp = 0;
            for (int i = x; i < x + 3; i++) {
                temp += g[i][j];
            }
            if (sum != temp)
                return 0;
        }
        temp = g[x][y] + g[x+1][y+1] + g[x+2][y+2];
        if (sum != temp)
            return 0;
        temp = g[x][y+2] + g[x+1][y+1] + g[x+2][y];
        if (sum != temp)
            return 0;
        return 1;
    }
}