package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/10/6 10:12
 * LeetCode 81
 * 搜索旋转排序数组2
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 * 编写一个函数来判断给定的目标值是否存在于数组中。
 * 若存在返回 true，否则返回 false。
 * 例1:
 * 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 * 例2:
 * 输入: nums = [2,5,6,0,0,1,2], target = 3
 * 输出: false
 */
public class SearchRotatedArray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int target=sc.nextInt();
        int []arr=new int[n];
        for (int i=0;i<n;i++) {
            arr[i]=sc.nextInt();
        }
        System.out.println(new SearchRotatedArray().find(arr, target));
    }
    private boolean find(int []arr,int target) {
        for (int i=0;i<arr.length;i++) {
            if (target==arr[i])
                return true;
        }
        return false;
    }
}