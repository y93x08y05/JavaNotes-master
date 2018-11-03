package com.jack.leetcode;

/**
 * @Author: Jack
 * @Date: 2018/10/6 15:23
 * LeetCode 661
 * 图片平滑器
 * 包含整数的二维矩阵表示一个图片的灰度，设计一个平滑器让每一个单元的灰度成为平均灰度
 * 向下舍入，平均灰度的计算是周围的8个单元和它本身的值求平均，
 * 如果周围的单元不足八个，则尽可能多的利用它们。
 * 例：
 * 输入:
 * [[1,1,1],
 *  [1,0,1],
 *  [1,1,1]]
 * 输出:
 * [[0, 0, 0],
 *  [0, 0, 0],
 *  [0, 0, 0]]
 * 解释:
 * 对于点 (0,0), (0,2), (2,0), (2,2): 平均(3/4) = 平均(0.75) = 0
 * 对于点 (0,1), (1,0), (1,2), (2,1): 平均(5/6) = 平均(0.83333333) = 0
 * 对于点 (1,1): 平均(8/9) = 平均(0.88888889) = 0
 */
public class ImageSmoother {
    public static void main(String[] args) {
        int[][] arr = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        new ImageSmoother().find(arr);
    }
    private static final int[] offset = {-1, 0, 1};
    public int[][] find(int[][] arr) {
        if (arr == null || arr.length == 0)
            return null;
        int height = arr.length;
        int width = arr[0].length;
        int[][] result = new int[height][width];
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                int sum = 0;
                int count = 0;
                for (int temp1 : offset) {
                    for (int temp2 : offset) {
                        if (isLegal((h + temp2), (w + temp1), height, width)) {
                            count++;
                            sum += arr[h + temp2][w + temp1];
                        }
                    }
                }
                result[h][w] = sum / count;
            }
        }
        return result;
    }
    private boolean isLegal(int hIndex, int wIndex, int height, int width) {
        if (hIndex < 0 || wIndex < 0 || hIndex >= height || wIndex >= width)
            return false;
        return true;
    }
}