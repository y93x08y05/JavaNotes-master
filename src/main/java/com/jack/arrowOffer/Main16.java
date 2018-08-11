package com.jack.arrowOffer;

import java.util.Arrays;

/**
 * Created by Jack on 7/31/2018 10:10 PM
 * a number in the array that appears more than half of the number
 * if exists output this number else output 0
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
