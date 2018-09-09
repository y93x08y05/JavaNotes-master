package com.jack.nowcoder.autumn.toutiao.TOUTIAO20180909;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/9 9:48
 * 团队个数
 * 5
 * 1 0 0 1 1
 * 1 0 0 1 1
 * 0 0 1 0 0
 * 0 0 1 0 0
 * 0 0 1 0 0
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int  n = sc.nextInt();
        int [][]arr=new int[n][n];
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(findNumberLand(arr));
    }
    private static int findNumberLand(int [][]arr) {
        if (arr==null||arr.length==0||arr[0].length==0)
            return 0;
        int rows=arr.length;
        int cols=arr[0].length;
        int count=0;
        for (int i=0;i<rows;i++) {
            for (int j=0;j<cols;j++) {
                if (arr[i][j]==1) {
                    count++;
                    dfsSearch(arr,i,j,rows,cols);
                }
            }
        }
        return count++;
    }
    private static void dfsSearch(int [][]grid,int i,int j,int rows,int cols) {
        if (i<0||i>=rows||j<0||j>=cols) {
            return;
        }
        if (grid[i][j]!=1)
            return;
        grid[i][j]=0;
        dfsSearch(grid,i+1,j,rows,cols);
        dfsSearch(grid,i-1,j,rows,cols);
        dfsSearch(grid,i,j+1,rows,cols);
        dfsSearch(grid,i,j-1,rows,cols);
    }
}