package com.jack.leetcode;

/**
 * @Author: Jack
 * @Date: 2018/10/7 11:21
 * LeetCode 48
 * 旋转图像
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。
 * 请不要使用另一个矩阵来旋转图像。
 * 例1:
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * 例2:
 * 给定 matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 */
public class RotateImage {
    public static void main(String[] args) {
        int [][]arr = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        new RotateImage().find(arr);
    }
    /*
     * 将矩阵分为四块，以左上角为基准将对应的四个方向依次交换元素
     * 左上<--左下
     * 左下<--右下
     * 右下<--右上
     * 右上<--左上
     */
    public void find(int [][]arr) {
        int n=arr.length;
        int temp;
        for (int i=0;i<=(n-1)/2;i++) {
            for (int j=i;j<n-1-i;j++) {
                temp=arr[i][j];
                arr[i][j]=arr[n-1-j][i];
                arr[n-1-j][i]=arr[n-1-i][n-1-j];
                arr[n-1-i][n-1-j]=arr[j][n-1-i];
                arr[j][n-1-i]=temp;
            }
        }
    }
}