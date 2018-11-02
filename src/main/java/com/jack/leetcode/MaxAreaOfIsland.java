package com.jack.leetcode;

/**
 * @Author: Jack
 * @Date: 2018/10/6 15:45
 * LeetCode 695
 * 岛屿的最大面积
 * 给定一个包含了一些0和1的非空二维数组grid，一个岛屿是由四个方向，水平或者垂直的1构成的组合
 * 假设二维矩阵的四个边缘都被水包围着。
 * 找到给定的二维数组中最大的岛屿面积。
 * 如果没有岛屿则返回面积值为0。
 * 例1：
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 *  这个给定矩阵应返回 6。岛屿只能包含水平或垂直的四个方向的‘1’。
 *  例2：
 *  [[0,0,0,0,0,0,0,0]]
 * 这个给定的矩阵, 返回 0。
 */
public class MaxAreaOfIsland {
    public static void main(String[] args) {
        int[][] arr = {{0, 0, 0, 0, 0, 0, 0, 0}};
        System.out.println(new MaxAreaOfIsland().find(arr));
    }
    public int find(int[][] arr) {
        int i, j, result = 0;
        for (i = 0; i < arr.length; i++) {
            for (j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1)
                    result = Math.max(countArea(arr, i, j), result);
            }
        }
        return result;
    }
    public int countArea(int[][] arr, int i, int j) {
        if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] != 1)
            return 0;
        arr[i][j] = 0;
        return 1 + countArea(arr, i + 1, j) + countArea(arr, i - 1, j) + countArea(arr, i, j + 1) + countArea(arr, i, j - 1);
    }
}