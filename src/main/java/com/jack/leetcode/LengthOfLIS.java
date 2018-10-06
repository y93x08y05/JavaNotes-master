package com.jack.leetcode;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @Author: Jack
 * @Date: 2018/10/6 16:49
 * LeetCode 300
 * 最长上升子序列
 * 给定一个无序整数数组，找出其中最长上升子序列的长度
 * 例：
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 */
public class LengthOfLIS {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
        for (int i=0;i<n;i++) {
            arr[i]=sc.nextInt();
        }
        System.out.println(new LengthOfLIS().find1(arr));
        System.out.println(new LengthOfLIS().find2(arr));
        System.out.println(new LengthOfLIS().find3(arr));
    }
    /*
     * 时间复杂度为O(n^2)
     * 空间复杂度为O(n)
     * maxLens[i]代表arr中第0个到第i个元素以arr[i]为最大值的最大递增序列长度
     */
    public int find1(int []arr) {
        int []maxLens=new int[arr.length];
        int maxLen=0;
        for (int i=0;i<arr.length;i++) {
            for (int j=0;j<i;j++) {
                if (arr[i]>arr[j]) {
                    maxLens[i]=Math.max(maxLens[j]+1,maxLens[i]);
                }
            }
            maxLen=Math.max(maxLen,maxLens[i]+1);
        }
        return maxLen;
    }
    public int find2(int []arr) {
        TreeSet<Integer> set=new TreeSet<>();
        for (int val:arr) {
            Integer ceil= set.ceiling(val);
            if (ceil!=null)
                set.remove(ceil);
            set.add(val);
        }
        return set.size();
    }
    /*
     * 时间复杂度为O(nlogn)
     * 空间复杂度为O(n)
     * maxLens[i]代表arr中第0个到第i个元素最大长度为i的最小值是多少
     */
    public int find3(int []arr) {
        int []maxLens=new int[arr.length+1];
        int maxLen=0;
        for (int val:arr) {
            int len=binarySearch(val,maxLen,maxLens);
            maxLen=Math.max(len,maxLen);
            maxLens[len]=val;
        }
        return maxLen;
    }
    public int binarySearch(int num,int maxLen,int []maxLens) {
        int left=1;
        int right=maxLen;
        while (left<=right) {
            int mid=left+(right-left)/2;
            if (maxLens[mid]<num)
                left=mid+1;
            else
                right=mid-1;
        }
        return left;
    }
}