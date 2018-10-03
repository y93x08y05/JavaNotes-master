package com.jack.algorithm.概览.排序算法;

/**
 * Created by zhangta on 1/5/2018.
 * 每次从待排序数据中选出最小或最大的元素，顺序放在排好序数列最后
 * 比较时间复杂度O(n^2)
 * 交换时间复杂度O(n)
 * 额外空间O(1)
 * 属于不稳定的排序算法
 */
public class sortSelect {
    public static void main(String[] args) {
        int[] data = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 };
        print(data);
        selectSort(data);
        print(data);
    }
    public static void swap(int[] data, int i, int j) {
        if (i == j) {
            return;
        }
        data[i] = data[i] + data[j];
        data[j] = data[i] - data[j];
        data[i] = data[i] - data[j];
    }
    public static void selectSort(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(data, i, minIndex);
                print(data);
            }
        }
    }
    public static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "\t");
        }
        System.out.println();
    }
}
