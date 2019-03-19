package com.jack.leetcode;

import java.util.Arrays;

/**
 * @Author: Jack
 * @Date: 2019/3/15 18:34
 * LeetCode 961
 * 题目描述
 * 在大小为 2N 的数组 A 中有 N+1 个不同的元素.
 *
 * 其中有一个元素重复了 N 次,返回重复了 N 次的那个元素。
 */
public class NRepeatedElement {
    public static void main(String[] args) {
        int[] arr = {1,2,3,3};
        System.out.println(new NRepeatedElement().repeatedTimes1(arr));
        System.out.println(new NRepeatedElement().repeatedTimes2(arr));
    }
    private int repeatedTimes1(int[] A) {
        Arrays.sort(A);
        return A[A.length / 2] == A[A.length - 1] ? A[A.length / 2] : A[A.length / 2 - 1];
    }
    private int repeatedTimes2(int[] A) {
        Arrays.sort(A);
        return A[0] == A[A.length / 2 - 1] ? A[0] : A[A.length / 2];
    }
}