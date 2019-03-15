package com.jack.leetcode;

import java.util.Arrays;

/**
 * @Author: Jack
 * @Date: 2019/3/6 16:37
 * LeetCode 832
 * 给定一个二进制矩阵A，先水平翻转图像，再反转图像并返回结果。
 * 水平翻转是将每一行逆序,反转图片是将0全部替换为1，将1全部替换为0。
 */
public class FlippingAnImage {
    public static void main(String[] args) {
        FlippingAnImage fli = new FlippingAnImage();
        int[][] arr = {{1,1,0},{1,0,1},{0,0,0}};
        System.out.println(Arrays.deepToString(fli.flipAndInvertImage(arr)));
    }
    private int[][] flipAndInvertImage(int[][] A) {
        if (A == null || A.length == 0) {
            return A;
        }
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length / 2; j++) {
                int temp = A[i][j];
                A[i][j] = A[i][A[i].length - 1 - j];
                A[i][A[i].length - 1 - j] = temp;
            }
            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] == 1) {
                    A[i][j] = 0;
                } else {
                    A[i][j] = 1;
                }
            }
        }
        return A;
    }
}