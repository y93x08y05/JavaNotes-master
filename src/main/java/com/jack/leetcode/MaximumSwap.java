package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/5 16:42
 * LeetCode 670
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 * 例1：
 * 输入: 2736
 * 输出: 7236
 * 解释: 交换数字2和数字7。
 * 例2：
 * 输入: 9973
 * 输出: 9973
 * 解释: 不需要交换。
 */
public class MaximumSwap {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(findMaximumSwap(n));
    }
    private static int findMaximumSwap(int n) {
        if (n<=0)
            return n;
        char []chars=String.valueOf(n).toCharArray();
        int []digitalCount=new int[10];
        for (int i=0;i<chars.length;i++) {
            digitalCount[chars[i]-'0']=i;
        }
        for (int i=0;i<chars.length;i++) {
            for (int j=9;j>chars[i]-'0';j--) {
                if (digitalCount[j]>i) {
                    char temp=chars[i];
                    chars[i]=chars[digitalCount[j]];
                    chars[digitalCount[j]]=temp;
                    String s=new String(chars);
                    return Integer.parseInt(s);
                }
            }
        }
        return n;
    }
}