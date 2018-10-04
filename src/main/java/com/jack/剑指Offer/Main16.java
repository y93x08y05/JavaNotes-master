package com.jack.剑指Offer;

import java.util.Arrays;

/**
 * Created by Jack on 7/31/2018 10:10 PM
 * 找到在数组中出现次数超过一半的数，如果找到了则输出，否则输出0
 */
public class Main16 {
    public static void main(String[] args) {
        int [] arr = {1,2,3,2,2,2,5,4,2};
        Arrays.sort(arr);
        int count = 0;
        for (int i=0;i<arr.length;i++) {
            if (arr[i] == arr[arr.length/2]) {
                count++;
            }
        }
        if (count > arr.length/2) {
            System.out.println(arr[arr.length/2]);
        } else {
            System.out.println(0);
        }
    }
}
