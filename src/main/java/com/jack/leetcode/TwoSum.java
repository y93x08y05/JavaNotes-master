package com.jack.leetcode;

/**
 * Created by Jack on 8/2/2018 2:38 PM
 * LeetCode 1
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * 例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSum {
    public static void main(String[] args) {
        int [] arr = {2,7,11,15};
        int target = 9;
        int [] arr1 = getValue(arr,target);
        System.out.println(arr1[0] + " " + arr1[1]);

    }
    public static int [] getValue(int [] arr,int target) {
        int [] temp = new int[2];
        for (int i=0;i<arr.length-1;i++) {
            for (int j=i+1;j<arr.length;j++) {
                if (arr[i] + arr[j] == target) {
                    temp[0] = i;
                    temp[1] = j;
                }
            }
        }
        return temp;
    }
}
