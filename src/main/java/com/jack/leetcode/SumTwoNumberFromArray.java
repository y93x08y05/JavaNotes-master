package com.jack.leetcode;

/**
 * Created by Jack on 8/9/2018 2:05 PM
 * LeetCode 167
 * find two number sum == target from array
 */
public class SumTwoNumberFromArray {
    public static void main(String[] args) {
        int [] arr = {2,7,11,15};
        int target = 9;
        findSum(arr,target);
    }
    private static int [] findSum(int [] arr,int target) {
        int [] temp = new int[2];
        for (int i=0;i<arr.length-1;i++) {
            for (int j=i+1;j<arr.length;j++) {
                if (arr[i] + arr[j] == target) {
                    temp[0] = i + 1;
                    temp[1] = j + 1;
                    return temp;
                }
            }
        }
        return temp;
    }
}
