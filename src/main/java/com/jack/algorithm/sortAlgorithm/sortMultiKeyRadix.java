package com.jack.algorithm.sortAlgorithm;

import java.util.Arrays;

/**
 * Created by zhangta on 1/5/2018.
 * 将待排序数据拆分为多个关键字进行排序，分为最高位优先以及最低位优先，如十位、百位、千位
 * 稳定排序：冒泡排序、直接插入排序、折半插入排序、归并排序、桶排序、基数排序
 * 不稳定排序：希尔排序、直接选择排序、堆排序、快速排序
 */
public class sortMultiKeyRadix {
    public static void main(String[] args) {
        int[] data = new int[] { 1100, 192, 221, 12, 23 };
        print(data);
        radixSort(data, 10, 4);
        System.out.println("排序后的数组：");
        print(data);
    }
    public static void radixSort(int[] data, int radix, int d) {
        // 缓存数组
        int[] tmp = new int[data.length];
        // buckets用于记录待排序元素的信息
        // buckets数组定义了max-min个桶
        int[] buckets = new int[radix];
        for (int i = 0, rate = 1; i < d; i++) {
            // 重置count数组，开始统计下一个关键字
            Arrays.fill(buckets, 0);
            // 将data中的元素完全复制到tmp数组中
            System.arraycopy(data, 0, tmp, 0, data.length);
            // 计算每个待排序数据的子关键字
            for (int j = 0; j < data.length; j++) {
                int subKey = (tmp[j] / rate) % radix;
                buckets[subKey]++;
            }
            for (int j = 1; j < radix; j++) {
                buckets[j] = buckets[j] + buckets[j - 1];
            }
            // 按子关键字对指定的数据进行排序
            for (int m = data.length - 1; m >= 0; m--) {
                int subKey = (tmp[m] / rate) % radix;
                data[--buckets[subKey]] = tmp[m];
            }
            rate *= radix;
        }
    }
    public static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "\t");
        }
        System.out.println();
    }
}
