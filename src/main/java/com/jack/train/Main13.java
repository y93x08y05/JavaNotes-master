package com.jack.train;

import java.util.TreeSet;

/**
 * Created by Jack on 8/3/2018 10:19 AM
 * array if have repeated element and difference of their subscript less than k
 * and difference of their value less than t
 * return true else return false
 */
public class Main13 {
    public static void main(String[] args) {
        int [] arr = {2147483647,-2147483647};
        int k = 1;
        int t = 2147483647;
        System.out.println(ifRepeat(arr, k, t));
    }
    private static boolean ifRepeat(int [] nums,int k,int t) {
         if (nums == null || nums.length == 0 || k <= 0)
             return false;
         TreeSet<Long> ts = new TreeSet();
         for (int i = 0; i < nums.length; ++i) {
             Long right = ts.floor((long) nums[i] + t);
             Long left = ts.ceiling((long) nums[i] - t);
             if (right != null && left != null && right >= left)
                 return true;
             ts.add((long) nums[i]);
             if (i >= k)
                 ts.remove((long) nums[i - k]);
         }
        return false;
    }
}
