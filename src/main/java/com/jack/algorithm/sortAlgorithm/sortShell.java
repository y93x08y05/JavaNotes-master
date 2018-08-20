package com.jack.algorithm.sortAlgorithm;

/**
 * Created by zhangta on 1/5/2018.
 * 希尔排序即缩小增量法，是对直接插入排序的改进
 * 加大插入排序中元素之间的间隔，并在有间隔的元素中进行插入排序，使得数据项大跨度移动
 * 排过一次顺序后则减小数据项间隔再进行排序
 * 排序时移动项间隔称之为增量，用h表示，h=3*h+1  h=(h-1)/3
 */
public class sortShell {
    public static void main(String[] args) {
        int[] data = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 };
        print(data);
        shellSort(data);
        print(data);
    }
    public static void shellSort(int[] data) {
        // 计算出最大的h值
        int h = 1;
        while (h <= data.length / 3) {
            h = h * 3 + 1;
        }
        while (h > 0) {
            for (int i = h; i < data.length; i += h) {
                if (data[i] < data[i - h]) {
                    int tmp = data[i];
                    int j = i - h;
                    while (j >= 0 && data[j] > tmp) {
                        data[j + h] = data[j];
                        j -= h;
                    }
                    data[j + h] = tmp;
                    print(data);
                }
            }
            // 计算出下一个h值
            h = (h - 1) / 3;
        }
    }
    public static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "\t");
        }
        System.out.println();
    }
}
