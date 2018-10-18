package com.jack.algorithm.排序算法;

import java.util.LinkedList;

/**
 * Created by Jack on 7/23/2018 8:56 PM
 * 快速排序是不稳定的
 */
public class QuickSort {
    public static void main(String[] args) {
        quickSort(PrintSortedValue.a,0,PrintSortedValue.a.length-1);
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

    /*
     * 快速排序的非递归实现
     */
    private static void quickSort(int []a, int start, int end) {
        LinkedList<Integer> stack = new LinkedList<>();
        if (start < end) {
            stack.push(end);
            stack.push(start);
            while (!stack.isEmpty()) {
                int l = stack.pop();
                int r = stack.pop();
                int index = partition(a, l, r);
                if (l < index - 1) {
                    stack.push(index - 1);
                    stack.push(l);
                }
                if (r > index + 1) {
                    stack.push(r);
                    stack.push(index + 1);
                }
            }
        }
        new PrintSortedValue().printValue(a);
    }
    private static int partition(int []a, int start, int end) {
        int pivot = a[start];
        while (start < end) {
            while (start < end && a[end] >= pivot) {
                end--;
            }
            a[start] = a[end];
            while (start < end && a[start] <= pivot) {
                start++;
            }
            a[end] = a[start];
        }
        a[start] = pivot;
        return start;
    }
}
