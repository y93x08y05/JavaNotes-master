package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/10/6 21:59
 * LeetCode 896
 * 单调数列
 * 如果数组是单调递增或单调递减的，那么它是单调的。
 * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。
 * 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
 * 当给定的数组 A 是单调数组时返回 true，否则返回 false。
 * 例1：
 * 输入：[1,2,2,3]
 * 输出：true
 * 例2：
 * 输入：[6,5,4,4]
 * 输出：true
 * 例3
 * 输入：[1,3,2]
 * 输出：false
 * 例4：
 * 输入：[1,2,4,5]
 * 输出：true
 * 例5：
 * 输入：[1,1,1]
 * 输出：true
 */
public class IsMonotonic {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
        for (int i=0;i<n;i++) {
            arr[i]=sc.nextInt();
        }
        System.out.println(new IsMonotonic().find(arr));
    }
    public boolean find(int []arr) {
        int len=arr.length;
        if (len==1)
            return true;
        int i=-1,j=0;
        while (arr[++i]==arr[++j]&&j<len-1);
        if (j==(len-1))
            return true;
        boolean increasing=arr[i]>arr[j]?false:true;
        for (int k=j;k<len;k++) {
            if (increasing&&arr[k]<arr[k-1])
                return false;
            if (!increasing&&arr[k]>arr[k-1])
                return false;
        }
        return true;
    }
}