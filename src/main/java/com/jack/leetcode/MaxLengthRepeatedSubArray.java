package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/5 14:19
 * LeetCode 718
 * 给两个整数数组A和B ，返回两个数组中公共的、长度最长的子数组的长度。
 * 例子：
 * 输入:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出: 3
 * 解释:
 * 长度最长的公共子数组是 [3, 2, 1]。
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 */
public class MaxLengthRepeatedSubArray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int []arr1=new int[n];
        int []arr2=new int[m];
        for (int i=0;i<arr1.length;i++) {
            arr1[i]=sc.nextInt();
        }
        for (int i=0;i<arr2.length;i++) {
            arr2[i]=sc.nextInt();
        }
        System.out.println(findCommonLength(arr1, arr2));
    }
    private static int findCommonLength(int []A, int []B) {
        int res=0;
        int [][]dp=new int[A.length+1][B.length+1];
        for (int i=0;i<A.length;i++) {
            for (int j=0;j<B.length;j++) {
                if (A[i]==B[j]) {
                    dp[i+1][j+1]=dp[i][j]+1;
                }
                res=Math.max(res,dp[i+1][j+1]);
            }
        }
        return res;
    }
}