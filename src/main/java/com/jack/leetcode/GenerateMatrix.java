package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/10/7 14:27
 * LeetCode 59
 * 螺旋矩阵2
 * 给定一个正整数n，生成一个包含1到n2所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * 例：
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */
public class GenerateMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] res = new GenerateMatrix().find(n);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
    public int[][] find(int n) {
        int[][] arr = new int[n][n];
        int val = 1;
        int li = 0, lj = 0, ri = arr.length - 1, rj = arr[0].length - 1;
        while (li <= ri && lj <= rj) {
            int i = li;
            int j = lj;
            while (j <= rj) {
                arr[i][j] = val++;
                j++;
            }
            --j;
            ++i;
            while (i <= ri) {
                arr[i][j] = val++;
                i++;
            }
            --i;
            --j;
            while (j > lj && li != ri) {
                arr[i][j] = val++;
                j--;
            }
            while (i > li && lj != rj) {
                arr[i][j] = val++;
                i--;
            }
            li++;
            lj++;
            ri--;
            rj--;
        }
        return arr;
    }
}