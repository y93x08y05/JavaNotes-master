package com.jack.util;

/**
 * Created by Jack on 7/30/2018 11:47 AM
 * 二分法搜索，如果能够找到则返回数组的下标，否则返回-1
 */
public class BinarySearch {
    public int getPosition(int []arr,int val) {
        int m = arr.length;
        return getPosition(arr, m, val);
    }
    public int getPosition(int [] a,int m,int val) {
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
