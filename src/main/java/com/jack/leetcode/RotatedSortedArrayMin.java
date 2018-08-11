package com.jack.leetcode;

import java.util.Arrays;

/**
 * Created by Jack on 8/10/2018 10:53 AM
 * LeetCode 153
 * search Min target from rotate sorted array
 */
public class RotatedSortedArrayMin {
    public static void main(String[] args) {
        int [] arr = {4,5,6,7,0,1,2};
        System.out.println(findMinFromArray(arr));
    }
    private static int findMinFromArray(int [] arr) {
        Arrays.sort(arr);
        return arr[0];
    }
}
