package com.jack.leetcode;

import java.util.Arrays;

/**
 * Created by Jack on 8/19/2018 9:33 PM
 * LeetCode 16
 * latest three number sum with target
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        int [] arr = {-1,2,1,-4};
        int target = 1;
        System.out.println(findSumClosest(arr, target));
    }
    private static int findSumClosest(int [] arr,int target) {
        Arrays.sort(arr);
        int closet=Integer.MAX_VALUE,sub=0,absSub=0,sum=0;
        for (int i=1;i<arr.length-1;i++) {
            int left=0,right=arr.length-1;
            while (left<i&&right>i) {
                sub = arr[left] + arr[right] + arr[i] - target;
                absSub = Math.abs(sub);
                if (closet > absSub){
                    closet = absSub;
                    sum=arr[left]+arr[right]+arr[i];
                }
                if (sub>0)
                    right--;
                else if (sub<0)
                    left++;
                else {
                    sum=arr[left]+arr[right]+arr[i];
                    break;
                }
            }
        }
        return sum;
    }
}
