package com.jack.leetcode;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author: Jack
 * @Date: 2018/9/22 10:00
 * LeetCode 41
 * 缺失的第一个正数
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 * 例1:
 * 输入: [1,2,0]
 * 输出: 3
 * 例2:
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 例3:
 * 输入: [7,8,9,11,12]
 * 输出: 1
 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
        for (int i=0;i<n;i++) {
            arr[i]=sc.nextInt();
        }
        System.out.println(find0(arr));
        System.out.println(find1(arr));
    }
    private static int find0(int []arr) {
        Set<Integer> set=new HashSet<>();
        int len=arr.length;
        if (len<=0)
            return 1;
        for (int i=0;i<len;i++) {
            set.add(arr[i]);
        }
        int index=1;
        while (set.contains(index++));
        return index-1;
    }
    private static int find1(int []arr) {
        int len=arr.length;
        for (int i=0;i<len;) {
            if (arr[i]!=i+1&&arr[i]>0&&arr[i]<=len&&arr[i]!=arr[arr[i]-1]) {
                swap(i,arr[i]-1,arr);
            } else {
                i++;
            }
        }
        for (int i=1;i<=len;i++) {
            if (arr[i-1]!=i) {
                return i;
            }
        }
        return len+1;
    }
    private static void swap(int i,int j,int []arr) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}