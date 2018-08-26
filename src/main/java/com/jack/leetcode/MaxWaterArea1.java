package com.jack.leetcode;

/**
 * Created by Jack on 8/26/2018 7:59 PM
 * LeetCode 11
 * let array has more water and find max value
 */
public class MaxWaterArea1 {
    public static void main(String[] args) {
        int []arr={1,8,6,2,5,4,8,3,7};
        System.out.println(findMaxWaterArea(arr));
    }
    private static int findMaxWaterArea(int []arr) {
        int max=Integer.MIN_VALUE;
        for (int i=0;i<arr.length-1;i++) {
            for (int j=i+1;j<arr.length;j++) {
                if (Math.min(arr[i],arr[j])*(j-i)>max)
                    max=Math.min(arr[i],arr[j])*(j-i);
            }
        }
        return max;
    }
}
