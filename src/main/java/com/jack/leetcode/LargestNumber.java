package com.jack.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/30 21:12
 * LeetCode 179
 * 最大数
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 * 例1:
 * 输入: [10,2]
 * 输出: 210
 * 例2:
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 */
public class LargestNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
        for (int i=0;i<n;i++) {
            arr[i]=sc.nextInt();
        }
        System.out.println(find(arr));
    }
    private static String find(int []arr) {
        Integer []res=new Integer[arr.length];
        int i=0;
        for (int value:arr)
            res[i++]=Integer.valueOf(value);
        Arrays.sort(res, (o1, o2) -> {
            int l1= o1==0?1: (int) (Math.log10(Math.abs(o1)) + 1);
            int l2= o2==0?1: (int) (Math.log10(Math.abs(o2)) + 1);
            long a1= (long) (o1*Math.pow(10,l2)+o2);
            long a2= (long) (o2*Math.pow(10,l1)+o1);
            return a1>a2?-1:(a1==a2?0:1);
        });
        StringBuilder sb=new StringBuilder();
        for (Integer e:res)
            sb.append(e);
        return sb.toString().replaceFirst("^0+(?!$)","");
    }
}