package com.jack.train;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Jack on 8/2/2018 10:11 PM
 */
public class Main10 {
    public static void main(String[] args) {
        int [] arr = {3,2,3};
        List<Integer> list = getArray(arr);
        for (int i=0;i<list.size();i++) {
            System.out.print(list.get(i) + " ");
        }
    }
    public static List<Integer> getArray(int [] arr) {
        List<Integer> list = new ArrayList<Integer>();
        int len = arr.length;
        int temp = len/3;
        int m = 0;
        int count = 1;
        Arrays.sort(arr);
        for (int i=m;i<arr.length-1;i++) {
            if (arr[i] == arr[i+1]) {
                count++;
            }
            if (count > temp) {
                if (i-m+1 > temp) {
                    list.add(arr[i]);
                    m = i+1;
                }
            }
        }
        return list;
    }
}
