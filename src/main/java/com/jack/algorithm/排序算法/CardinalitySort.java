package com.jack.algorithm.排序算法;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jack on 7/24/2018 10:18 PM
 * 基数排序是稳定的
 */
public class CardinalitySort {
    public static void main(String[] args) {
        new CardinalitySort().method(PrintSortedValue.a);
        new PrintSortedValue().printValue(PrintSortedValue.a);
    }
    public void method(int [] arr) {
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
