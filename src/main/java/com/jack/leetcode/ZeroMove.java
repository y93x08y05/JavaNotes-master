package com.jack.leetcode;

/**
 * Created by Jack on 8/10/2018 10:03 AM
 * LeetCode 283
 * move zero to array end and keep non zero array element sequence
 */
public class ZeroMove {
    public static void main(String[] args) {
        int [] arr = {0,1,0,3,2};
        moveZero(arr);
    }
    private static void moveZero(int [] arr) {
        int len = arr.length;
        int count = 0;
        for (int i=0;i<len-count;i++) {
            if (arr[i] == 0) {
                int j = i;
                while (j<len-1) {
                    arr[j] = arr[j+1];
                    j++;
                }
                arr[len-1] = 0;
                count++;
                i--;
            }
        }
    }
}
