package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/8 12:54
 * LeetCode 306
 * 累加数是一个字符串，组成它的数字可以形成累加序列。
 * 一个有效的累加序列必须至少包含 3 个数。
 * 除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
 * 给定一个只包含数字 '0'-'9' 的字符串，
 * 编写一个算法来判断给定输入是否是累加数。
 * 说明: 累加序列里的数不会以 0 开头，
 * 所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
 * 例1:
 * 输入: "112358"
 * 输出: true
 * 解释: 累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * 例2:
 * 输入: "199100199"
 * 输出: true
 * 解释: 累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199
 */
public class AdditiveNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        System.out.println(isAdditiveNumber(s));
    }
    private static boolean isAdditiveNumber(String s) {
        int L=s.length();
        for (int i=1;i<=(L-1)/2;i++) {
            if (s.startsWith("0")&&i>=2)
                break;
            for (int j=i+1;(L-j)>=i&&(L-j)>=j-i;j++) {
                if (s.charAt(i)=='0'&&j-i>=2)
                    break;
                long num1=Long.parseLong(s.substring(0,i));
                long num2=Long.parseLong(s.substring(i,j));
                if (isAdditive(s.substring(j),num1,num2)) {
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean isAdditive(String remain,long num1,long num2) {
        if (remain.equals(""))
            return true;
        long sum=num1+num2;
        String sumStr=""+sum;
        if (!remain.startsWith(sumStr))
            return false;
        return isAdditive(remain.substring(sumStr.length()),num2,sum);
    }
}