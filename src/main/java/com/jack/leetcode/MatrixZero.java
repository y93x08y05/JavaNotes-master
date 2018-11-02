package com.jack.leetcode;

import java.util.Scanner;

/**
 * Created by Jack on 8/14/2018 11:15 PM
 * LeetCode 73
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 */
public class MatrixZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0 ;j < arr[0].length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        setMatrixZero1(arr);
        setMatrixZero2(arr);
    }
    private static void setMatrixZero1(int[][] arr) {
        int rowLength = arr.length;
        int colLength = arr[0].length;
        boolean[] rowFlag = new boolean[rowLength];
        boolean[] colFlag = new boolean[colLength];
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (arr[i][j] == 0) {
                    rowFlag[i] = true;
                    colFlag[j] = true;
                }
            }
        }
        for (int i = 0; i < rowLength; i++) {
            if (rowFlag[i]) {
                for (int j = 0; j < colLength; j++)
                    arr[i][j] = 0;
            }
        }
        for (int i = 0; i < colLength; i++) {
            if (colFlag[i]) {
                for (int j = 0; j < rowLength; j++)
                    arr[j][i] = 0;
            }
        }
    }
    private static void setMatrixZero2(int[][] arr) {
        int noZeroRowIndex = -1;
        int rowLength = arr.length;
        int colLength = arr[0].length;
        for (int i = 0; i < rowLength; i++) {
            int index;
            for (index = 0; index < colLength; index++) {
                if (arr[i][index] == 0)
                    break;
            }
            if (index == colLength) {
                noZeroRowIndex = i;
                break;
            }
        }
        if (noZeroRowIndex == -1) {
            for (int i = 0; i < rowLength; i++) {
                for (int j = 0; j < colLength; j++) {
                    arr[i][j] = 0;
                }
            }
        } else {
            for (int i = 0; i < rowLength; i++) {
                for (int j = 0; j < colLength; j++) {
                    if (arr[i][j] == 0)
                        arr[noZeroRowIndex][j] = 0;
                }
            }
            for (int i = 0; i < rowLength; i++) {
                for (int j = 0; j < colLength; j++) {
                    if (i == noZeroRowIndex)
                        continue;
                    if (arr[i][j] == 0)
                        for (int j2 = 0; j2 < colLength; j2++)
                            arr[i][j2] = 0;
                }
            }
            for (int i = 0; i < colLength; i++) {
                if (arr[noZeroRowIndex][i] == 0)
                    for (int j = 0; j < rowLength; j++)
                        arr[j][i] = 0;
            }
        }
    }
}
