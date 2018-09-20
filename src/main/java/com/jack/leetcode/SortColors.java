package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/20 9:24
 * LeetCode 75
 * 颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，
 * 原地对它们进行排序，
 * 使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 示例:
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 不能使用代码库中的排序函数来解决这道题。
 * 例1:
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，
 * 然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 */
public class SortColors {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
        for (int i=0;i<n;i++) {
            arr[i]=sc.nextInt();
        }
        method1(arr);
        method2(arr);
    }
    private static void method1(int []arr) {
        if (arr==null||arr.length<=1)
            return;
        int zero=0;
        int one=0;
        int two=0;
        for (int i=0;i<arr.length;i++) {
            if (arr[i]==0)
                zero++;
            if (arr[i]==1)
                one++;
            if (arr[i]==2)
                two++;
        }
        for (int i=0;i<arr.length;i++) {
            if (zero>0) {
                arr[i]=0;
                zero--;
                continue;
            }
            if (one>0) {
                arr[i]=1;
                one--;
                continue;
            }
            if (two>0) {
                arr[i]=2;
                two++;
            }
        }
    }
    /**
     * 两个指针，一个指在当前0的最后一个下标，
     * 一个指在当前1的最后一个下标，进行一次扫描
     * 有0就两个指针都前进一步并进行赋值
     * 有1则后一个指针前进一步并赋值
     * @param arr
     */
    private static void method2(int []arr) {
        if (arr==null||arr.length<=1)
            return;
        int index0=0;
        int index1=0;
        for (int i=0;i<arr.length;i++) {
            if (arr[i]==0) {
                arr[i]=2;
                arr[index1++]=1;
                arr[index0++]=0;
            } else if (arr[i]==1) {
                arr[i]=2;
                arr[index1++]=1;
            }
        }
    }
}