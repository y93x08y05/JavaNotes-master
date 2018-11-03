package com.jack.leetcode;

/**
 * @Author: Jack
 * @Date: 2018/10/6 16:16
 * LeetCode 463
 * 岛屿的周长
 * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
 * 网格中的格子水平和垂直方向相连（对角线方向不相连）。
 * 整个网格被水完全包围，但其中恰好有一个岛屿
 * （或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。
 * 格子是边长为 1 的正方形。
 * 网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 * 例：
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 * 答案: 16
 */
public class IslandPerimeter {
    public static void main(String[] args) {
        int[][] arr = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        System.out.println(new IslandPerimeter().find(arr));
    }
    public int find(int[][] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        int numOfOne = 0;
        int repeat = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1) {
                    numOfOne++;
                    if (i - 1 >= 0 && arr[i - 1][j] == 1)
                        repeat++;
                    if (i + 1 < arr.length && arr[i + 1][j] == 1)
                        repeat++;
                    if (j - 1 >= 0 && arr[i][j - 1] == 1)
                        repeat++;
                    if (j + 1 < arr[0].length && arr[i][j + 1] == 1)
                        repeat++;
                }
            }
        }
        return numOfOne * 4 - repeat;
    }
}