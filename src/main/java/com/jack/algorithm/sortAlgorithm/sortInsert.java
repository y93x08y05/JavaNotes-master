package com.jack.algorithm.sortAlgorithm;

/**
 * Created by zhangta on 1/5/2018.
 * 直接插入排序
 * 待排序元素按值大小插入前边有序序列，空间复杂度O(1),时间复杂度O(n^2)
 */
public class sortInsert {
    public static void main(String[] args) {
        int[] data = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 };
        print(data);
        insertSort(data);
        print(data);
    }
    public static void insertSort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            // 缓存i处的元素值
            int tmp = data[i];
            if (data[i] < data[i - 1]) {
                int j = i - 1;
                // 整体后移一格
                while (j >= 0 && data[j] > tmp) {
                    data[j + 1] = data[j];
                    j--;
                }
                // 最后将tmp插入合适的位置
                data[j + 1] = tmp;
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
