package com.jack.nowcoder.spring.ArrowOffer;

/**
 * 在一个二维数组中每行都按照从左到右递增的顺序排列
 * 每一列都按照从上到下递增的顺序排列
 * 输入一个二维数组和一个整数，判断数组中是否存在该整数
 * 矩阵是有序的，从左下角，向上数字递减，向右数字递增
 * 从左下角查找，要查找的数字大于左下角右移，小于左下角上移。
 */
public class ArraySearch {
    public static void main(String [] args) {
        int array[][] = {{1,2,3},{2,3,4}};
        int target = 4;
        System.out.println(find(array, target));
    }

    private static boolean find(int [][] array,int target) {
        int row = 0;
        int col = array[0].length-1;
        while (row <= array.length-1 && col >= 0) {
            if (target == array[row][col]) {
                return true;
            } else if (target > array[row][col]){
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}