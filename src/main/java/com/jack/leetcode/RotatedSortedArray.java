package com.jack.leetcode;

/**
 * Created by Jack on 8/10/2018 10:34 AM
 * LetCode 33
 * search target from rotate sorted array
 */
public class RotatedSortedArray {
    public static void main(String[] args) {
        int [] arr = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(searchTarget(arr, target));
    }
    private static int searchTarget(int [] arr,int val) {
        for (int i=0;i<arr.length;i++)
            if (arr[i] == val)
                return i;
        return -1;
    }
}
