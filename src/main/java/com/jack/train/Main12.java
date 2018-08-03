package com.jack.train;

/**
 * Created by Jack on 8/3/2018 9:49 AM
 * array if have repeated element and difference of their subscript less than k
 * return true else return false
 */
public class Main12 {
    public static void main(String[] args) {
        int [] arr = {1,0,1,1};
        int k = 2;
        System.out.println(ifRepeat(arr, k));
    }
    private static boolean ifRepeat(int [] nums,int k) {
        int min = Integer.MAX_VALUE;
        for (int i=0;i<nums.length-1;i++) {
            for (int j=i+1;j<nums.length;j++) {
                if (nums[i] == nums[j]) {
                    if (j - i < min) {
                        min = j-i;
                    }
                    if (min <= k)
                        return true;
                }
            }
        }
        return false;
    }
}
