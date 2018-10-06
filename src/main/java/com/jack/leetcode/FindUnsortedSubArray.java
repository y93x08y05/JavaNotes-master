package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/10/6 14:35
 * LeetCode 581
 * 最短无序连续子数组
 * 给定一个整数数组，找到一个连续的子数组，如果对这个子数组进行升序排序
 * 那么整个数组都会变成升序排序。找到的子数组应该是最短的，并且输出其长度。
 * 例：
 * 输入: [2, 6, 4, 8, 10, 9, 15]
 * 输出: 5
 * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 */
public class FindUnsortedSubArray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
        for (int i=0;i<n;i++) {
            arr[i]=sc.nextInt();
        }
        System.out.println(new FindUnsortedSubArray().find(arr));
    }
    /*
     * 从左往右遍历，如果有序，则当前值一定是已经遍历到的最大值位置
     * 从右往左遍历，当前位置一定是已经遍历到的最小值位置
     * 否则记住起始和终止位置再加1即可
     */
    private int find(int []arr) {
        int len=arr.length;
        int max=arr[0];
        int min=arr[len-1];
        int begin=-1;
        int end=-2;
        for (int i=1;i<len;i++) {
            max=Math.max(max,arr[i]);
            min=Math.min(min,arr[len-i-1]);
            if (max>arr[i])
                end=i;
            if (min<arr[len-i-1])
                begin=len-i-1;
        }
        return end-begin+1;
    }
}