package com.jack.leetcode;

import java.util.Arrays;

/**
 * Created by Jack on 8/19/2018 9:33 PM
 * LeetCode 16
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。
 * 假定每组输入只存在唯一答案。
 * 例，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
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
