package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/10/6 14:48
 * LeetCode 665
 * 非递减数列
 * 给定一个长度为n的整数数组，判断在最多改变1个元素的情况下，
 * 该数组能不能变成一个非递减数列
 * 非递减数列：对于数组中所有的 i (1 <= i < n)，满足 array[i] <= array[i + 1]
 * 例1:
 * 输入: [4,2,3]
 * 输出: True
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 * 例2:
 * 输入: [4,2,1]
 * 输出: False
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 */
public class CheckPossibility {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
        for (int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        System.out.println(new CheckPossibility().find(arr));
    }
    private boolean find(int []arr) {
        if (arr==null||arr.length<=1)
            return true;
        boolean found=false;
        for (int i=1;i<arr.length;i++) {
            if (arr[i]<arr[i-1]) {
                if (found)
                    return false;
                else {
                    if (i-2>=0&&arr[i]<arr[i-2])
                        arr[i]=arr[i-1];
                    found=true;
                }
            }
        }
        return true;
    }
}