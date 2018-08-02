package com.jack.util;

/**
 * Created by Jack on 7/30/2018 11:47 AM
 * find if have value in array or not, if not return -1 else return subscript which first appear
 */
public class BinarySearch {
    public static void main(String[] args) {
        int [] a = {1,3,5,7,9};
        int m = a.length;
        int val = 3;
        System.out.println(getPosition(a, m, val));
    }
    public static int getPosition(int [] a,int m,int val) {
        int result = -1;
        int position;
        int left = 0;
        int right = m;
        position = (left + right)/2;
        while (position >= left && position <= right) {
            if (a[position] > val) {
                right = position;
                position = (left + right)/2;
            } else if (a[position] < val) {
                left = position;
                position = (left + right)/2;
            } else {
                result = position;
                for (int i=0;i<=position;i++) {
                    if (a[position-i] == val) {
                        result = position - i;
                    } else {
                        return result;
                    }
                    return result;
                }
                return result;
            }
        }
        return result;
    }
}
