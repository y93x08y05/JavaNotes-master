package com.jack.leetcode;

import java.util.Arrays;

/**
 * Created by Jack on 8/10/2018 11:05 AM
 * LeetCode 154
 * find Min target from repeated rotated sorted array
 */
public class RotatedSortedArrayRepeatedMin {
    public static void main(String[] args) {
        int [] arr = {2,2,2,0,1};
        System.out.println(findMinFromRepeatedSortedRotated(arr));
    }
    private static int findMinFromRepeatedSortedRotated(int [] arr) {
        Arrays.sort(arr);
        return arr[0];
    }
}
