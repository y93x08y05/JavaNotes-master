package com.jack.algorithm.sortAlgorithm;

/**
 * Created by zhangta on 1/5/2018.
 * 归并排序中，数组需要O(n)空间，链表需要O(log(n))空间，时间复杂度为O(nlog(n))
 * 待排序序列分为若干子序列，每个子序列有序，子序列合并为整体有序序列
 */
public class sortMerge {
    public static void main(String[] args) {
        int[] data = new int[] { 5, 3, 6, 2, 8, 4, 7, 1 };
        print(data);
        mergeSort(data);
        System.out.println("排序后的数组：");
        print(data);
    }

    public static void mergeSort(int[] data) {
        mergeSort(data, 0, data.length - 1);
    }
    public static void mergeSort(int[] data, int left, int right) {
        if (left>=right)
            return;
        int center=(left+right)/2;
        mergeSort(data,left,center);
        mergeSort(data,center+1,right);
        merge(data,left,center,right);
        print(data);
    }
    public static void merge(int[] data, int left, int center, int right) {
        System.out.println(left+" "+center+" "+right);
        int[] tmpArr = new int[data.length];
        int mid = center + 1;
        int third = left;
        int tmp = left;
        while (left <= center && mid <= right) {
            if (data[left]<=data[mid])
                tmpArr[third++]=data[left++];
            else
                tmpArr[third++]=data[mid++];
        }
        while (mid <= right)
            tmpArr[third++] = data[mid++];
        while (left <= center)
            tmpArr[third++] = data[left++];
        while (tmp <= right)
            data[tmp] = tmpArr[tmp++];
    }
    public static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "\t");
        }
        System.out.println();
    }
}
