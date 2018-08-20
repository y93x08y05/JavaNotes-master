package com.jack.algorithm.sortAlgorithm;

/**
 * Created by zhangta on 1/5/2018.
 * 堆排序是指利用堆的结构设计的,最坏时间复杂度为O(nlog2n)
 * 每种排序算法在时间效率十分关键，对于大数据量的排序而言
 * 堆排序为不稳定的排序
 */
public class sortHeap {
    public static void main(String[] args) {
        int[] data5 = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 };
        print(data5);
        heapSort(data5);
        System.out.println("排序后的数组：");
        print(data5);
    }
    public static void swap(int[] data, int i, int j) {
        if (i == j) {
            return;
        }
        data[i] = data[i] + data[j];
        data[j] = data[i] - data[j];
        data[i] = data[i] - data[j];
    }
    public static void heapSort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            createMaxHeap(data, data.length - 1 - i);
            swap(data, 0, data.length - 1 - i);
            print(data);
        }
    }
    public static void createMaxHeap(int[] data, int lastIndex) {
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            // 保存当前正在判断的节点
            int k = i;
            // 若当前节点的子节点存在
            while (2 * k + 1 <= lastIndex) {
                // biggerIndex总是记录较大节点的值,先赋值为当前判断节点的左子节点
                int biggerIndex = 2 * k + 1;
                if (biggerIndex < lastIndex) {
                    // 若右子节点存在，否则此时biggerIndex应该等于 lastIndex
                    if (data[biggerIndex] < data[biggerIndex + 1]) {
                        // 若右子节点值比左子节点值大，则biggerIndex记录的是右子节点的值
                        biggerIndex++;
                    }
                }
                if (data[k] < data[biggerIndex]) {
                    // 若当前节点值比子节点最大值小，则交换2者得值，交换后将biggerIndex值赋值给k
                    swap(data, k, biggerIndex);
                    k = biggerIndex;
                } else {
                    break;
                }
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
