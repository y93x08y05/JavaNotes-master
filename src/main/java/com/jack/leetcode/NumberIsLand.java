package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/9 18:31
 * LeetCode 200
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
 * 一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。
 * 你可以假设网格的四个边均被水包围。
 * 例1：
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 * 例2：
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 */
public class NumberIsLand {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        char [][]arr={{1,1,1,1,0},{1,1,0,1,0},{1,1,0,0,0},{0,0,0,0,0}};
        System.out.println(findNumberLand(arr));
    }
    private static int findNumberLand(char [][]arr) {
        if (arr==null||arr.length==0||arr[0].length==0)
            return 0;
        int rows=arr.length;
        int cols=arr[0].length;
        int count=0;
        for (int i=0;i<rows;i++) {
            for (int j=0;j<cols;j++) {
                if (arr[i][j]=='1') {
                    count++;
                    dfsSearch(arr,i,j,rows,cols);
                }
            }
        }
        return count++;
    }
    private static void dfsSearch(char [][]grid,int i,int j,int rows,int cols) {
        if (i<0||i>=rows||j<0||j>=cols) {
            return;
        }
        if (grid[i][j]!='1')
            return;
        grid[i][j]='0';
        dfsSearch(grid,i+1,j,rows,cols);
        dfsSearch(grid,i-1,j,rows,cols);
        dfsSearch(grid,i,j+1,rows,cols);
        dfsSearch(grid,i,j-1,rows,cols);
    }
}