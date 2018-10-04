package com.jack.algorithm.排序算法;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack on 7/24/2018 10:18 PM
 * cardinality mergeSort stable
 */
public class cardinalitySort {
    public static void main(String[] args) {
        int a[] = {2,5,7,1,3,9,6,8,4};
        sort(a);
        for (int i=0;i<a.length;i++) {
            System.out.print(a[i] + " ");
        }
    }

    /**
     * has some error in this mergeSort method
     * @param arr
     */
    public static void sort(int [] arr) {
        int max = arr[0];
        for (int i=1;i<arr.length;i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int time = 0;
        while (max > 0) {
            max /= 10;
            time++;
        }
        List<ArrayList> lists = new ArrayList<ArrayList>();
        for (int i=0;i<10;i++) {
            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            lists.add(arrayList);
        }
        for (int i=0;i<time;i++) {
            for (int j=0;j<arr.length;j++) {
                int x = arr[j] % (int)Math.pow(10,i+1) / (int)Math.pow(10,i);
                ArrayList<Integer> arrayList1 = lists.get(x);
                arrayList1.add(arr[j]);
                lists.add(x,arrayList1);
            }
            int count = 0;
            for (int k=0;k<10;k++) {
                while (lists.get(k).size() > 0) {
                    ArrayList<Integer> arrayList2 = lists.get(k);
                    arr[count] = arrayList2.get(0);
                    arrayList2.remove(0);
                    count++;
                }
            }
        }
    }
}
