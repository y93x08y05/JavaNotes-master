package com.jack.nowcoder.autumn.Gbit;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/4 11:29
 * 给定一个数列，其中可能有整数也可能有负数
 * 我们的任务是找出其中连续的一个子序列，使得他们的和
 * 尽可能小
 * 输入描述：
 * 第一行，一个数字N，N<1000
 * 第二行，N个数字，每个数字X，-10000-10000
 * 输出描述：
 * 子数列最小和
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
        for (int i=0;i<arr.length;i++) {
            arr[i]=sc.nextInt();
        }
        System.out.println(findMinValue(arr));
    }
    private static int findMinValue(int []arr) {
        int sum=Integer.MAX_VALUE;
        int temp;
        for (int i=0;i<arr.length-1;i++) {
            temp=arr[i];
            if (temp<sum)
                sum=temp;
            for (int j=i+1;j<arr.length;j++) {
                temp=temp+arr[j];
                if (temp<sum)
                    sum=temp;
            }
        }
        return sum;
    }
}