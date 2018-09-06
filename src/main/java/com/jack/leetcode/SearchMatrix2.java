package com.jack.leetcode;

/**
 * @Author: Jack
 * @Date: 2018/9/6 16:24
 * LeetCode 240
 * 编写一个高效的算法来搜索mxn矩阵matrix中的一个目标值target。
 * 该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 现有矩阵 matrix 如下：
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * 给定 target = 20，返回 false。
 */
public class SearchMatrix2 {
    public static void main(String[] args) {
        int [][]matrix={{1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}};
        int target=5;
        System.out.println(searchMatrix(matrix, target));
    }
    private static boolean searchMatrix(int [][]matrix, int target) {
        if (matrix.length==0||matrix[0].length==0)
            return false;
        int i=0;
        int j=matrix[0].length-1;
        while (i<matrix.length&&j>=0) {
            int x=matrix[i][j];
            if (target==x)
                return true;
            else if (target<x)
                --j;
            else
                ++i;
        }
        return false;
    }
}