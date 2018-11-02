package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/8 0:12
 * LeetCode 852
 * 我们把符合下列属性的数组A称作山脉：
 * A.length>=3
 * 存在0<i<A.length-1使得A[0]<A[1]< ...A[i-1]<A[i]>A[i+1]>...>A[A.length-1]
 * 给定一个确定为山脉的数组，
 * 返回任何满足A[0]<A[1]<...A[i-1]<A[i]>A[i+1]>...>A[A.length-1]的i的值。
 * 例1：
 * 输入：[0,1,0]
 * 输出：1
 * 例2：
 * 输入：[0,2,1,0]
 * 输出：1
 */
public class PeekIndexInMountainArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(findIndexOfMountain(arr));
    }
    private static int findIndexOfMountain(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1])
                return i;
        }
        return 0;
    }
}