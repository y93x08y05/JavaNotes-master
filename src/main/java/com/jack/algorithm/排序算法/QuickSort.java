package com.jack.algorithm.排序算法;

import java.util.LinkedList;

/**
 * Created by Jack on 7/23/2018 8:56 PM
 * 快速排序是不稳定的
 */
public class QuickSort {
    public static void main(String[] args) {
        new QuickSort().quickSort(PrintSortedValue.a,0,PrintSortedValue.a.length-1);
//        new QuickSort().method(PrintSortedValue.a,0,PrintSortedValue.a.length-1);
    }
    /*
     * 快速排序的递归实现
     */
    public void method(int [] a, int low, int high) {
        if (low < high) {
            int mid = getMid(a,low,high);
            method(a,low,mid-1);
            method(a,mid+1,high);
        }
    }
    /*
     * 快速排序的非递归实现
     */
    public void quickSort(int []a, int low, int high) {
        LinkedList<Integer> stack = new LinkedList<>();
        if (low < high) {
            stack.push(high);
            stack.push(low);
            while (!stack.isEmpty()) {
                int l = stack.pop();
                int r = stack.pop();
                int mid = getMid(a, l, r);
                if (l < mid - 1) {
                    stack.push(mid - 1);
                    stack.push(l);
                }
                if (r > mid + 1) {
                    stack.push(r);
                    stack.push(mid + 1);
                }
            }
        }
        new PrintSortedValue().printValue(a);
    }
    public int getMid(int [] a, int low, int high) {
        int temp = a[low];
        while (low < high) {
            while (low < high && a[high] >= temp) {
                high--;
            }
            a[low] = a[high];
            while (low < high && a[low] <= temp) {
                low++;
            }
            a[high] = a[low];
        }
        a[low] = temp;
        new PrintSortedValue().printValue(a);
        return low;
    }
}
