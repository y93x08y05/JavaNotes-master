package com.jack.train;

import java.util.Arrays;

/**
 * Created by Jack on 8/3/2018 9:31 AM
 * array if have repeated element return true else return false
 */
public class Main11 {
    public static void main(String[] args) {
        int [] arr = {1,2,1,4};
        System.out.println(ifRepeat(arr));
    }
    private static boolean ifRepeat(int [] arr) {
        Arrays.sort(arr);
        for (int i=0;i<arr.length-1;i++) {
            if (arr[i] == arr[i+1])
                return true;
        }
        return false;
    }
}
