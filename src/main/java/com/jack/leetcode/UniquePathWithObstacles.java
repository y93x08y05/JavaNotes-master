package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/29 15:54
 * LeetCode 63
 * 不同路径2
 * 一个机器人位于一个mxn网格的左上角，起始点标记为start
 * 机器人每次只能向下或者向右移动一步，机器人试图达到网格的右下角
 * 终点标记为finish
 * 网格中的障碍物用1表示，从左上角到右下角又多少条不同的路径
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * m 和 n 的值均不超过 100。
 * 例1：
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 */
public class UniquePathWithObstacles {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int [][]arr=new int[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        System.out.println(new UniquePathWithObstacles().find(arr));
    }
    private int find(int [][]grid) {
        int [][]path=new int[grid.length][grid[0].length];
        int i=0;
        int j=0;
        for (i=0;i<grid.length;i++) {
            for (j=0;j<grid[0].length;j++) {
                if (grid[i][j]==1) {
                    path[i][j]=0;
                } else if (i==0&&j==0) {
                    path[i][j]=1;
                } else if (i==0&&j>0) {
                    path[i][j]=path[i][j-1];
                } else if (j==0&&i>0) {
                    path[i][j]=path[i-1][j];
                } else {
                    path[i][j]=path[i-1][j]+path[i][j-1];
                }
            }
        }
        return path[i-1][j-1];
    }
}