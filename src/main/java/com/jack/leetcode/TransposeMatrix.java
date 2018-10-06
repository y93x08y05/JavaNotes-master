package com.jack.leetcode;

/**
 * @Author: Jack
 * @Date: 2018/10/6 21:12
 * LeetCode 867
 * 转置矩阵
 * 给定一个矩阵 A， 返回 A 的转置矩阵。
 * 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 * 例1：
 * 输入：[[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[1,4,7],[2,5,8],[3,6,9]]
 * 例2：
 * 输入：[[1,2,3],[4,5,6]]
 * 输出：[[1,4],[2,5],[3,6]]
 */
public class TransposeMatrix {
    public static void main(String[] args) {
        int [][]arr={{1,2,3},{4,5,6},{7,8,9}};
        new TransposeMatrix().find(arr);
    }
    public int [][] find(int [][]arr) {
        int n=arr[0].length;
        int m=arr.length;
        int [][]res=new int[n][m];
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                res[i][j]=arr[j][i];
            }
        }
        return res;
    }
}