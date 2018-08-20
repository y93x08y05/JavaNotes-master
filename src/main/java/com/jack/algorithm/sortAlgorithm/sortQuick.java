package com.jack.algorithm.sortAlgorithm;

/**
 * Created by zhangta on 1/5/2018.
 * 快速排序，即从待排序中随机选取一个数据作为分界值，
 * 并使得小的元素位于其左，大的元素位于其右，一般选择数组第一个为临界值
 * 再对子序列进行递归排序，重新选择分界值，直到每个元素子表只剩一个元素
 * 最好情况下,时间复杂度为O(nlogn)
 */
public class sortQuick {
    public static void main(String[] args) {
        int[] data = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 };
//        int[] data = new int[] { 46, 79, 56, 38, 40, 84 };
        print(data);
        quickSort(data, 0, data.length - 1);
        System.out.println("排序后的数组：");
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
    public static void quickSort(int[] data, int start, int end) {
        if (start >= end)
            return;
        //以起始索引为分界点
        int pivot = data[start];
        int i = start + 1;
        int j = end;
        while (true) {
            while (i <= end && data[i] < pivot) {
                i++;
            }
            while (j > start && data[j] > pivot) {
                j--;
            }
            if (i < j) {
                swap(data, i, j);
            } else {
                break;
            }
        }
        //交换 j和分界点的值
        swap(data, start, j);
        print(data);
        //递归左子序列
        quickSort(data, start, j - 1);
        //递归右子序列
        quickSort(data, j + 1, end);
    }
    public static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "\t");
        }
        System.out.println();
    }
}
