package com.jack.coding;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Jack on 7/31/2018 10:17 PM
 * enter n integers to find smallest k integers
 */
public class Main17 {
    public static void main(String[] args) {
        int [] arr = {4,5,1,6,2,7,3,8};
        int k = 4;
        getSmallestK(arr,k);
    }
    public static ArrayList<Integer> getSmallestK(int [] arr,int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (arr.length < k) {
            return list;
        }
        Arrays.sort(arr);
        for (int i=0;i<k;i++) {
            list.add(arr[i]);
        }
        return list;
    }
}
