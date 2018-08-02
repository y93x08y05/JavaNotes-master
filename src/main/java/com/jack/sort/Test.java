package com.jack.sort;

import java.util.HashMap;

/**
 * Created by Jack on 7/27/2018 2:53 PM
 */
public class Test {
    public static void main(String [] args) {
        int [] arr = {5,9,4,2,1,8,3,6,7};
        int temp;
        for(int i=1;i<arr.length;i++) {
            temp = arr[i];
            int j = i-1;
            for(;j>=0 && temp < arr[j];j--) {
                arr[j+1] = arr[j];
            }
            arr[j+1] = temp;
        }
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
