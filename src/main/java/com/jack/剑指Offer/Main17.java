package com.jack.剑指Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Jack on 7/31/2018 10:17 PM
 * 输入包含N个正整数的数组，返回最小的K个正整数
 */
public class Main17 {
    public static void main(String[] args) {
        int [] arr = {4,5,1,6,2,7,3,8};
        int k = 4;
        getSmallestK(arr,k);
    }
    public static List<Integer> getSmallestK(int [] arr,int k) {
        List<Integer> list = new ArrayList<>();
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
