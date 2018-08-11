package com.jack.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jack on 8/10/2018 11:09 AM
 * LeetCode 454
 * four number sum from four array
 * if firm three number and change one and sum will time out
 * then split as A and B and C and D and then compute
 */
public class FourSumCount {
    public static void main(String[] args) {
        int [] arr1 = {1,2};
        int [] arr2 = {-2,-1};
        int [] arr3 = {-1,2};
        int [] arr4 = {0,2};
        System.out.println(addFourNumber(arr1, arr2, arr3, arr4));
    }
    private static int addFourNumber(int [] A,int [] B,int [] C,int [] D) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<C.length;i++) {
            for (int j=0;j<D.length;j++) {
                int sum = C[i] + D[j];
                map.put(sum,map.getOrDefault(sum,0)+1);
            }
        }
        int res = 0;
        for (int i=0;i<A.length;i++) {
            for (int j=0;j<B.length;j++) {
                res += map.getOrDefault(-1*(A[i]+B[j]),0);
            }
        }
        return res;
    }
}
