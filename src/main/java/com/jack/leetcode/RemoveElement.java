package com.jack.leetcode;

/**
 * Created by Jack on 8/10/2018 9:28 AM
 * LeetCode 27
 * remove target element from array
 */
public class RemoveElement {
    public static void main(String[] args) {
        int [] arr = {0,1,2,2,3,0,4,2};
        int target = 2;
        System.out.println(removeElement(arr, target));
    }
    private static int removeElement(int [] arr,int val) {
        int len = arr.length;
        int j = 0;
        for (int i=0;i<len;i++) {
            if (arr[i] != val)
                arr[j++] = arr[i];
        }
        return j;
    }
}
