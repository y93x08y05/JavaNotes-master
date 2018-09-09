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
    private static boolean ifRepeat(int [] num,int k,int t) {
         if (num == null || num.length == 0 || k <= 0)
             return false;
         TreeSet<Long> ts = new TreeSet();
         for (int i = 0; i < num.length; ++i) {
             Long right = ts.floor((long) num[i] + t);
             Long left = ts.ceiling((long) num[i] - t);
             if (right != null && left != null && right >= left)
                 return true;
             ts.add((long) num[i]);
             if (i >= k)
                 ts.remove((long) num[i - k]);
         }
        return false;
    }
}
